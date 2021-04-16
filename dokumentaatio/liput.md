# Lippu endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Näytä kaikki liput

**URL** : `api/tickets`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Näytä yksittäinen lippu

**URL** : `api/tickets/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

## Tallenna uusi lippu

**URL** : `api/tickets`

**Method** : `POST`

**Vastauksen paluukoodi**: `201 Created`

***Kutsun sisältö:***
```json
{
    "typeid": {id},
    "trid": {id},
    "eventid": {id}
}
```

## Muokkaa osaa yksittäisen lipun tiedoista
**URL** : `api/tickets/{id}`

**Method** : `PATCH`

**Vastauksen paluukoodi** : `200 OK`

***Kutsun sisältö merkitessä lippua käytetyksi:***
```json
{
    "used": "{{$isoTimestamp}}"
}
```

## Muokkaa kokonaista yksittäistä lippua

**URL** : `api/tickets/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen lippu:  
**URL** : `api/tickets/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`