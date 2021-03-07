# REST API -rajapinnan kuvaus

Tähän dokumenttiin kerätään projektin edetessä päivittyvää kuvausta siihen liittyvästä REST-rajapinnasta.

## Base-URL
Kehitysvaiheessa tiimin jäsenet ajavat projektia kukin omalla paikallisella palvelimellaan osoitteessa http://localhost:8080. 

## Endpointit
Tässä vaiheessa kehitystyötä kaikki käytössä olevat endpointit ovat avoimia. Käyttämäämme kovakoodattua testidataa lukuunottamatta H2-tietokantaan ei tallennu persistenttiä dataa.

### Myyntitapahtuma-endpointit
* Näytä kaikki myyntitapahtumat: GET `api/myyntis` tai `/myynnit`
* Näytä yksittäinen myyntitapahtuma: GET `api/myyntis/{id}` tai `/myynnit/{id}`
* Tallenna uusi tapahtuma: POST `api/myyntis` tai `/myynnit`


### Tapahtuma-endpointit
* Näytä kaikki tapahtumat: GET `/tapahtumat`
* Näytä yksittäinen tapahtuma: GET `/tapahtumat/{id}`
* Tallenna uusi tapahtuma: POST `/tapahtumat`
* ~~Muokkaa osaa yksittäisestä tapahtumasta: PATCH `/tapahtumat/{id}`~~
* ~~Muokkaa kokonaista yksittäistä tapahtumaa: PUT `/tapahtumat/{id}`~~
* ~~Poista yksittäinen tapahtuma: DELETE `/tapahtumat/{id}`~~