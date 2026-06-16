package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.pj.entity.Pozajmica;

import java.util.List;

public interface PozajmicaRepository extends JpaRepository<Pozajmica, Integer> {

    List<Pozajmica> findAllByKnjigaKnjigaId(Integer knjigaId);

}
