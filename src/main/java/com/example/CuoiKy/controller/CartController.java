package com.example.CuoiKy.controller;

import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.entity.Cart;
import com.example.CuoiKy.repository.IBookRepository;
import com.example.CuoiKy.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    BookService bookService;

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @GetMapping("/add/{id}")
    public String addToCart(HttpSession session, @PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if(book != null){
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            cart.addBook(book);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(HttpSession session, @RequestParam Long bookId) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.removeBook(bookId);
        }
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        return "redirect:/cart";
    }
}
