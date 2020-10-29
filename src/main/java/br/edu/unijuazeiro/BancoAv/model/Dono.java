package br.edu.unijuazeiro.BancoAv.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genDono")
    @SequenceGenerator(sequenceName = "seqDono", name="genDono",
        initialValue = 2, allocationSize = 2)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    //utilizando o cascade para persistir todos os dados juntos
    //e o fetch eager para quando consultar dono o animal vim junto
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
    @JoinColumn
    private Animal animal;

}
