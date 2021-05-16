# REST API -rajapinnan kuvaus

Tähän dokumenttiin kerätään projektin edetessä päivittyvää kuvausta siihen liittyvästä REST-rajapinnasta.

## Base-URL
Tiimin jäsenet voivat ajaa projektia kukin omalla paikallisella palvelimellaan portissa 8080, http://localhost:8080/. 

Sovellus on julkaistu Herokussa, ja rajapinta saatavilla osoitteessa https://hot-ticketguru.herokuapp.com.

## Endpointit
Tässä vaiheessa kehitystyötä kaikki käytössä olevat endpointit ovat avoimia, vaikka olemme jo toteuttaneet järjestelmään autentikoinnin ja autorisoinnin. 

### [Tapahtuma-endpointit](tapahtumat.md)
* Näytä kaikki tapahtumat: GET `api/vents`
* Näytä yksittäinen tapahtuma: GET `api/vents/{id}`
* Tallenna uusi tapahtuma: POST `api/vents`
* Muokkaa osaa yksittäisestä tapahtumasta: PATCH `api/vents/{id}`
* Muokkaa kokonaista yksittäistä tapahtumaa: PUT `api/vents/{id}`
* Poista yksittäinen myyntitapahtuma: DELETE `api/vents/{id}`
* Näytä kaikki tapahtumat ja tapahtumapaikat: GET `/events`
* Näytä kaikki tapahtumat ja tapahtumiin liittyvät lipputyypit: GET `/eventtickets`

### [Paikka-endpointit](paikat.md)
* Näytä kaikki paikat: GET `api/venues`
* Näytä yksittäinen paikka: GET `api/venues/{id}`
* Tallenna uusi paikka: POST `api/venues`
* Muokkaa osaa yksittäisestä paikasta: PATCH `api/venues/{id}`
* Muokkaa kokonaista yksittäistä paikkaa: PUT `api/venues/{id}`
* Poista yksittäinen paikka: DELETE `api/venues/{id}`

### [Lippu-endpointit](liput.md)
* Näytä kaikki liput: GET `api/tickets`
* Näytä yksittäinen lippu: GET `api/tickets/{id}`
* Tallenna uusi lippu: POST `api/tickets`
* Muokkaa osaa yksittäisestä lipusta: PATCH `api/tickets/{id}`
* Muokkaa kokonaista yksittäistä lippua: PUT `api/tickets/{id}`
* Poista yksittäinen lippu: DELETE `api/tickets/{id}`

### [Lipputyyppi-endpointit](lipputyyppi.md)
* Näytä kaikki lipputyypit: GET `api/types`
* Näytä yksittäinen lipputyyppi: GET `api/types/{id}`
* Tallenna uusi lipputyyppi: POST `api/types`
* Muokkaa osaa yksittäisestä lipputyypistä: PATCH `api/types/{id}`
* Muokkaa kokonaista yksittäistä lipputyyppiä: PUT `api/types/{id}`
* Poista yksittäinen lipputyyppi: DELETE `api/types/{id}`

### [Myyntitapahtuma-endpointit](myynti.md)
* Näytä kaikki myyntitapahtumat: GET `api/transactions`
* Näytä yksittäinen myyntitapahtuma: GET `api/transactions/{id}`
* Tallenna uusi myyntitapahtuma: POST `api/transactions`
* Muokkaa osaa yksittäisestä myyntitapahtumasta: PATCH `api/transactions/{id}`
* Muokkaa kokonaista yksittäistä myyntitapahtumaa: PUT `api/transactions/{id}`
* Poista yksittäinen myyntitapahtuma: DELETE `api/transactions/{id}`

### [Käyttäjä-endpointit](käyttäjät.md)
* Näytä kaikki käyttäjät: GET `api/users`
* Näytä yksittäinen käyttäjä: GET `api/users/{id}`
* Tallenna uusi käyttäjä: POST `api/users`
* Muokkaa osaa yksittäisestä käyttäjästä: PATCH `api/users/{id}`
* Muokkaa kokonaista yksittäistä käyttäjää: PUT `api/users/{id}`
* Poista yksittäinen käyttäjä: DELETE `api/users/{id}`

