package com.fcynn.homeworkday.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "subtechnology")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubTechnology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  name;

    @ManyToOne
    @JoinColumn(name = "languages_id")
    private ProgrammingLanguage programmingLanguage;



}
