# Biblioteka - Aplikacija

Aplikacija za upravljanje katalogom knjiga i pozajmicama, razvijena u okviru kursa Programski jezici 2026.

## Tehnologije

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- MySQL
- HTML5 / JavaScript
- Bootstrap 5.3
- SweetAlert2

## Pokretanje

### 1. Baza podataka

Pokrenite MySQL server i izvršite `db.sql` skriptu:

```sql
source db.sql
```

### 2. Konfiguracija

U fajlu `src/main/resources/application.properties` podesite lozinku za MySQL:

```properties
spring.datasource.password=vasa_lozinka
```

### 3. Pokretanje aplikacije

```bash
mvnw.cmd spring-boot:run
```

Aplikacija će biti dostupna na: **http://localhost:8080**

## Struktura projekta

```
biblioteka/
├── public/                  # Frontend (HTML, CSS, JS)
│   ├── css/global.css
│   ├── js/utils.js
│   ├── index.html
│   ├── knjiga.html
│   ├── new-knjiga.html
│   ├── edit-knjiga.html
│   ├── details-knjiga.html
│   ├── pozajmica.html
│   └── new-pozajmica.html
├── src/
│   └── main/java/rs/ac/singidunum/pj/
│       ├── controller/      # REST API kontroleri
│       ├── entity/          # JPA entiteti
│       ├── model/           # DTO modeli
│       ├── repo/            # JPA repozitorijumi
│       └── service/         # Servisni sloj
├── db.sql                   # SQL skripta za bazu
└── pom.xml
```

## API Endpointi

### Knjiga
| Metoda | URL | Opis |
|--------|-----|------|
| GET | /api/knjiga | Lista svih knjiga |
| GET | /api/knjiga/{id} | Jedna knjiga |
| POST | /api/knjiga | Dodaj knjigu |
| PUT | /api/knjiga/{id} | Izmeni knjigu |
| DELETE | /api/knjiga/{id} | Obriši knjigu (soft delete) |

### Pozajmica
| Metoda | URL | Opis |
|--------|-----|------|
| GET | /api/pozajmica | Lista svih pozajmica |
| GET | /api/pozajmica/knjiga/{id} | Pozajmice za knjigu |
| POST | /api/pozajmica | Nova pozajmica |
| DELETE | /api/pozajmica/{id} | Obriši pozajmicu |
