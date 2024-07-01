package com.example.CuoiKy.service;


import com.example.CuoiKy.entity.Book;
import com.example.CuoiKy.entity.Cart;
import com.example.CuoiKy.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@SessionScope
public class CartService {
    private Cart cart = new Cart();
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private BookService bookService;

    // Thêm sản phẩm vào giỏ hàng hoặc tăng số lượng nếu đã tồn tại
    public void addToCart(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Product not found: " + bookId));

        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        for (Book book1 : cart.getBooks()) {
            if (Objects.equals(book1.getId(), bookId)) {
                return;
            }
        }
        // Nếu sản phẩm chưa tồn tại và số lượng đủ, thêm một mục mới vào giỏ hàng
        cart.addBook(book);
    }

    public List<Book> getCartItems() {
        return cart.getBooks();
    }

    // Xóa một mục khỏi giỏ hàng
    public void removeFromCart(Long bookId) {
        cart.removeBook(bookId);
    }

    // Xóa tất cả các mục trong giỏ hàng
    public void clearCart() {
        cart.clear();
    }


}
