# REST API -rajapinnan kuvaus

Tähän dokumenttiin kerätään projektin edetessä päivittyvää kuvausta siihen liittyvästä REST-rajapinnasta.

## Base-URL
Kehitysvaiheessa tiimin jäsenet ajavat projektia kukin omalla paikallisella palvelimellaan osoitteessa http://localhost:8080.

## Endpointit

### Tapahtuma-endpointit
* Näytä kaikki tapahtumat: GET `/tapahtumat`
* Näytä yksittäinen tapahtuma: GET `/tapahtuma/{id}`
* Tallenna uusi tapahtuma: POST `/tapahtumat`
* ~~Muokkaa osaa yksittäisestä tapahtumasta: PATCH `/tapahtumat/{id}`~~
* ~~Muokkaa kokonaista yksittäistä tapahtumaa: PUT `/tapahtumat/{id}`~~
* ~~Poista yksittäinen tapahtuma: DELETE `/tapahtumat/{id}`~~