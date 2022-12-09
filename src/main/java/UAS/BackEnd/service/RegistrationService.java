/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.service;

import UAS.BackEnd.model.AppUser;
import UAS.BackEnd.model.AppUserRole;
import UAS.BackEnd.model.ConfirmationToken;
import UAS.BackEnd.model.EmailValidator;
import UAS.BackEnd.model.RegistrationRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author A S P I R E 3
 */
@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;  
   // private final ConfirmationToken confirmationToken;

    @PostMapping
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER 
                )
        );
        
    }
    
//    @Transactional
//    public String confirmToken(String token){
//        ConfirmationToken confirmationToken = confirmationTokenService
//                .getToken(token)
//                .orElseThrow(()
//                        -> new IllegalStateException("token not found"));
//        if (confirmationToken.getConfirmedAt() != null){
//            throw new IllegalStateException("token expired");
//    }
//        LocaDateTime expiredAt = confirmationToken.getExpiresAt();
//        
//        if (expiredAt.idBefore(LocalDateTime.now())){
//            throw new IllegalStateException("token expired");
//        }
//        confirmationTokenService.setConfirmedAt(token);
//        appUserService.enableAppUser(
//        confirmationToken.getAppUser().getEmail());
//        return "confirmed";
}
