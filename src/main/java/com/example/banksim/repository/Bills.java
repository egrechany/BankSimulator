package com.example.banksim.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "Bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "UAHcard")
    private String UAHcard;
    @Column(name = "UAHcardCVV")
    private String UAHcardCVV;

    @Column(name = "USDcard")
    private String USDcard;
    @Column(name = "USDcardCVV")
    private String USDcardCVV;

    @Column(name = "EURcard")
    private String EURcard;
    @Column(name = "EURcardCVV")
    private String EURcardCVV;
}
