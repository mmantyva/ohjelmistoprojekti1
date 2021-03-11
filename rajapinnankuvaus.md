# REST API -rajapinnan kuvaus

Tähän dokumenttiin kerätään projektin edetessä päivittyvää kuvausta siihen liittyvästä REST-rajapinnasta.

## Base-URL
Kehitysvaiheessa tiimin jäsenet ajavat projektia kukin omalla paikallisella palvelimellaan osoitteessa http://localhost:8080. 

## Endpointit
Tässä vaiheessa kehitystyötä kaikki käytössä olevat endpointit ovat avoimia. Käyttämäämme kovakoodattua testidataa lukuunottamatta H2-tietokantaan ei tallennu persistenttiä dataa.

### Myyntitapahtuma-endpointit
* Näytä kaikki myyntitapahtumat: GET `api/transactions` tai `/transactions`
* Näytä yksittäinen myyntitapahtuma: GET `api/transactions/{id}` tai `/transactions/{id}`
* Tallenna uusi tapahtuma: POST `api/transactions` tai `/transactions`


### Tapahtuma-endpointit
* Näytä kaikki tapahtumat: GET `/events`
* Näytä yksittäinen tapahtuma: GET `/events/{id}`
* Tallenna uusi tapahtuma: POST `/events`
* ~~Muokkaa osaa yksittäisestä tapahtumasta: PATCH `/events/{id}`~~
* ~~Muokkaa kokonaista yksittäistä tapahtumaa: PUT `/events/{id}`~~
* ~~Poista yksittäinen tapahtuma: DELETE `/events/{id}`~~