/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faker.tryfaker.service;

import com.example.faker.tryfaker.model.Item;
import com.example.faker.tryfaker.model.Supplier;
import com.example.faker.tryfaker.repository.ItemRepository;
import com.example.faker.tryfaker.repository.SupplierRepository;
import com.github.javafaker.Faker;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class SampleDataLoader implements CommandLineRunner{

    private ItemRepository itemRepository;
    private SupplierRepository supplierRepository;
    private Faker faker; 

    public SampleDataLoader(ItemRepository itemRepository, SupplierRepository supplierRepository, Faker faker) {
        this.itemRepository = itemRepository;
        this.supplierRepository = supplierRepository;
        this.faker = faker;
    }   
    
    @Override
    public void run(String... args) throws Exception {
        List<Item> items =  IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Item(
                        faker.commerce().productName(),
                        faker.commerce().price(),
                        faker.date().past(600, TimeUnit.DAYS),
                        faker.country().name()
                    
                )).collect(Collectors.toList());
        itemRepository.saveAll(items);
        
        List<Supplier> suppliers =  IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Supplier(
                        faker.company().name(),
                        faker.address().fullAddress(),
                        faker.phoneNumber().phoneNumber(),
                        faker.company().url()
                    
                )).collect(Collectors.toList());
        supplierRepository.saveAll(suppliers);
    }
    
    
}
