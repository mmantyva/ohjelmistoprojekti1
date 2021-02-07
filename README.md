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
