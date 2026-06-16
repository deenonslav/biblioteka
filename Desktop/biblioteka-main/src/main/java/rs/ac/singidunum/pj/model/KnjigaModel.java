package rs.ac.singidunum.pj.model;

import lombok.Data;

@Data
public class KnjigaModel {

    private String naslov;
    private String autor;
    private String isbn;
    private Integer godinaIzdanja;
    private String zanr;

}
