package com.example.CuoiKy.controller;

import com.example.CuoiKy.service.BorrowService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public String borrowBooks(@RequestParam("userName") String userName) {
        borrowService.borrowBooks(userName);
        return "redirect:/";
    }
}
