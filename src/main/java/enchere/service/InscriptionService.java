/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {

    @Autowired
    private UtilisateurService utilisateurService;

    public Boolean inscription(Utilisateur u) {

        List<Utilisateur> listeUtilisateurs = (List<Utilisateur>) utilisateurService.findAll();
        if (!listeUtilisateurs.isEmpty()){
            for (Utilisateur u2 : listeUtilisateurs) {
                if (u.getLogin().equals(u2.getLogin())) {
                    System.out.println("**********************************");
                    return false;
                }
            }
        }
        utilisateurService.save(u);
        return true;
    }

}
