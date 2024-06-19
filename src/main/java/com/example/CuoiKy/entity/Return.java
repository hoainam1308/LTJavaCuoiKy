package com.example.CuoiKy.entity;

import com.example.CuoiKy.validator.annotation.ValidBorrowId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name="return")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrow_id", referencedColumnName = "id")
    @ValidBorrowId
    @NotNull(message = "Borrow is required")
    private Borrow borrow;

    @Column(name = "actual_return_date")
    @NotNull(message = "Actual return date is required")
    @Temporal(TemporalType.DATE)
    private Date actualReturnDate;

    @Column(name = "penalty_fee")
    private Double penaltyFee;
}