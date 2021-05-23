package com.reward.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "password")
    private String password;

    private int punteggio;

    @ManyToMany
    @JoinTable(
            name = "user_tasks",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_task"))
    private Set<Tasks> tasks;

    @ManyToMany
    @JoinTable(
            name = "user_premi",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_premio"))
    private Set<Premi> premi;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utenti_ruoli",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "ruolo_id"))
    private Set<Ruolo> ruoli;



    public Utente() {
    }

    public Set<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio += punteggio;
    }

    public void togliPunti(int punteggio){
        this.punteggio-=punteggio;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Tasks task) {
        if(tasks==null){
            tasks=new HashSet<Tasks>();
        }
        this.tasks.add(task);
        setPunteggio(task.getPunti());
    }

    public Set<Premi> getPremi() {
        return premi;
    }

    public void setPremi(Premi premio) {
        if(premi==null){
            premi=new HashSet<Premi>();
        }

        this.premi.add(premio);
        togliPunti(premio.getPunti());
    }
}
