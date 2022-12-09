/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author A S P I R E 3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_mahasiswa")
public class Mahasiswa {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "nim_mahasiswa")
  private String nim; 
  
  @Column(nullable = false, name = "nama_mahasiswa")
  private String name;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToMany(mappedBy = "mahasiswa")
  private List<Matakuliah> matakuliah;

    
    
}
