/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.controller;

import UAS.BackEnd.model.RegistrationRequest;
import UAS.BackEnd.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A S P I R E 3
 */
@RestController
@RequestMapping (path = "api/v1/registration" )
@AllArgsConstructor
public class RegistrationController {
    
    private RegistrationService registrationService;
    
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    
}
