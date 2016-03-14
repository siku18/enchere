/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class RafraichiDisponibleService {
    
    @Autowired
    private ArticleService articleService;
    
    public void ActualisDisponnible(Article a){
        Date aujourdhui = new Date();
        if ((a.getDateExpirationEnchere().getTime())-(aujourdhui.getTime())<0) {
            a.setDisponible(false);
            articleService.save(a);
        }
    }
        
}
