package io.github.alexagalvao.model;

public class Cliente {

 private Integer id;
 private String Nome;

    public Cliente(Integer id, String nome) {
        this.id = id;
        Nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                '}';
    }

    public Cliente(){

   }

    public Cliente(String nome) {
        Nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
