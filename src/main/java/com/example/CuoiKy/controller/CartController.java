package com.example.CuoiKy.controller;

import com.example.CuoiKy.service.BookService;
import com.example.CuoiKy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/cart")

public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "/cart/index";
    }
    @GetMapping ("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId) {
        cartService.addToCart(bookId);
        return "redirect:/cart";
    }
    @GetMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable Long bookId) {
        cartService.removeFromCart(bookId);
        return "redirect:/cart";
    }
    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }



}
