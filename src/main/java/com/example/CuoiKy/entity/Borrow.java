package com.example.CuoiKy.entity;

import com.example.CuoiKy.validator.annotation.ValidBookId;
import com.example.CuoiKy.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ValidBookId
    @NotNull(message = "Book is required")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    @NotNull(message = "User is required")
    private User user;

    @Column(name = "borrow_date")
    @NotNull(message = "Borrow date is required")
    @Temporal(TemporalType.DATE)
    private Date borrowDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "status")
    @NotNull(message = "Status is required")
    private String status;
}
