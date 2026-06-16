package rs.ac.singidunum.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.pj.entity.Knjiga;
import rs.ac.singidunum.pj.model.KnjigaModel;
import rs.ac.singidunum.pj.service.KnjigaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/knjiga")
public class KnjigaController {

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping
    public ResponseEntity<List<Knjiga>> getAll() {
        return ResponseEntity.ok(knjigaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Knjiga> getById(@PathVariable Integer id) {
        Optional<Knjiga> knjiga = knjigaService.getById(id);
        if (knjiga.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(knjiga.get());
    }

    @PostMapping
    public ResponseEntity<Knjiga> create(@RequestBody KnjigaModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(knjigaService.create(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Knjiga> update(@PathVariable Integer id, @RequestBody KnjigaModel model) {
        Optional<Knjiga> knjiga = knjigaService.getById(id);
        if (knjiga.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(knjigaService.update(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Knjiga> knjiga = knjigaService.getById(id);
        if (knjiga.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        knjigaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
