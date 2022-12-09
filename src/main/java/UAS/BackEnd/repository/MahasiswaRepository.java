/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.repository;

import UAS.BackEnd.model.Mahasiswa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author A S P I R E 3
 */
@Repository
public interface  MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{
    Optional<Mahasiswa> findByName(String name);
}
