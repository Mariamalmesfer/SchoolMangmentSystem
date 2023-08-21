package com.example.schoolmanagementhwday21.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id") // the secound won must be the same name of the Merchant is
    @JsonIgnore
    private Teacher teacher; // same spell in the
}


