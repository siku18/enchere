/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ArticlesEncheriesService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private EnchereService enchereService;

    public List<Article> articlesEncheries(Utilisateur u) {
        List<Enchere> listeEnchereUtil = enchereService.findByUtilisateur(u);
        List<Article> listeArticlesDeUtil = new ArrayList<>();
        //Récupération de la liste des articles sur lesquels l'utilisateur à enchéri
        if (listeEnchereUtil.size() != 0) {
            Article a1 = listeEnchereUtil.get(0).getArticle();
            listeArticlesDeUtil.add(a1);
            for (Enchere e : listeEnchereUtil) {
                if (!a1.equals(e.getArticle())) {
                    listeArticlesDeUtil.add(e.getArticle());
                    a1 = e.getArticle();
                }
            }
        }
        return listeArticlesDeUtil;
    }
}
