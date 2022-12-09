/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.service;

import UAS.BackEnd.model.ConfirmationToken;
import UAS.BackEnd.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author A S P I R E 3
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    
    private final ConfirmationTokenRepository confirmationTokenRepository;
    
    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }  
}
