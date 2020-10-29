package br.edu.unijuazeiro.BancoAv.funcoesBanco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

import br.edu.unijuazeiro.BancoAv.model.Animal;
import br.edu.unijuazeiro.BancoAv.model.Dono;

public class Funcoes {

    public static String unit = "unit-unipets";
 
    public void inserir(Dono dono, String nome, String cpf, Animal animal, String nomeAnimal, String raca){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit);
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

    public void buscarPorCodigo(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Dono dono = em.find(Dono.class, id);

        System.out.println("-------Nome: "+ dono.getNome());
        System.out.println("-------CPF: "+ dono.getCpf());
        System.out.println("-------ID Animal: "+dono.getAnimal().getId_animal());
        System.out.println("-------Nome Animal: "+dono.getAnimal().getNome());
        System.out.println("-------Raca Animal: "+dono.getAnimal().getRaca());


        //lembrando que select não necesita de commit
        em.close();
        emf.close();
    }

    public void listarTodosDonos(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("from Dono", Dono.class)
        .getResultList().forEach(d->{
            System.out.println("Dono: "+d.getNome());
            System.out.println("CPF: "+d.getCpf());
            System.out.println("Nome animal: "+d.getAnimal().getNome());
            System.out.println("Raca: "+d.getAnimal().getRaca());
            System.out.println("-------------------- ------------------");
        });

        em.close();
        emf.close();

    }

    public void atualizarNomeDono(Integer id, String novoNome){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Dono dono = em.find(Dono.class, id);

        dono.setNome(novoNome);

        em.merge(dono);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void deletarDono(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unit);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Dono dono = em.find(Dono.class, id); 
        
        em.remove(dono);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    
}
