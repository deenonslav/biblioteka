package rs.ac.singidunum.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.pj.entity.Pozajmica;
import rs.ac.singidunum.pj.model.PozajmicaModel;
import rs.ac.singidunum.pj.service.PozajmicaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pozajmica")
public class PozajmicaController {

    @Autowired
    private PozajmicaService pozajmicaService;

    @GetMapping
    public ResponseEntity<List<Pozajmica>> getAll() {
        return ResponseEntity.ok(pozajmicaService.getAll());
    }

    @GetMapping("/knjiga/{knjigaId}")
    public ResponseEntity<List<Pozajmica>> getByKnjiga(@PathVariable Integer knjigaId) {
        return ResponseEntity.ok(pozajmicaService.getByKnjiga(knjigaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pozajmica> getById(@PathVariable Integer id) {
        Optional<Pozajmica> pozajmica = pozajmicaService.getById(id);
        if (pozajmica.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pozajmica.get());
    }

    @PostMapping
    public ResponseEntity<Pozajmica> create(@RequestBody PozajmicaModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pozajmicaService.create(model));
    }

    @PutMapping("/{id}")
public ResponseEntity<Pozajmica> update(@PathVariable Integer id, @RequestBody PozajmicaModel model) {
    Optional<Pozajmica> existing = pozajmicaService.getById(id);
    if (existing.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(pozajmicaService.update(id, model));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Pozajmica> pozajmica = pozajmicaService.getById(id);
        if (pozajmica.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pozajmicaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
