# Näytä kaikki tapahtumat

## Hae kaikkien tapahtumien tiedot 

**URL** : `/tapahtumat`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `/tapahtuma/{id}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi** : `200 OK`

## Sisällön esimerkkejä

Tapahtumalle, jonka ID on 3 on tietokantaan tallennettu kaikki tapahtumaa koskevat tiedot: 

```json
{
    "tapahtuma_id": 3,
    "tapahtuma_aika": "22.1.2021. klo. 19",
    "esiintyja": "Danny",
    "tapahtuma_kuvaus": "Kuvaus1",
    "kapasiteetti": 2000,
    "paikka": {
        "paikkaid": 1,
        "katuosoite": "Urhokekkosenkatu",
        "postinumero": "00100",
        "kaupunki": "Helsinki",
        "paikka_nimi": "Tavastia"
    },
    "tapahtuma_nimi": "Iso D"
}
```

Tapahtumalle, jonka ID on 5 on tietokantaan tallennettu ainoastaan esiintyjän nimi, muut tiedot puuttuvat:

```json
{
    "tapahtuma_id": 5,
    "tapahtuma_aika": null,
    "esiintyja": "Gaga",
    "tapahtuma_kuvaus": null,
    "kapasiteetti": 0,
    "paikka": null,
    "tapahtuma_nimi": null
}

```
