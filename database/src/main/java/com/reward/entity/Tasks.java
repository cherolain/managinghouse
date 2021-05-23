package com.reward.entity;


import com.reward.entity.Utente;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "punti")
    private int punti;

    @Column(name = "completato")
    private boolean completato;
    @ManyToMany(mappedBy = "tasks")
    private Set<Utente> utenti;

    @OneToMany
    @JoinColumn(name = "tasks")
    private List<Giorno> giorni;

    public Tasks() {

    }

    public List<Giorno> getGiorni() {
        return giorni;
    }

    public void setGiorni(List<Giorno> giorni) {
        this.giorni = giorni;
    }

    public Tasks(String nome) {
        this.nome = nome;
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

    public int getId() {
        return id;
    }

    public boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
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
