# Tapahtuma endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Hae kaikkien tapahtumien tiedot 

**URL** : `api/events`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `api/events/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

### GET -kutsun esimerkkivastaus

```json
{
    "eventid": 3,
    "eventtime": "22.1.2021. klo. 19",
    "performer": "Danny",
    "desc": "Kuvaus1",
    "capacity": 2000,
    "venue": {
        "venueid": 1,
        "address": "Urhokekkosenkatu",
        "postcode": "00100",
        "city": "Helsinki",
        "venuename": "Tavastia"
    },
    "eventname": "Iso D"
}
```
## Tallenna uusi tapahtuma

**URL** : `api/events`

**Method** : `POST`

***Kutsun sisältö:***
```json
{
    "performer": "Artisti", 
    "eventtime":"27.2.2021. klo 18:30", 
    "desc": "Konsertti", 
    "eventname": "Tapahtuma", 
    "capacity": "150",
    "venue": { "venueid":{id} }
}
```

* Tapahtumalle luodaan EventID automaattisesti.
* Jos paikka annetaan kutsussa, on paikkaa vastaava VenueID on löydyttävä tietokannasta.

**Vastauksen paluukoodi**: `201 Created`

## Muokkaa osaa yksittäisestä tapahtumasta
**URL** : `api/events/{id}`

**Method** : `PATCH`

***Kutsun esimerkki sisältö:***
```json
{
    "eventtime":"muokattu aika",
    "desc": "muokattu kuvaus"}
}
```
***Paikan lisääminen tapahtumalle:***
```json
{
    "venue":{ venueid }
}
```
**Vastauksen paluukoodi** : `200 OK`

## Muokkaa kokonaista yksittäistä tapahtumaa

**URL** : `api/events/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen tapahtuma 

**URL** : `api/events/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`
