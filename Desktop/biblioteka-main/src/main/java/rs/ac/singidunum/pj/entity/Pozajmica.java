package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pozajmica")
public class Pozajmica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pozajmica_id")
    private Integer pozajmicaId;

    @ManyToOne
    @JoinColumn(name = "knjiga_id")
    private Knjiga knjiga;

    @Column(name = "ime_clana")
    private String imeclana;

    @Column(name = "datum_uzimanja")
    private LocalDate datumUzimanja;

    @Column(name = "datum_vracanja")
    private LocalDate datumVracanja;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
