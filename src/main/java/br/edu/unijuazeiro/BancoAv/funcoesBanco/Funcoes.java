package br.edu.unijuazeiro.BancoAv.funcoesBanco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unijuazeiro.BancoAv.models.Animal;
import br.edu.unijuazeiro.BancoAv.models.Dono;

public class Funcoes {
 
    public void inserir(Dono dono, String nome, String cpf, Animal animal, String nomeAnimal, String raca){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unipets");
        EntityManager em = emf.createEntityManager();

        dono.setNome(nome);
        dono.setCpf(cpf);

        animal.setNome(nomeAnimal);
        animal.setRaca(raca);

        dono.setAnimal(animal);

        // iniciando a transacao
        em.getTransaction().begin();

        // persistindo os donos juntamente com os animais
        em.persist(dono);
       
        //commitando a transação
        em.getTransaction().commit();

        em.close();

        emf.close();

    }
    
}
