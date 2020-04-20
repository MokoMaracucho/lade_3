package com.oc.moko.lade.service;

import java.util.List;
import java.util.UUID;

import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.entity.Utilisateur;

public interface UtilisateurService {

    public void enregistrerUtilisateur(Utilisateur utilisateur);

    public List<Utilisateur> listeUtilisateurs();

    public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;

    public void supprimerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;
}
