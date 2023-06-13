package com.eraboy.diploma.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Diploma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private long id;
    private String name;
    private String duration;
    private double fee;

    @ManyToOne
    private Student student;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "diploma_details", joinColumns = @JoinColumn(name = "diploma_id"), inverseJoinColumns = @JoinColumn(name = "subject_code"))
    private List<Subject> subject = new ArrayList<>();
}
