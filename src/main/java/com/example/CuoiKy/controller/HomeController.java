package com.example.CuoiKy.controller;

import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.entity.Category;
import com.example.CuoiKy.service.BookService;
import com.example.CuoiKy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes) {
        if (model.containsAttribute("loginSuccess")) {
            model.addAttribute("loginSuccessMessage", "Bạn đã đăng nhập thành công!");
            redirectAttributes.addFlashAttribute("loginSuccess", true); // Thêm thông báo thành công vào Flash Attribute
        }
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "home/index";
    }

    @GetMapping("/library")
    public String getAllBook(Model model){
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "home/library";
    }

    @GetMapping("filter")
    public String filterBook(Model model, @RequestParam Long cateId, @RequestParam Integer bookPage, @RequestParam Long authorId){
        List<Book> books = bookService.filterBook(cateId, bookPage, authorId);
        model.addAttribute("books", books);
        return "home/library";
    }

    @GetMapping("/detail/{bookId}")
    public String getBookDetail(Model model, @PathVariable Long bookId){
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "home/detail";
    }

    @GetMapping("/cate/{id}")
    public String getBookByCateId(Model model, @PathVariable Long id){
        List<Book> books = bookService.getByCateId(id);
        model.addAttribute("books", books);
        return "home/library";
    }

    @GetMapping("/set/{bookId}")
    public String getBookByeSetId(Model model, @PathVariable Long bookId){
        List<Book> books = bookService.getBySetId(bookService.getSetId(bookId));
        model.addAttribute("books", books);
        return "share/set";
    }



}
