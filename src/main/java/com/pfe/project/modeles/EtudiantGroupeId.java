package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name="etudiant_groupe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantGroupeId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;


    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    private boolean responsable;








}
