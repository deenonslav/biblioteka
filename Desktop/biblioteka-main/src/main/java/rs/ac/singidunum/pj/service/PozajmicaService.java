package rs.ac.singidunum.pj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Knjiga;
import rs.ac.singidunum.pj.entity.Pozajmica;
import rs.ac.singidunum.pj.model.PozajmicaModel;
import rs.ac.singidunum.pj.repo.KnjigaRepository;
import rs.ac.singidunum.pj.repo.PozajmicaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PozajmicaService {

    @Autowired
    private PozajmicaRepository pozajmicaRepository;

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Pozajmica> getAll() {
        return pozajmicaRepository.findAll();
    }

    public List<Pozajmica> getByKnjiga(Integer knjigaId) {
        return pozajmicaRepository.findAllByKnjigaKnjigaId(knjigaId);
    }

    public Optional<Pozajmica> getById(Integer id) {
        return pozajmicaRepository.findById(id);
    }

    public Pozajmica create(PozajmicaModel model) {
        Knjiga knjiga = knjigaRepository.findById(model.getKnjigaId()).get();

        Pozajmica pozajmica = new Pozajmica();
        pozajmica.setKnjiga(knjiga);
        pozajmica.setImeclana(model.getImeclana());
        pozajmica.setDatumUzimanja(model.getDatumUzimanja());
        pozajmica.setDatumVracanja(model.getDatumVracanja());
        pozajmica.setCreatedAt(LocalDateTime.now());
        return pozajmicaRepository.save(pozajmica);
    }
    
    public Pozajmica update(Integer id, PozajmicaModel model) {
    Pozajmica pozajmica = pozajmicaRepository.findById(id).get();

    if (model.getKnjigaId() != null) {
        Knjiga knjiga = knjigaRepository.findById(model.getKnjigaId()).get();
        pozajmica.setKnjiga(knjiga);
    }
    pozajmica.setImeclana(model.getImeclana());
    pozajmica.setDatumUzimanja(model.getDatumUzimanja());
    pozajmica.setDatumVracanja(model.getDatumVracanja());

    return pozajmicaRepository.save(pozajmica);
}

    public void delete(Integer id) {
        pozajmicaRepository.deleteById(id);
    }

}
