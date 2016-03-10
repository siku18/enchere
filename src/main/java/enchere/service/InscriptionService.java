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

    public String inscription(Utilisateur u) {

        List<Utilisateur> listeUtilisateurs = (List<Utilisateur>) utilisateurService.findAll();
        if (!listeUtilisateurs.isEmpty()){
            for (Utilisateur u2 : listeUtilisateurs) {
                if (u.getLogin().equals(u2.getLogin())) {
                    return "L'inscription a ecouee, login deja utilisé";
                }
            }
        }
        System.out.println("56456456456446546546846515684");
        utilisateurService.save(u);
        return "inscription a ete effectuer";
    }

}
