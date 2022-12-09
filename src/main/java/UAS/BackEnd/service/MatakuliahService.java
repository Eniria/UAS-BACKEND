/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.service;

/**
 *
 * @author A S P I R E 3
 */
import UAS.BackEnd.model.Matakuliah;
import UAS.BackEnd.repository.MatakuliahRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
@AllArgsConstructor
public class MatakuliahService {

    private MatakuliahRepository matakuliahRepository;

    public List<Matakuliah> getAll() {
        return matakuliahRepository.findAll();
    }

    public Matakuliah getById(Long id) {
        return matakuliahRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matakuliah not found")
                );
    }

    public Matakuliah create(Matakuliah matakuliah) {
        if (matakuliah.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Matakuliah already exists"
            );
        }
        if (matakuliahRepository.existsByName(matakuliah.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, " nama matakuliah sudah ada!");
        }
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah update(Long id, Matakuliah matakuliah) {
        getById(id);
        matakuliah.setId(id);
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah delete(Long id) {
        Matakuliah matakuliah = getById(id);
        matakuliahRepository.delete(matakuliah);
        return matakuliah;
    }
}