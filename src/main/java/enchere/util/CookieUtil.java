/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.util;

import javax.servlet.http.Cookie;

/**
 *
 * @author admin
 */
public class CookieUtil {

    public static String getCookieValue(Cookie[] TabCook, String nameCookie) {
        for (Cookie c : TabCook) {
            if (c.getName().equals(nameCookie)) {
                return c.getValue() ;
            }
        }
        throw new RuntimeException();
    }
}
