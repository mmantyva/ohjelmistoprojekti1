# Ohjelmistoprojekti I: TicketGuru

Hyvä ohjelmointitiimi: Eero Koski, Niina Kuusisto, Mikko Martikainen, Maisa Mäntyvaara

## Johdanto

Lipputoimistona toimiva asiakasyritys on tilannut lipunmyyntijärjestelmän lippujen myymiseen myyntipisteessään. Järjestelmää käyttävät lipputoimiston työntekijät, joilla tulee olla mahdollisuus määritellä tapahtumat, joihin lippuja myydään sekä myydä ja tulostaa liput asiakkaille. Jatkokehityksessä järjestelmään voidaan lisätä verkkokauppa, josta asiakkaat voivat itse ostaa lippuja.

### Taustaa ja asiakkaan toiveita lipunmyyntijärjestelmän toiminnalle:
* Lipputoimisto voi määritellä järjestelmään tapahtumat, joihin lippuja myydään. 
* Lipputoimisto voi määrittää järjestelmään erilaisia lipputyyppejä ja niille hinnat.
* Lipunmyyjä myy ja tulostaa asiakkaalle liput lipunmyyntipisteessä. 
* Ennakkomyynnin loputtua loput liput tulostetaan ovella myytäviksi. 
* Lipuissa on koodi, joka voidaan tarkastaa helposti ovella ja jolla lippu voidaan merkitä käytetyksi.
* Järjestelmästä lipputoimisto saa tarkasteltavaksi myyntiraportteja, joissa myyntitapahtumat on eriteltynä.
* Jatkokehityksessä järjestelmään aiotaan lisätä vielä verkkokauppa, jolla lipputoimiston asiakkaat voivat itse ostaa lippuja.

Palvelu toteutetaan Javalla Spring Boot -kehystä käyttäen. Tietokantana on Postgresql ja frontend toteutetaan Reactilla. Lipunmyyntijärjestelmää on tarkoitus käyttää vain tietokoneelta käsin eli käytettävinä päätelaitteina ovat pöytäkone ja läppäri.

## Järjestelmän määrittely
### Käyttäjäroolit
Ensimmäisessä vaiheessa järjestelmän käyttäjille on tunnistettu seuraavat roolit:
* **Tapahtumien määrittelijä**. Henkilö, joka määrittelee järjestelmään tapahtumat, joihin myydään lippuja sekä eri lipputyypit tapahtumakohtaisesti.
* **Raportoija**. Henkilö, joka tarvitsee järjestelmästä raportit eri tapahtumiin myydyistä lipusta.
* **Lipunmyyjä**. Henkilö, joka myy ja tulostaa asiakkaalle liput.
* **Lipuntarkastaja**. Henkilö joka tarkastaa liput tapahtumassa.
* **Asiakas**. Henkilö, joka ostaa lipun johonkin tapahtumaan.

Alustava käyttötapauskaavio:

![käyttötapauskaavio](https://github.com/mmantyva/ohjelmistoprojekti1/blob/develop/dokumentaatio/roolit1.jpg)

### Käyttäjätarinat

(Tässä lipputoimiston edustaja = henkilöt, jotka ovat käyttötapauskaaviossa "tapahtuman määrittelijä" ja "raportoija")
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
Järjestelmän tietokantarakenne koostuu viidestä tietokantataulusta: tapahtumapaikoista, tapahtumista, yksittäisistä lipuista, lipputyypeistä ja myyntitapahtumista.

Tietokannat ja niiden väliset yhteydet on kuvattuna alla olevassa kaaviossa:

![Tietokantakaavio](https://github.com/mmantyva/ohjelmistoprojekti1/blob/develop/dokumentaatio/tietokanta.jpg)

Tietokantaan sisältyvät elementit ja niiden attribuutit esitettynä tietohakemistossa:

> ### _Vents_
> _Vents-taulu sisältää tiedot tapahtumista, joihin myydään lippuja. Yhteen tapahtumaan voidaan myydä useita eri lipputyypejä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ventid | long PK | Tapahtuman id
> venueid | long FK | Paikan id, jossa tapahtuma järjestetään
> ventname | String |  Tapahtuman nimi
> performer | String | Tapahtumassa esiintyvä artisti, ryhmä tms
> capacity | int | Asiakaspaikkojen määrä, määrittää kuinka monta lippua voidaan myydä
> venttime | datetime | Tapahtuman ajankohta
> description | String | Lyhyt kuvaus tapahtumasta
#

> ### _Venues_
>_Venues-taulu sisältää tiedot tiloista, joissa tapahtumia voidaan järjestää._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> venueid | long PK | Tilan/paikan id
> venuename | String | Paikan nimi
> address | String | Kohteen katuosoite
> postcode | Strin) | Kohteen postinumero
> city | String | Kaupunki, jossa kohde sijaitsee
#

> ### _Types_
> _Types-taulussa on tiedot erilaisista lipputyypeistä, joita tapahtumaan myydään. Jokainen lipputyyppi kuuluu yhteen tapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> typeid | long PK | Lipputyypin id
> price | float | Lipun hinta
> typename | String | Lipputyypin kuvaus (esim. aikuinen)
> ventid | long FK | Tapahtuman id
#

> ### _Transactions_
> _Transactions-taulussa on tiedot kaikista myyntitapahtumista. Yksi myyntitapahtuma voi sisältää useita lippuja, useisiin eri tapahtumiin._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> trid | long PK | Myyntitapahtuman id
> trtime | Date |  Myyntitapahtuman ajankohta (tämänhetkinen aikaleima)
#
> ### _Tickets_
> _Tickets-taulussa on tiedot yksittäisistä myydyistä lipuista. Jokainen lippu kuuluu yhteen lipputyypiin ja yhteen myyntitapahtumaan._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ticketid | long PK | Lipun id 
> UUID | UUID | Yksilöllinen koodi jonka avulla esim. lipuntarkastaja tarkistaa lipun
> used | Date | Ajankohta, jolloin lippu on merkitty käytetyksi (tämänhetkinen aikaleima)
> typeid | long FK |  Lipputyypin id
> trid | long FK | Myyntitapahtuman id
#


## Tekninen kuvaus

Kehityksen alkuvaiheessa käytimme tietokannan rakentamisessa H2-kantaa. Nyt tietokanta pyörii Postgresilla.

[REST-rajapinnan kuvaus on omassa dokumentaatioissaan.](https://github.com/mmantyva/ohjelmistoprojekti1/blob/develop/dokumentaatio/rajapinnankuvaus.md)
## Autentikointi

Järjestelmässä käytetään alkuvaiheessa Basic authentication:a. Käyttäjätietoja ylläpidetään Users-taulussa:

>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> userid | long PK | Käyttäjän id
> firstName | String |  Käyttäjän etunimi
> lastName | String | Käyttäjän sukunimi
> username | String | Käyttäjätunnus
> password | String | Salasana
> role | String | Käyttäjärooli

Salasanoista tallennetaan BCrypt tiiviste.

Testikäyttöön H2-kantaan luodaan käynnistyksen yhteydessä yksi testikäyttäjä, jonka tunnukset ovat ***user/user***
