package com.eraboy.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String address;
    private String telNo;


    @Column
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Diploma> diploma;
}
