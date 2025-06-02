package com.rollerspeed.rollerspeed.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length =50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String genero;

    @Column(name = "email" , nullable = false, length = 50, unique=true)
    private String correo;

    @Column(length = 50)
    private String password;

    
}
