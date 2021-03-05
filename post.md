# Luo uusi tapahtuma

**URL** : `/tapahtumat`

**Method** : `POST`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi**: `200 OK`

## Hae yksittäisen tapahtuman tiedot

**URL** : `/tapahtuma/{id}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Vastauksen paluukoodi** : `200 OK`

### Esimerkki lähetettävän pyynnön rungosta, mukana kaikki tapahtuman tiedot:

```json
{"esiintyja": "Gaga", 
"tapahtuma_aika":"27.2.2021. klo 18:30", 
"tapahtuma_kuvaus": "Konsertti", 
"tapahtuma_nimi": "Gagakonsertti", 
"kapasiteetti": "150", 
"paikka": {"paikkaid":2}}
```

* Tapahtumalle luodaan TapahtumaID automaattisesti.
* Paikkaa vastaava PaikkaID on löydyttävä tietokannasta.

### Esimerkki lähetettävän pyynnön rungosta, mukana ainoastaan esiintyjä ja tapahtuma-aika:

```json
{"esiintyja": "Gaga", 
"tapahtuma_aika":"27.2.2021. klo 18:30" 
}
```



