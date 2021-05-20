package com.reward.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Premi {

    @Id
    private int id;


    private String nome;


    @Column(name = "punti_riscatto")
    private int punti;

    private  boolean riscattato;
    @ManyToMany(mappedBy = "premi")
    private Set<Utente> utenti;

    public Premi() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public boolean isRiscattato() {
        return riscattato;
    }

    public void setRiscattato(boolean riscattato) {
        this.riscattato = riscattato;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }


}
