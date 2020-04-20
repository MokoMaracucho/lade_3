package com.oc.moko.lade.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.moko.lade.entity.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/listeUtilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.getListeUtilisateurs();
        model.addAttribute("listeUtilisateurs", listeUtilisateurs);
        return "list-customers";
    }

    @GetMapping("/inscription_utilisateur")
    public String showFormForAdd(Model model) {
        logger.debug("Dans la méthode qui manipule le formulaire d'inscription.");
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "customer-form";
    }

    @PostMapping("/enregistrerUtilisateur")
    public String enregistrerUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
    	utilisateurService.enregistrerUtilisateur(utilisateur);
        return "redirect:/utilisateur/listeUtilisateurs";
    }

    @GetMapping("/maj_utilisateur")
    public String MajUtilisateur(@RequestParam("idUtilisateur") UUID idUtilisateur,
        Model theModel) throws ResourceNotFoundException {
    	Utilisateur utilisateur = utilisateurService.selectionnerUtilisateurParId(idUtilisateur);
        theModel.addAttribute("utilisateur", utilisateur);
        return "maj_utilisateur";
    }

    @GetMapping("/supprimer_utilisateur")
    public String supprimerUtilisateurParId(@RequestParam("idUtilisateur") UUID idUtilisateur) throws ResourceNotFoundException {
    	utilisateurService.supprimerUtilisateurParId(idUtilisateur);
        return "redirect:/utilisateur/listeUtilisateurs";
    }
}
