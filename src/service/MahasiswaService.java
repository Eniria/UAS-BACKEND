/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.model.repository.service;

import UAS.BackEnd.model.Mahasiswa;
import UAS.BackEnd.model.repository.MahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author A S P I R E 3
 */
@Service
public class MahasiswaService {
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public List<Mahasiswa> getAll() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getById(Long nim) {
        return mahasiswaRepository.findById(nim)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "mahasiswa not found"));
    }

    public Mahasiswa create(Mahasiswa mahasiswa) {
        if (mahasiswa.getNim() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mahasiswa already exists");
        }
        if (mahasiswaRepository.findByName(mahasiswa.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region name already exists");
        }
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa update(Long id, Mahasiswa mahasiswa) {
        getById(id);
        mahasiswa.setId(id);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa delete(Long nim) {
        Mahasiswa mahasiswa = getById(nim);
        mahasiswaRepository.delete(mahasiswa);
        return mahasiswa;
    }
}
