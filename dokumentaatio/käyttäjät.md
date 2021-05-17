# Käyttäjä endpointit
**Auth required** : YES, Basic Authentication

**Permissions required** : None

## Näytä kaikki käyttäjät

**URL** : `api/users`

**Method** : `GET`

**Vastauksen paluukoodi**: `200 OK`

## Näytä yksittäinen käyttäjä

**URL** : `api/users/{id}`

**Method** : `GET`

**Vastauksen paluukoodi** : `200 OK`

## Tallenna uusi käyttäjä

**URL** : `api/users`

**Method** : `POST`

**Vastauksen paluukoodi**: `201 Created`

***Kutsun sisältö:***
```json
{
    "firstName": "etunimi",
    "lastName": "sukunimi",
    "username": "käyttäjätunnus",
    "password": "salasana",
    "role": "käyttäjärooli"
}
}
```

## Muokkaa osaa yksittäisen käyttäjän tiedoista
**URL** : `api/users/{id}`

**Method** : `PATCH`

**Vastauksen paluukoodi** : `200 OK`

## Muokkaa yksittäisen käyttäjän kaikkia tietoja

**URL** : `api/users/{id}`

**Method** : `PUT`

**Vastauksen paluukoodi** : `200 OK`

## Poista yksittäinen käyttäjä 
**URL** : `api/users/{id}`

**Method** : `DELETE`

**Vastauksen paluukoodi** : `204 No Content`
