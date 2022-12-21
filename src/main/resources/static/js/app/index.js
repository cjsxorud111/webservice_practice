var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
        $('#btn-program-save').on('click', function () {
            _this.program_save();
        })
        $('#btn-update').on('click',function () {
            _this.update();
        })
        $('#btn-qna-update').on('click',function () {
            _this.qna_update();
        })
        $('#btn-program-update').on('click',function () {
            _this.program_update();
        })
        $('#btn-delete').on('click',function () {
            _this.delete();
        })
        $('#btn-program-delete').on('click',function () {
            _this.program_delete();
        })
        /*$('#btn-reservation-delete').on('click',function (id) {
            _this.reservation_delete(id);
        })*/
        $('#click-btn').on('click' ,function() {
            _this.reservation_save();
            var date = $('#datePicker').val();
            alert(date);
        });
    },
    reservation_save : function () {
        var data = {
            programId: document.getElementById('programId').innerHTML,
            date: $('#datePicker').val(),
            phoneNumber: $('#phoneNumber').val(),
            uniqueness: $('#uniqueness').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/reservation',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('예약이 등록되었습니다. 유선 혹은 문자로 관리자가 연락드릴 예정입니다.');
            window.location.href = '/program';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('프로그램이등록되었습니다.');
            window.location.href = '/program/save';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    program_save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/program',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('프로그램이등록되었습니다.');
            window.location.href = '/program/save';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' +id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    program_update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/program/' +id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('프로그램이 수정되었습니다.');
            window.location.href = '/program';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    qna_update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/qna/' +id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('qna가 수정되었습니다.');
            window.location.href = '/qna';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' +id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    program_delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/program/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('프로그램이 삭제되었습니다.');
            window.location.href = '/program';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
/*    reservation_delete : function (id) {

        alert(id);
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/reservation/' + id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function () {
            alert('예약내역이 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }*/


};
main.init();

