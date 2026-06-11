package rs.ac.singidunum.pj.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PozajmicaModel {

    private Integer knjigaId;
    private String imeclana;
    private LocalDate datumUzimanja;
    private LocalDate datumVracanja;

}
