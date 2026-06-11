package rs.ac.singidunum.pj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Knjiga;
import rs.ac.singidunum.pj.model.KnjigaModel;
import rs.ac.singidunum.pj.repo.KnjigaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> getAll() {
        return knjigaRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Knjiga> getById(Integer id) {
        return knjigaRepository.findById(id);
    }

    public Knjiga create(KnjigaModel model) {
        Knjiga knjiga = new Knjiga();
        knjiga.setNaslov(model.getNaslov());
        knjiga.setAutor(model.getAutor());
        knjiga.setIsbn(model.getIsbn());
        knjiga.setGodinaIzdanja(model.getGodinaIzdanja());
        knjiga.setZanr(model.getZanr());
        knjiga.setCreatedAt(LocalDateTime.now());
        return knjigaRepository.save(knjiga);
    }

    public Knjiga update(Integer id, KnjigaModel model) {
        Knjiga knjiga = knjigaRepository.findById(id).get();
        knjiga.setNaslov(model.getNaslov());
        knjiga.setAutor(model.getAutor());
        knjiga.setIsbn(model.getIsbn());
        knjiga.setGodinaIzdanja(model.getGodinaIzdanja());
        knjiga.setZanr(model.getZanr());
        knjiga.setUpdatedAt(LocalDateTime.now());
        return knjigaRepository.save(knjiga);
    }

    public void delete(Integer id) {
        Knjiga knjiga = knjigaRepository.findById(id).get();
        knjiga.setDeletedAt(LocalDateTime.now());
        knjigaRepository.save(knjiga);
    }

}
