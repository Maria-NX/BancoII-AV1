package br.edu.unijuazeiro.BancoAv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(generator = "genAnimal", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "generatorAnimal", name = "genAnimal",
        initialValue = 2, allocationSize = 10)
    private Integer id_animal;

    @Column(nullable = false)
    private String nome;

    private String raca;


}
