package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "knjiga")
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "knjiga_id")
    private Integer knjigaId;

    @Column(name = "naslov", columnDefinition = "text")
    private String naslov;

    @Column(name = "autor", columnDefinition = "text")
    private String autor;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "godina_izdanja")
    private Integer godinaIzdanja;

    @Column(name = "zanr")
    private String zanr;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
