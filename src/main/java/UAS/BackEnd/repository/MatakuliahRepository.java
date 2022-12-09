/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.repository;

/**
 *
 * @author A S P I R E 3
 */
import UAS.BackEnd.model.Matakuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {
    Boolean existsByName(String name);
}