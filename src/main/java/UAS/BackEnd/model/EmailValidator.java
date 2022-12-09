/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.model;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

/**
 *
 * @author A S P I R E 3
 */
@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
       // TODO: Regex to validate email 
                return true; 
    }
    
}
