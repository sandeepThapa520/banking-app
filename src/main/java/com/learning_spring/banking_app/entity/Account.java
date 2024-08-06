package com.learning_spring.banking_app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;

    @Column(name="account_holder_locaiton")
    private String accountHolderLocation;

    @Column(name="account_number")
    private Long accountNumber;

    @Column(name="account_balance")
    private Double balance;

}
