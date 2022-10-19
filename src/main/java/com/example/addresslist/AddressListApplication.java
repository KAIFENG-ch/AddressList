package com.example.addresslist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot 启动类
 * @author Albert
 */
@SpringBootApplication
public class AddressListApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressListApplication.class, args);
    }

}
