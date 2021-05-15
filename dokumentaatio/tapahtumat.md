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
    "performer": "Danny",
    "description": "Kuvaus1",
    "capacity": 2000,
    "eventname": "Iso D",
    "eventtime": "11.11.2022",
    "eventid": 6,
    "_links": {
        "self": {
            "href": "https://hot-ticketguru.herokuapp.com/api/vents/6"
        },
        "vent": {
            "href": "https://hot-ticketguru.herokuapp.com/api/vents/6"
        },
        "venue": {
            "href": "https://hot-ticketguru.herokuapp.com/api/vents/6/venue"
        },
        "types": {
            "href": "https://hot-ticketguru.herokuapp.com/api/vents/6/types"
        }
    }
}
```
## Hae kaikki tapahtumat ja niihn liittyvien paikkojen tiedot

**URL** : `/events`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

### Kutsun esimerkkivastaus
```json
{
    "performer": "Danny",
    "description": "Kuvaus1",
    "capacity": 2000,
    "venue": {
        "venueid": 3,
        "venuename": "Tavastia",
        "address": "Urhokekkosenkatu",
        "postcode": "00100",
        "city": "Helsinki"
    },
    "eventname": "Iso D",
    "eventtime": "11.11.2022",
    "eventid": 6
}
```
## Hae kaikki tapahtumat ja niihn liittyvien lippujen tiedot

**URL** : `/eventtickets`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

### Kutsun esimerkkivastaus
```json
 {
    "ventid": 7,
    "eventname": "Konsertti",
    "eventtime": "22.1.2021. klo. 19",
    "performer": "Armi",
    "description": "Kuvaus2",
    "capacity": 2000,
    "types": [
        {
            "typeid": 245,
            "typename": "Adult",
            "price": 30.0,
            "vent": {
                "performer": "Armi",
                "description": "Kuvaus2",
                "capacity": 2000,
                "venue": {
                    "venueid": 4,
                    "venuename": "Finlandiatalo",
                    "address": "Mansku",
                    "postcode": "00100",
                    "city": "Helsinki"
                },
                "eventname": "Konsertti",
                "eventtime": "22.1.2021. klo. 19",
                "eventid": 7
            }
        }
    ]
},
```

## Tallenna uusi tapahtuma

**URL** : `api/vents`

**Method** : `POST`

***Kutsun sisältö:***
```json
{
    "performer": "Artisti", 
    "eventtime":"27.2.2021. klo 18:30", 
    "description": "Konsertti", 
    "eventname": "Tapahtuma", 
    "capacity": "150",
    "venue": "https://hot-ticketguru.herokuapp.com/api/venue/3""
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
    "venue": { paikan url-linkki }
}
esimerkki:
{
    "venue": "https://hot-ticketguru.herokuapp.com/api/venue/3"
}
```
* paikkaa vastaava VenueID on löydyttävä tietokannasta.

**Vastauksen paluukoodi** : `200 OK`

## Muokkaa kokonaista yksittäistä tapahtumaa

**URL** : `api/vents/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen tapahtuma 

**URL** : `api/vents/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`
