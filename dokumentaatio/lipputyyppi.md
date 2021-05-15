# Lipputyyppi endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Näytä kaikki lipputyypit

**URL** : `api/types`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Näytä yksittäinen lipputyyppi

**URL** : `api/types/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

## Tallenna uusi lippu

**URL** : `api/types`

**Method** : `POST`

**Vastauksen paluukoodi**: `201 Created`

***Kutsun sisältö:***
```json
{
    "typename": { lipputyypin kuvaus },
    "price": { lipun hinta euroissa},
    "vent": { tapahtuman url-linkki }
}
esimerkki:
{
    "typename": "Aikuinen",
    "price": 3000,
    "vent": "https://hot-ticketguru.herokuapp.com/api/vents/6"
}
```

## Muokkaa osaa yksittäisen lipputyypin tiedoista
**URL** : `api/types/{id}`

**Method** : `PATCH`

**Vastauksen paluukoodi** : `200 OK`

***Kutsun sisältö merkittäessä lippua käytetyksi:***
```json
{
    "used": "{{$isoTimestamp}}"
}
```

## Muokkaa kokonaista yksittäistä lipputyyppiä

**URL** : `api/types/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen lipputyyyppi:  
**URL** : `api/types/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`