package com.example.controlejee.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor@Builder
@Table(name="match_entity")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String reference;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private String stadium;
    private String team1;
    private String team2;
    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets;
}
