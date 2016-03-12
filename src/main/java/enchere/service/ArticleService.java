/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public List<Article> findByUtilisateur (Utilisateur utilisateur);
    
    public List<Article> findByCategorie (Categorie categorie);
    
    public Article findByNom ( String nom);
}
