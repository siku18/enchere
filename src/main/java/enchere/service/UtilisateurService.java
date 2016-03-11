/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author admin
 */
@Service
public interface UtilisateurService extends CrudRepository<Utilisateur, Long>{
    
    
        public List<Utilisateur> findByLogin(String login);
    
}
