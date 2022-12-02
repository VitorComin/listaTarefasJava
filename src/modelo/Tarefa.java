/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vitor
 */
public class Tarefa {

    private int id;
    private boolean concluido;
    private String nome;

    public Tarefa(int id, boolean concluido, String nome) {
        this.id = id;
        this.concluido = concluido;
        this.nome = nome;
    }
    public Tarefa(boolean concluido, String nome) {
        this.concluido = concluido;
        this.nome = nome;
    }
    
    public Tarefa (){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
