package br.edu.unijuazeiro.BancoAv;

import br.edu.unijuazeiro.BancoAv.funcoesBanco.Funcoes;
import br.edu.unijuazeiro.BancoAv.model.Animal;
import br.edu.unijuazeiro.BancoAv.model.Dono;


/**
 * Hello world!
 *
 */
public class App 
{


    public static void main(String[] args) {

        Funcoes funcoes = new Funcoes();
        Dono dono = new Dono();
        Animal animal = new Animal();

        funcoes.inserir(dono, "Ralyfe", "123453000", animal, "bolinha", "pincher");
        
        funcoes.buscarPorCodigo(11);
        funcoes.atualizarNomeDono(11, "Cicero Ralyfe");

        funcoes.listarTodosDonos();

        //funcoes.deletarDono();

        
    }
}
