package com.reward.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "settimana")
public class Settimana {

    @Id
    private int id;

    @ManyToMany
    @JoinTable(
            name = "giorni-sett",
            joinColumns = @JoinColumn(name = "id-sett"),
            inverseJoinColumns = @JoinColumn(name = "id-giorno"))
    private Set<Giorno> giorni;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public Set<Giorno> getGiorni() {
        return giorni;
    }

    public void setGiorni(Set<Giorno> giorni) {
        this.giorni = giorni;
    }
}
