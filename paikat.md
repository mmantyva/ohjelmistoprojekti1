# Paikka endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Näytä kaikki paikat

**URL** : `api/venues`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Näytä yksittäinen paikka

**URL** : `api/venues/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

### GET -kutsun esimerkkivastaus

## Tallenna uusi tapahtuma

**URL** : `api/venues`

**Method** : `POST`

**Vastauksen paluukoodi**: `201 Created`
***Kutsun sisältö:***
```json
{
    "venuename": "paikka",
    "address": "osoite",
    "postcode": "postinro",
    "city": "kaupunki"
}
```


## Muokkaa osaa yksittäisen paikan tiedoista
**URL** : `api/venues/{id}`

**Method** : `PATCH`

**Vastauksen paluukoodi** : `200 OK`

## Muokkaa kokonaista yksittäistä paikkaa

**URL** : `api/venues/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen paikka:  `api/events/{id}`
**URL** : `api/venues/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`