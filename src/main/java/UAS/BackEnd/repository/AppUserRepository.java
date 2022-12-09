/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.repository;

import UAS.BackEnd.model.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author A S P I R E 3
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository <AppUser, Long>  {
     Optional<AppUser> findByEmail (String email);
}
