# Myyntitapahtuma endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Näytä kaikki myyntitapahtumat

**URL** : `api/transactions`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Näytä yksittäinen myyntitapahtuma

**URL** : `api/transactions/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

## Tallenna uusi myyntitapahtuma

**URL** : `api/transactions`

**Method** : `POST`

**Vastauksen paluukoodi**: `201 Created`

***Kutsun sisältö:***
```json
{
    "trtime": "{{$isoTimestamp}}"
}
```
## Muokkaa osaa yksittäisen myyntitapahtuman tiedoista
**URL** : `api/transactions/{id}`

**Method** : `PATCH`

**Vastauksen paluukoodi** : `200 OK`

## Muokkaa kokonaista yksittäistä myyntitapahtumaa

**URL** : `api/transactions/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen myyntitapahtuma  
**URL** : `api/transactions/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`
