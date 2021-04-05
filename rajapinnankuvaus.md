# REST API -rajapinnan kuvaus

Tähän dokumenttiin kerätään projektin edetessä päivittyvää kuvausta siihen liittyvästä REST-rajapinnasta.

## Base-URL
Kehitysvaiheessa tiimin jäsenet ajavat projektia kukin omalla paikallisella palvelimellaan osoitteessa http://localhost:8080. 

## Endpointit
Tässä vaiheessa kehitystyötä kaikki käytössä olevat endpointit ovat avoimia. Käyttämäämme kovakoodattua testidataa lukuunottamatta H2-tietokantaan ei tallennu persistenttiä dataa.

### [Paikka-endpointit](paikat.md)
* Näytä kaikki paikat: GET `api/venues`
* Näytä yksittäinen paikka: GET `api/venues/{id}`
* Tallenna uusi paikka: POST `api/venues`
* Muokkaa osaa yksittäisestä paikasta: PATCH `api/venues/{id}`
* Muokkaa kokonaista yksittäistä paikkaa: PUT `api/venues/{id}`
* Poista yksittäinen paikka: DELETE `api/venues/{id}`

### [Tapahtuma-endpointit](tapahumat.md)
* Näytä kaikki tapahtumat: GET `api/events`
* Näytä yksittäinen tapahtuma: GET `api/events/{id}`
* Tallenna uusi tapahtuma: POST `api/events`
* Muokkaa osaa yksittäisestä tapahtumasta: PATCH `api/events/{id}`
* Muokkaa kokonaista yksittäistä tapahtumaa: PUT `api/events/{id}`
* Poista yksittäinen myyntitapahtuma: DELETE `api/events/{id}`

### Lippu-endpointit
* Näytä kaikki liput: GET `api/tickets`
* Näytä yksittäinen lippu: GET `api/tickets/{id}`
* Tallenna uusi lippu: POST `api/tickets`
* Muokkaa osaa yksittäisestä lipusta: PATCH `api/tickets/{id}`
* Muokkaa kokonaista yksittäistä lippua: PUT `api/tickets/{id}`
* Poista yksittäinen lippu: DELETE `api/tickets/{id}`

### Lipputyyppi-endpointit
* Näytä kaikki lipputyypit: GET `api/types`
* Näytä yksittäinen lipputyyppi: GET `api/types/{id}`
* Tallenna uusi lipputyyppi: POST `api/types`
* Muokkaa osaa yksittäisestä lipputyypistä: PATCH `api/types/{id}`
* Muokkaa kokonaista yksittäistä lipputyyppiä: PUT `api/types/{id}`
* Poista yksittäinen lipputyyppi: DELETE `api/types/{id}`

### Myyntitapahtuma-endpointit
* Näytä kaikki myyntitapahtumat: GET `api/transactions`
* Näytä yksittäinen myyntitapahtuma: GET `api/transactions/{id}`
* Tallenna uusi tapahtuma: POST `api/transactions`
* Muokkaa osaa yksittäisestä myyntitapahtumasta: PATCH `api/transactions/{id}`
* Muokkaa kokonaista yksittäistä myyntitapahtumaa: PUT `api/transactions/{id}`
* Poista yksittäinen myyntiapahtuma: DELETE `api/transactions/{id}`

