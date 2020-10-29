package br.edu.unijuazeiro.BancoAv;

import br.edu.unijuazeiro.BancoAv.funcoesBanco.Funcoes;
import br.edu.unijuazeiro.BancoAv.models.Animal;
import br.edu.unijuazeiro.BancoAv.models.Dono;


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

        funcoes.inserir(dono, "Dhiego", "123245666", animal, "Pretinha", "Pincher");
     
    }
}
