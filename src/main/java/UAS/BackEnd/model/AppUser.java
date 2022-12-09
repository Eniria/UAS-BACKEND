/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.model;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author A S P I R E 3
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity

 
public class AppUser implements UserDetails {
    
    
    @SequenceGenerator(
    name = "Stident_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1)
    
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_sequence"
    )
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;
    
 
    public AppUser (String firstName,
            String lastName,
            String email, 
            String password,
            AppUserRole appUserRole){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = 
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
       return password;
    }

    @Override
    public String getUsername() {
        return email; 
    }
    
   
     public String getfirstName() {
        return firstName; 
    }
    
    public String getlastName() {
        return lastName; 
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ; 
    }

    @Override
    public boolean isEnabled() {
        return enabled; 
    }
    
}
