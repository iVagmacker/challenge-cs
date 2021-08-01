package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "carro")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull()
    @Column(name = "nome", nullable = false)
    private String nome;


    @NotNull()
    @Column(name = "km_por_galao", nullable = false)
    private int kmPorGalao;

    @NotNull()
    @Column(name = "cilindros", nullable = false)
    private int cilindros;

    @NotNull()
    @Column(name = "cavalor_de_forca", nullable = false)
    private int cavaloDeForca;

    @NotNull()
    @Column(name = "peso", nullable = false)
    private int peso;

    @NotNull()
    @Column(name = "aceleracao", nullable = false)
    private int aceleracao;

    @NotNull()
    @Column(name = "ano", nullable = false)
    private Date ano;

    @NotNull()
    @Column(name = "origem", nullable = false)
    private String origem;
}