package com.example.controlejee.entities;

import com.example.controlejee.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String reference;

    private Double price;
    @Enumerated(EnumType.STRING)
    private Status state;
    @ManyToOne
    private Match match;
}
