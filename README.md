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

> ### _Tapahtumat_
> _Tapahtumat-taulu sisältää tiedot tapahtumista, joihin myydään lippuja. Yhteen tapahtumaan voidaan myydä useita eri lipputyypejä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtuma_id | int PK | Tapahtuman id
> tapahtuma_nimi | varchar(50) |  Tapahtuman nimi
> esiintyja | varchar(50) | Tapahtumassa esiintyvä artisti, ryhmä tms
> kapasiteetti | int | Asiakaspaikkojen määrä, määrittää kuinka monta lippua voidaan myydä
> tapahtuma_aika | datetime | Tapahtuman ajankohta
> paikka_nimi | varchar(50) | Paikka, jossa tapahtuma järjestetään
> kuvaus | varchar(250) | Lyhyt kuvaus tapahtumasta
#

> ### _Paikat_
>_Paikat-taulu sisältää tiedot tiloista, joissa tapahtumia voidaan järjestää._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> paikka_id | int PK | Tilan/paikan id
> paikka_nimi | varchar(50) | Paikan nimi
> katuosoite | varchar(50) | Kohteen katuosoite
> postinumero | char(5) | Kohteen postinumero
> kaupunki | varchar(20) | Kaupunki, jossa kohde sijaitsee
#

> ### _Lipputyypit_
> _Lipputyypit-taulussa on tiedot erilaisista lipputyypeistä, joita tapahtumaan myydään. Jokainen lipputyyppi kuuluu yhteen tapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tyyppi_id | int PK | Lipputyypin id
> tapahtuma_id | int FK |  Tapahtuman id
> hinta | float | Lipun hinta
> tyyppi_kuvaus | varchar(50) | Lipputyypin kuvaus (esim. aikuinen)
#

> ### _Myyntitapahtumat_
> _Myyntitapahtumat-taulussa on tiedot kaikista myyntitapahtumista. Yksi myyntitapahtuma voi sisältää useita lippuja, useisiin eri tapahtumiin._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myynti_id | int PK | Myyntitapahtuman id
> myynti_aika | datetime |  Myyntitapahtuman ajankohta
#
> ### _Liput_
> _Liput-taulussa on tiedot yksittäisistä myydyistä lipuista. Jokainen lippu kuuluu yhteen lipputyypiin ja yhteen myyntitapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | int PK | Lipun id, yksilöllinen koodi jonka avulla esim. lipuntarkastaja tarkistaa lipun
> tyyppi_id | int FK |  Lipputyypin id
> myynti_id | int FK | Myyntitapahtuman id
