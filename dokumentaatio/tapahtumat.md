# Tapahtuma endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Hae kaikkien tapahtumien tiedot 

**URL** : `api/vents`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `api/vents/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

### GET -kutsun esimerkkivastaus

```json
{
    "ventid": 3,
    "venttime": "22.1.2021. klo. 19",
    "performer": "Danny",
    "description": "Kuvaus1",
    "capacity": 2000,
    "venue": {
        "venueid": 1,
        "address": "Urhokekkosenkatu",
        "postcode": "00100",
        "city": "Helsinki",
        "venuename": "Tavastia"
    },
    "ventname": "Iso D"
}
```
## Tallenna uusi tapahtuma

**URL** : `api/vents`

**Method** : `POST`

***Kutsun sisältö:***
```json
{
    "performer": "Artisti", 
    "venttime":"27.2.2021. klo 18:30", 
    "description": "Konsertti", 
    "ventname": "Tapahtuma", 
    "capacity": "150",
    "venue": { "venueid":{id} }
}
```

* Tapahtumalle luodaan VentID automaattisesti.
* Jos paikka annetaan kutsussa, on paikkaa vastaava VenueID on löydyttävä tietokannasta.

**Vastauksen paluukoodi**: `201 Created`

## Muokkaa osaa yksittäisestä tapahtumasta
**URL** : `api/vents/{id}`

**Method** : `PATCH`

***Kutsun esimerkki sisältö:***
```json
{
    "venttime":"muokattu aika",
    "description": "muokattu kuvaus"}
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

**URL** : `api/vents/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen tapahtuma 

**URL** : `api/vents/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`
