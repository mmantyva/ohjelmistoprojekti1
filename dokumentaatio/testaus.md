## Yksikkötestaus

### TypeRepositoryTest: findByNameShouldReturnType() 

Mitä testattiin: Testidatasta opiskelijalippujen hakeminen, joiden hinta pitäisi olla 10€ 

-> kaikki opiskelijaliput olivat 15€ hintaisia, joten testi antoi failuren. Testi ok. 

 

@Test 

    public void findByNameShouldReturnType() { 

        List<Type> types = repository.findByTypename("Student"); 

         

        assertThat(types).hasSize(1); 

        assertThat(types.get(0).getPrice()).isEqualTo(15.0); 

    } 

 

### TypeRepositoryTest: CreateNewType() 

Mitä testattiin: Uuden lipputyypin luominen  

-> uusi lipputyyppi syntyi onnistuneesti annetuilla parametreilla. Testi ok. 

 

 

    @Test 

    public void createNewType() { 

    	Type type = new Type("Really old person", 100.0, null); 

    	repository.save(type); 

    	assertThat(type.getTypeid()).isNotNull(); 

    }     

 

### VenueRepositoryTest: findByNameShouldReturnVenue() 

Mitä testattiin: Varmistetaan, että Tavastialla on oikea postinumero 

-> kaikki kunnossa, testi ok 

 

 

   @Test 

    public void findByNameShouldReturnVenue() { 

        List<Venue> venues = repository.findByVenuename("Tavastia"); 

         

        assertThat(venues).hasSize(1); 

        assertThat(venues.get(0).getPostcode()).isEqualTo("00100"); 

    } 

 

### VenueRepositoryTest: CreateNewVenue() 

Mitä testattiin: Uuden tapahtumapaikan luominen  

-> uusi tapahtumapaikka syntyi onnistuneesti annetuilla parametreilla. 

     

    @Test 

    public void createNewVenue() { 

    	Venue venue = new Venue("Jaffa-Halli", "Areenakuja 1", "00250", "Helsinki"); 

    	repository.save(venue); 

    	assertThat(venue.getVenueid()).isNotNull(); 

    }     


## Integraatio/API testaus: 

Meille syntyi mukavan orgaaninen tilanne testata APIa Postmanilla, koska teimme tietokantaan rakennemuutoksen. Laitoimme lipputyypin tietokannassa tapahtuman ja lipun väliin, ja halusimme testata tämän linkin toimivuutta. 

### POST: 

Tehdään uusia lipputyyppejä tiettyyn tapahtumaan. Tarkoitus on saada näiden kahden välinen linkki toimimaan. 

-> linkki toimii, testi ok 

Tehdään uusi lippu, jolle määritellään lipputyyppi, jota ei ole olemassa 

-> virheilmoitus, lippua ei pystytä luomaan väärällä lipputyypillä, testi ok 

 

### GET: 

Katsotaan, toimiiko seuraava ketju: tapahtumapaikkojen kautta pääsee tapahtumaan, jonka kautta pääsee lipputyyppiin, jonka kautta pääsee lippuihin 

-> kaikki toimii kuten pitää, testi ok 

 

### PATCH: 

Lipputyyppiin linkatun eventin muuttaminen toiseksi 

-> toimii, lipputyyppiin linkatun eventin tiedot päivittyvät testi ok 

Yksittäisen lipun merkitseminen käytetyksi onnistuu edelleen, eli lippuun ilmestyy aikaleima 

-> toimii, testi ok 

## E2E/client 

E2E-testauksessa testiskenaario on testata lipun käyttöä. Meillä on selaimella pyörivä React-clientti, jolla olisi tarkoitus saada aikaiseksi lipun myyminen tapahtumaan (joko suoraan tiettyyn eventtiin, tai lipputyypin kautta). Tämän testaaminen on valitettavasti vielä aika pahasti kesken, koska tiimin ei-niin-perinpohjainen React-osaaminen yhdistettynä tietokannan monimutkaisuuteen ja REST APIn kiemuroihin on osoittautunut melkoiseksi yhdistelmäksi... 

Lipunmyynticlientti osaa hakea tietokannastamme tietoa ja saa sen näkyville taulukkoon 

-> tämä on nyt se ainoa asia mikä toistaiseksi jotenkin toimii, testi ok 

 