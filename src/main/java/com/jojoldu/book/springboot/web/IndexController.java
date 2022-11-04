package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.service.program.ProgramService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final ProgramService programService;

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
    public String program(Model model, @LoginUser SessionUser user) {

        model.addAttribute("program", programService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "program";
    }

    @GetMapping("/reservation")
    public String reservation(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "reservation";
    }

    @GetMapping("/qna")
    public String qna(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "qna";
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
    public String programSave() {
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
        if (user.getRole() == Role.MANAGER) {
            model.addAttribute("is-manager", true);
        }

        return "program-detail";
    }

    @GetMapping("/program/update/{id}")
    public String programUpdate(@PathVariable Long id, Model model) {
        ProgramResponseDto dto = programService.findById(id);
        model.addAttribute("program", dto);
        return "program-update";
    }
}
