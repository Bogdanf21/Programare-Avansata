package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="friendships")
@Getter
@Setter
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @ManyToOne
    @JoinColumn(name = "person1")
    private Person person1;

    @ManyToOne
    @JoinColumn(name = "person2")
    private Person person2;
}
