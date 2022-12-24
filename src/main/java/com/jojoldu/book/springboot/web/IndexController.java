package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.qna.Qna;
import com.jojoldu.book.springboot.domain.reservation.Reservation;
import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.service.program.ProgramService;
import com.jojoldu.book.springboot.service.qna.QnaService;
import com.jojoldu.book.springboot.service.reservation.ReservationService;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final ProgramService programService;
    private final QnaService qnaService;
    private final ReservationService reservationService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/hanip")
    public String hanip(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }

        return "hanip";
    }

    @GetMapping("/information")
    public String information(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "information";
    }

    @GetMapping("/program")
    public String program(Model model, @LoginUser SessionUser user, @PageableDefault(size = 10) Pageable pageable) {

        PageProgramListResponseDto tpagenatedProgramData = programService.findPagenatedPrograms(pageable);

        model.addAttribute("program_page_number", tpagenatedProgramData.getPageNumberList());

        model.addAttribute("program", tpagenatedProgramData.getProgramListResponseDtoList());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "program";
    }

    @GetMapping("/qna")
    public String qna(Model model, @LoginUser SessionUser user, @PageableDefault(size = 10) Pageable pageable) {

        ArrayList<PageNumber> pageNumberList = new ArrayList<>();
        PageNumber PageNumber;
        Page<Qna> pagenatedQnaData = qnaService.findAllDesc(pageable);

        for (int i = 0; i < pagenatedQnaData.getTotalPages(); i++) {
            PageNumber = new PageNumber(i);
            pageNumberList.add(PageNumber);
        }

        model.addAttribute("qna_page_number", pageNumberList);

        model.addAttribute("qna", pagenatedQnaData.getContent().stream()
                .map(QnaListResponseDto::new)
                .collect(Collectors.toList()));

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "qna";
    }

    @GetMapping("/manager/reservation")
    public String managersReservation(Model model, @LoginUser SessionUser user, @PageableDefault(size = 10) Pageable pageable) {

        ArrayList<PageNumber> pageNumberList = new ArrayList<>();
        PageNumber PageNumber;
        Page<Reservation> pagenatedReservationData = reservationService.findAllDesc(pageable);

        for (int i = 0; i < pagenatedReservationData.getTotalPages(); i++) {
            PageNumber = new PageNumber(i);
            pageNumberList.add(PageNumber);
        }

        model.addAttribute("reservation_page_number", pageNumberList);

        model.addAttribute("reservation", pagenatedReservationData.getContent().stream()
                .map(ReservationResponseDto::new)
                .collect(Collectors.toList()));

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }

        return "manager-reservation";
    }

    @GetMapping("/reservation/{programId}")
    public String reservation(Model model, @PathVariable Long programId, @LoginUser SessionUser user) {
        model.addAttribute("programId", programId);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "reservation";
    }

    @GetMapping("/hanip-manager")
    public String hanipManager(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "hanip-manager";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/program/save")
    public String programSave(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }
        return "program-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/program/detail/{id}")
    public String programDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        ProgramResponseDto dto = programService.findById(id);
        model.addAttribute("program", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }

        return "program-detail";
    }

    @GetMapping("/qna/detail/{id}")
    public String qnaDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        QnaResponseDto dto = qnaService.findById(id);
        model.addAttribute("qna", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }

        return "qna-detail";
    }

    @GetMapping("/user/detail")
    public String userDetail(Model model, @LoginUser SessionUser user) {

        model.addAttribute("reservation", reservationService.findAllByAuthorId(user.getId()));

        if (user != null) {
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("userName",  user.getName());
            }
        }

        return "user-detail";
    }

    @GetMapping("/program/update/{id}")
    public String programUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        ProgramResponseDto dto = programService.findById(id);
        model.addAttribute("program", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }

        return "program-update";
    }

    @GetMapping("/qna/update/{id}")
    public String qnaUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        QnaResponseDto dto = qnaService.findById(id);
        model.addAttribute("qna", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }
        return "qna-update";
    }

    @GetMapping("/qna/answer/{id}")
    public String qnaAnswer(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        QnaResponseDto dto = qnaService.findById(id);
        model.addAttribute("qna", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            if (user.getRole() == Role.MANAGER) {
                model.addAttribute("is-manager", true);
            }
        }
        return "qna-answer";
    }
}
