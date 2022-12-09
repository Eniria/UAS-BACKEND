/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.BackEnd.service;

import UAS.BackEnd.model.Mahasiswa;
import UAS.BackEnd.repository.MahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Mahasiswa getById(Long id) {
        return mahasiswaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "mahasiswa not found"));
    }

    public Mahasiswa create(Mahasiswa mahasiswa) {
        if (mahasiswa.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mahasiswa sudah ada");
        }
        if (mahasiswaRepository.findByName(mahasiswa.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "nama mahasiswa sudah ada");
        }
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa update(Long id, Mahasiswa mahasiswa) {
        getById(id);
        mahasiswa.setId(id);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa delete(Long id) {
        Mahasiswa mahasiswa = getById(id);
        mahasiswaRepository.delete(mahasiswa);
        return mahasiswa;
    }
}

