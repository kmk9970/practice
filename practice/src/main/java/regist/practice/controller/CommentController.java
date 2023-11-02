package regist.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import regist.practice.service.CommentService;
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

}
