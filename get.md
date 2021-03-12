# Näytä kaikki tapahtumat

## Hae kaikkien tapahtumien tiedot 

**URL** : `/events`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `/events/{id}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi** : `200 OK`

## Sisällön esimerkkejä

Tapahtumalle, jonka ID on 3 on tietokantaan tallennettu kaikki tapahtumaa koskevat tiedot: 

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

Tapahtumalle, jonka ID on 5 on tietokantaan tallennettu ainoastaan esiintyjän nimi, muut tiedot puuttuvat:

```json
{
    "eventid": 5,
    "eventtime": null,
    "performer": "Gaga",
    "desc": null,
    "capacity": 0,
    "venue": null,
    "eventname": null
}

```
