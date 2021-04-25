# Luo uusi tapahtuma

**URL** : `/events`

**Method** : `POST`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `/event/{id}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi** : `200 OK`

### Esimerkki lähetettävän pyynnön rungosta, mukana kaikki tapahtuman tiedot:

```json
{"performer": "Gaga", 
"eventtime":"27.2.2021. klo 18:30", 
"desc": "Konsertti", 
"eventname": "Gagakonsertti", 
"capacity": "150", 
"venue": {"venueid":2}}
```

* Tapahtumalle luodaan EventID automaattisesti.
* Paikkaa vastaava VenueID on löydyttävä tietokannasta.

### Esimerkki lähetettävän pyynnön rungosta, mukana ainoastaan esiintyjä ja tapahtuma-aika:

```json
{"performer": "Gaga", 
"eventtime":"27.2.2021. klo 18:30" 
}
```



