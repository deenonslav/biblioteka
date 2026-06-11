package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.pj.entity.Knjiga;

import java.util.List;

public interface KnjigaRepository extends JpaRepository<Knjiga, Integer> {

    List<Knjiga> findAllByDeletedAtIsNull();

}
