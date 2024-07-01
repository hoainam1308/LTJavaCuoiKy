package com.example.CuoiKy.service;

import com.example.CuoiKy.entity.*;
import com.example.CuoiKy.repository.IBookRepository;
import com.example.CuoiKy.repository.IBorrowRepository;
import com.example.CuoiKy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBorrowRepository borrowRepository;

    @Autowired
    private CartService cartService;

    public void borrowBooks(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("User Name must not be null");
        }
        User user = userRepository.findByUsername(userName);

        List<Book> books = cartService.getCartItems();
        List<BorrowDetail> details = new ArrayList<>();

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBorrowDate(new Date());

        for (Book book : books) {
            BorrowDetail detail = new BorrowDetail();
            detail.setBorrow(borrow);
            detail.setBook(book);
            // Set other fields of BorrowDetail as necessary
            details.add(detail);
        }
        borrow.setDetails(details);

        borrowRepository.save(borrow);
        cartService.clearCart();
    }
}
