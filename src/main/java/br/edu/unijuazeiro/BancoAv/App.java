package br.edu.unijuazeiro.BancoAv;

import br.edu.unijuazeiro.BancoAv.models.Animal;
import br.edu.unijuazeiro.BancoAv.models.Dono;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unipets");
        EntityManager em = emf.createEntityManager();

        //iniciando a transacao
        em.getTransaction().begin();

        //INSERT
        Dono dono1 = new Dono();
        dono1.setNome("Lucas");
        dono1.setCpf("12300022287");

        Dono dono2 = new Dono();
        dono2.setNome("Natalia");
        dono2.setCpf("98023316700");
        

        Animal animal1 = new Animal();
        animal1.setNome("bolinha");
        animal1.setRaca("pincher");
        

        Animal animal2 = new Animal();
        animal2.setNome("bidu");
        animal2.setRaca("cyborg");
        
        
        //persistindo os donos juntamente com os animais
        em.persist(dono1);
        em.persist(dono2);

        em.getTransaction().commit();


        //SELECT

        em.close();

        emf.close();
        

        
    }
}
