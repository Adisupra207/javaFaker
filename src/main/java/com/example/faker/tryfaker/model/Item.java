/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faker.tryfaker.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ASUS
 */
@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String price;
    @Column(nullable = true)
    private Date manfactureDate;
    @Column(nullable = true)
    private String madeIn;
    @ManyToOne
    private Supplier supplier;

    public Item(Long id, String productName, String price, Date manfactureDate, String madeIn, Supplier supplier) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.manfactureDate = manfactureDate;
        this.madeIn = madeIn;
        this.supplier = supplier;
    }

    public Item(String productName, String price, Date manfactureDate, String madeIn) {
        this.productName = productName;
        this.price = price;
        this.manfactureDate = manfactureDate;
        this.madeIn = madeIn;
    }   
    
    
    
}
