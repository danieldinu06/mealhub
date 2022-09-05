package com.danieldinu.mealhub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String number;

    @Column(
            nullable = false,
            columnDefinition = "DATE"
    )
    private Date expireDate;

    @Column(
            nullable = false
    )
    private int cvv;

    @ManyToMany(mappedBy = "cards")
    private Set<User> users = new HashSet<>();
}
