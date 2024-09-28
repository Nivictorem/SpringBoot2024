package ru.arkhipov.MySpringBoot2Dbase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACADEMIC_DISCIPLINES")
public class AcademicDiscipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item")
    private String item;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "groups")
    private String group;

}
