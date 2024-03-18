package com.realestate.springboot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Broker_Profile")
public class Broker_Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BrokerId;

    @Column(nullable = false)
    private String BrokerName;

    @Column(nullable = false)
    private String mobileNumber;

    private String rating;
}
