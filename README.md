# Ohjelmistoprojekti I: TicketGuru

Hyvä ohjelmointitiimi: Eero Koski, Niina Kuusisto, Mikko Martikainen, Maisa Mäntyvaara

## Johdanto

Projektin aiheena on lipunmyyntijärjestelmän kehittäminen asiakkaana olevalle lipputoimistolle. Lipputoimisto tarvitsee järjestelmää lippujen myymiseen myyntipisteessään. Järjestelmän alustava nimi on TicketGuru.

### Taustaa ja asiakkaan toiveita lipunmyyntijärjestelmän toiminnalle:
* Lipputoimisto voi määritellä järjestelmään tapahtumat, joihin lippuja myydään. 
* Lipputoimisto voi määrittää järjestelmään erilaisia lipputyyppejä ja niille hinnat.
* Lipunmyyjä myy ja tulostaa asiakkaalle liput lipunmyyntipisteessä. 
* Ennakkomyynnin loputtua loput liput tulostetaan ovella myytäviksi. 
* Lipuissa on koodi, joka voidaan tarkastaa helposti ovella ja jolla lippu voidaan merkitä käytetyksi.
* Järjestelmästä lipputoimisto saa tarkasteltavaksi myyntiraportteja, joissa myyntitapahtumat on eriteltynä.
* Jatkokehityksessä järjestelmään aiotaan lisätä vielä verkkokauppa, jolla lipputoimiston asiakkaat voivat itse ostaa lippuja.

Palvelu toteutetaan Javalla Spring Boot -kehystä käyttäen. Lipunmyyntijärjestelmää on tarkoitus käyttää vain tietokoneelta käsin eli käytettävinä päätelaitteina ovat pöytäkone ja läppäri. Palvelinpuolen ratkaisut ja teknologiat määritellään myöhemmin.

## Järjestelmän määrittely
### Käyttäjäroolit
Ensimmäisessä vaiheessa järjestelmän käyttäjille on tunnistettu seuraavat roolit:
* **Tapahtumien määrittelijä**. Henkilö, joka määrittelee järjestelmään tapahtumat, joihin myydään lippuja sekä eri lipputyypit tapahtumakohtaisesti.
* **Raportoija**. Henkilö, joka tarvitsee järjestelmästä raportit eri tapahtumiin myydyistä lipusta.
* **Lipunmyyjä**. Henkilö, joka myy ja tulostaa asiakkaalle liput.
* **Lipuntarkastaja**. Henkilö joka tarkastaa liput tapahtumassa.
* **Asiakas**. Henkilö, joka ostaa lipun johonkin tapahtumaan.

Alustava käyttötapauskaavio:

![käyttötapauskaavio](https://github.com/mmantyva/ohjelmistoprojekti1/blob/develop/roolit1.jpg)

### Käyttäjätarinat

(Tässä lipputoimiston edustaja = henkilöt, jotka ovat käyttötapauskaaviossa "tapahtuman määritteljä" ja "raportoija")
* **Lipputoimiston edustajana** haluan pystyä määrittelemään, mihin tapahtumiin lippuja myydään, jotta asiakkaat olisivat mahdollisimman tyytyväisiä palveluvalikoimaan
* **Lipputoimiston edustajana** haluan pystyä määrittelemään hinnat eri lipputyypeille lipunmyynnin maksimoimiseksi
* **Lipputoimiston edustajana** haluan, että liput ovat helposti yksilöitävissä ja merkittävissä käytetyiksi tapahtuman yhteydessä, jotta väärinkäytöksiltä ja väärennyksiltä vältyttäisiin
* **Lipputoimiston edustajana** haluan pystyä tarkastelemaan yksityiskohtaisia myyntiraportteja

* **Lippumyyjänä** haluan pystyä myymään asiakkaalle lipun suoraan järjestelmästä
* **Lippumyyjänä** haluan pystyä tulostamaan asiakkaalle hänen lippunsa
* **Lippumyyjänä** haluan voida tulostaa ennakkomyynnin loputtua loput liput ovella myytäviksi, jotta myymättä jääneiden lippujen määrä jäisi mahdollisimman vähäiseksi

* **Lipuntarkastajana** haluan pystyä tarkistamaan liput ovella nopeasti ja luotettavasti asiakaspalvelun laadun varmistamiseksi

* **Asiakkaana** haluan saada lipun lipunmyyntipisteeltä heti mukaani maksettuani sen, jotta arvokasta aikaani säästyisi
* **Asiakkaana** haluan tulevaisuudessa pystyä myös ostamaan itse oman lippuni verkkokaupasta


## Käyttöliittymä

Alustavat käyttöliittymän rautalankamallit on tallennettu [Moodleen](https://hhmoodle.haaga-helia.fi/pluginfile.php/2113426/mod_resource/content/1/TicketGuru%20UI.pdf).

## Tietokanta
Järjestelmän tietokantarakenne koostuu neljästä tietokantataulusta: tapahtumista, siihen myytävistä erilaisista lipputyypeistä, myyntitapahtumista ja yksittäisistä lipuista.

Tietokannat ja niiden väliset yhteydet on kuvattuna alla olevassa kaaviossa:

![Tietokantakaavio](https://github.com/mmantyva/ohjelmistoprojekti1/blob/develop/tietokanta.jpg)

Tietokantaan sisältyvät elementit ja niiden attribuutit esitettynä tietohakemistossa:

> ### _Events_
> _Events-taulu sisältää tiedot tapahtumista, joihin myydään lippuja. Yhteen tapahtumaan voidaan myydä useita eri lipputyypejä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> eventid | int PK | Tapahtuman id
> eventname | varchar(50) |  Tapahtuman nimi
> performer | varchar(50) | Tapahtumassa esiintyvä artisti, ryhmä tms
> capacity | int | Asiakaspaikkojen määrä, määrittää kuinka monta lippua voidaan myydä
> eventtime | datetime | Tapahtuman ajankohta
> venueid | int FK) | Paikan id, jossa tapahtuma järjestetään
> desc | varchar(250) | Lyhyt kuvaus tapahtumasta
#

> ### _Venues_
>_Venues-taulu sisältää tiedot tiloista, joissa tapahtumia voidaan järjestää._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> venueid | int PK | Tilan/paikan id
> venuename | varchar(50) | Paikan nimi
> address | varchar(50) | Kohteen katuosoite
> postcode | char(5) | Kohteen postinumero
> city | varchar(20) | Kaupunki, jossa kohde sijaitsee
#

> ### _Types_
> _Types-taulussa on tiedot erilaisista lipputyypeistä, joita tapahtumaan myydään. Jokainen lipputyyppi kuuluu yhteen tapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> typeid | int PK | Lipputyypin id
> price | float | Lipun hinta
> typename | varchar(50) | Lipputyypin kuvaus (esim. aikuinen)
#

> ### _Transactions_
> _Transactions-taulussa on tiedot kaikista myyntitapahtumista. Yksi myyntitapahtuma voi sisältää useita lippuja, useisiin eri tapahtumiin._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> trid | int PK | Myyntitapahtuman id
> trtime | datetime |  Myyntitapahtuman ajankohta
#
> ### _Tickets_
> _Tickets-taulussa on tiedot yksittäisistä myydyistä lipuista. Jokainen lippu kuuluu yhteen lipputyypiin ja yhteen myyntitapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ticketid | int PK | Lipun id, yksilöllinen koodi jonka avulla esim. lipuntarkastaja tarkistaa lipun
> typeid | int FK |  Lipputyypin id
> trid | int FK | Myyntitapahtuman id
> eventid | int FK | Tapahtuman id


## Tekninen kuvaus

Kehityksen alkuvaiheessa käytämme tietokannan rakentamisessa H2-kantaa. REST-rajapinnan kuvaukset ovat omissa dokumentaatioissaan.