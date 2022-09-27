package com.example.proyecto3.Modelo;

import java.sql.Date;


import javax.persistence.*;

@Entity
@Table(name = "movimientos")

public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "concept", length = 100)
    private String concept;

    @Column(name = "amount", length = 20)
    private float amount;

    @ManyToOne
    @JoinColumn(name = "idempresa", referencedColumnName = "id")
    private Empresa empresa;

    @Column(name = "createdAt", nullable = true)
    private Date createdAt;

    public Movimientos() {

    }

    public Movimientos(Long id, String concept, float amount, Date createAt, Empresa empresa) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createAt;
        this.empresa = empresa;
    }

    public Movimientos(String concept, float amount, Date createdAt, Empresa empresa) {
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
        this.empresa = empresa;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(Date createAt) {
        this.createdAt = createAt;
    }

    public Empresa getEmpresa(){
        return this.empresa;
    }
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

   
}
