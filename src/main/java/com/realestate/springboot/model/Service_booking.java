package com.realestate.springboot.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Service_Booking")
public class Service_booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
}






