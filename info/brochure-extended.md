# NOTE

Dit is een **samengevatte versie** van het `brochure2233.pdf` document. Dit document bevat alle punten die van belang zijn voor het effectief uitvoeren van het project. Voor de volledige uitleg over het project, gelieve het document `brochure2233.pdf` te lezen.

## **BELANGRIJK**
Bewaar niets enkel lokaal op jouw pc. Zorg ervoor dat alles op elk moment online toegankelijk is!

De recentste code staat op github, de recentste analyse + ontwerp vinden we op VP online, andere documenten deel je via OneDrive voor alle teamleden én de begeleidende lector.

# CONTACTMOMENT

Elke **vrijdag voormiddag** van **08:15 tot 10:15** in lokaal **GSCHB.3.037**, **VERPLICHTE AANWEZIGHEID!**

# BROCHURE

**Vakken die je moet beheersen:**
* Databases
* Software Analysis
* Object-Oriented Software Development I (OOSD I)
* Object-Oriented Software Development II (OOSD II)

**Iedereen** in de projectgroep werkt mee aan elk onderdeel (analyse, ontwerpen, testen, programmeren, databank).


## Planning gedurende het semester

| Week | TODO |
|------|------|
| 1 | online infosessie bijwonen + inschrijven in een groep |
| 2 | werkomgeving opzetten (uitleg documenten + instructiefilmpjes) |
| 3 | starten met use case 1 |
| 4-11 |  wekelijks contactmoment waarbij vooruitgang opgevolgd kan worden, vragen besproken kunnen worden |
| 12 | indienen eindresultaat van het project |
| 13 | technische eindpresentatie |

## Contactmomenten

**Afwezig op contactmoment?** > verwittigen van de begeleidende lector en groepsleden + officieel melden via **iBamaFlex** binnen de **48u**!

**Afwezig op eindpresentatie?** > AFW eerste zit, moet ingehaald worden tijdens de feedback van de tweede zit.

**2 of meer ongewettigde afwezigheden?** > AFW als examencijfeer het opleidingsonderdeel EN neem de afwezigheden mee naar je tweede zit.

# Opdracht

## Wat is Splendor?

Splendor is een kaartspel voor 2 tot 4 spelers. Tijdens het spel verzamel je edelsteenfiches waar je weer ontwikkelingskaarten mee kunt kopen. Met deze kaarten kun je punten verdienen maar ze staan ook garant voor een bonus. Met deze bonus kun je volgende ontwikkelingskaarten die je wilt kopen weer goedkoper krijgen. Ondertussen probeer je combinaties te maken van de ontwikkelingskaarten waardoor je edellieden naar je toe kunt trekken. Hiermee scoor je weer extra punten. Zodra iemand 15 punten heeft behaald gaat mag een ieder nog zijn beurt afmaken. Als iedereen evenveel beurten heeft gehad wint de speler met de meeste punten.

[> Spelregels uitgelegd op YouTube](https://www.youtube.com/watch?v=rue8-jvbc9I&ab_channel=WatchItPlayed)

## Hoe pak je het project aan?

De opgave van het spel werd uitgeschreven in een aantal use cases. De use cases zijn het contract met je klant, hierin staat beschreven hoe het precies allemaal moet werken. Begin dus niet in het wilde weg te programmeren. Volg exact wat er beschreven staat in de use case. Doorloop alle fasen van een iteratie (analyse, ontwerp, testen, implementatie). Als de ene iteratie afgewerkt is kan je met de volgende starten.

1. UC1 - Maak nieuw spel
2. UC2 - Speel spel
3. UC3 - Speel ronde
4. UC4 - Speel beurt

Maak per use case (bevat alle vereiste functionaliteit).

> Klik op de referenties om de criterium ervan te bekijken

1. Maak per use case:

    * [Ontwerp van de database](#criterium-5-databank)
    * [Analyse](#criterium-1-analyseren)
    * [Ontwerp DCD](#criterium-2-ontwerpen)
    * [Console Applicatie](#criterium-4-programmeren)

2. [Ontwikkel een Grafische User Interface](#criterium-3-volledigheid-product-qua-niet-functionele-requirements)

3. [Applicatie is meertalig](#criterium-3-volledigheid-product-qua-niet-functionele-requirements)

4. Per use case wordt een **werkdossier** aangevuld:
    * [Ontwerp van de database](#criterium-5-databank)
    * [Analyse](#criterium-1-analyseren)
    * [Ontwerp DCD](#criterium-2-ontwerpen)

5. [Logboek](#logboek) bijhouden.

    [> Logboek openen](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

6. [Opvolgingsformulier](#opvolgingsformulier) bijhouden.

    [> Opvolgingsformulier openen](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

[> VOLLEDIGE PRODUCTONTWIKKELING OPENEN](#productontwikkeling)

# Puntenverdeling

70% > Product + Productontwikkeling  
30% > Proces (groepswerk, attitudes)

## Product (eindresultaat)

### Criterium 1: Volledigheid product qua vorm

1. einddossier met
    * inhoudstafel
    * genummerde blz.
    * **per UC analyse, ontwerp, databank**
    * reflectie ivm groepswerk van elk groepslid
2. Eclipse project met code en VP UML-diagrammen
3. gegenereerde javadoc API van het domein

### Criterium 2: Volledigheid product qua functionaliteit

Alle functionaliteiten zijn beschreven in de use cases.

### Criterium 3: Volledigheid product qua niet functionele requirements

* user interface (console / grafisch)
* **meertalige applicatie**

## Productontwikkeling

### Criterium 1: Analyseren

**Regels uit Sofware Analysis toepassen!**

* activity diagram
* domeinmodel
* SSD, bijhorende OC’s

### Criterium 2: Ontwerpen

**Regels uit OOSD I en de opgestelde analyse toepassen!**

Opstellen van het DCD:
* DCD sluit aan op SSD’s
* DCD bevat wat beschreven werd in OC

### Criterium 3: Testen

Elke "pure" domeinklasse, d.w.z. NIET DomeinController en repositoryklassen, wordt via JUNIT testen voldoende getest.

### Criterium 4: Programmeren

**Regels uit OOSD I, OOSD II en de opgestelde ontwerk toepassen!**

* respect voor OO
* respect voor de 3 lagen
* correct documenteren doorheen volledige proces
* robuuste applicatie
* in de code vind je de juiste methodes vanop het DCD terug

### Criterium 5: Databank

**Regels uit Databases toepassen!**

* conceptueel model ERD
* overeenkomstig relationeel model
* script met de DDL-instructies voor de implementatie in relationele databank (MySQL)

Je moet data kunnen lezen & schrijven!

## Proces

### Criterium 1: Registreren

Logboek en opvolgingsformulier aanvullen.

### Criterium 2: Plannen

Wekelijkse planning opstellen, werken volgens die planning en controleren of je op schema zit.

### Criterium 3: Teamwork

Goed samenwerken en dit ook stimuleren.

### Criterium 4: Voorbereiding wekelijks contactmoment

Voorbereiding betekent:
* Voorleggen en op de hoogte zijn van het werk van de voorbije week
* Vragen opsommen en meebrengen

### Criterium 5: Omgaan met feedback / adviezen volgen

Dit gaat om zowel inhoudelijke feedback als procesmatige feedback.

### Criterium 6: Stiptheid

Wees elke afspraak (online of op school) stipt op tijd.

> Per criterium worden 5 levels beschreven (zie extra’s). Twee maal (halverwege het semester en op het eind) zal je voor jezelf moeten bepalen op welk level je je bevindt per criterium en dat ook wat duiden. Zelfkennis is een belangrijke schakel in het succesvol werken in team.

# Eindproducten

Op het einde van de projectwerking geef je een verzorgd dossier af met daarin:
* Voorblad (zie Chamilo)
* ERD, relationeel model, script met DDL-instructies (per use case indien van toepassing)
* Analyse en ontwerp (domeinmodel, activiteitendiagram, SSD, OC en DCD) per use case (of
scenario indien van toepassing);
* 1 A4 blad tekst per groepslid met je ervaringen ivm groepswerk: wat heb je geleerd, wat waren
de moeilijkheden, wat zijn jouw sterke punten, …

Via de opdrachtenmodule van Chamilo dien je je project in:  
Maak 1 zip-bestand met daarin:

* Verzorgd dossier
* Eclipse project met de javacode
* De gegenereerde Java documentatie van de code (Javadoc)
* De volledige analyse en ontwerp (vpp-bestand van Visual Paradigm)
* Script met DDL-instructies van de MySQL database
* Exportbestand van de MySQL database (alle data)

**Dit afgewerkte dossier laad je op via de opdrachtenmodule in Chamilo vóór maandag 15 mei 23u59**

## Opname

**Je maakt via Teams (opname van een vergadering met het volledige team) een filmpje waarin je jullie eindresultaat demonstreert.**  
Het eindresultaat is een applicatie met een grafische user
interface waarbij je alle gevraagde functionaliteiten kan tonen.   
Ook dit filmpje is groepswerk, elk teamlid komt aan het woord. 
Dit filmpje is via teams beschikbaar ten laatste maandag 15 mei 23u59.   
Dit filmpje is geen montage, er moet niets geknipt worden, het is dus de opname van een
live demo.

## Digitaal Dossier

Tijdens het semester bouw je ook een digitaal dossier op. Elke groep krijgt zijn eigen documenten folder op OneDrive. Deze folder is enkel toegankelijk voor de groepsleden én alle begeleidende
lectoren

## Logboek
    
Telkens een groepslid aan het project werkt noteert die de details van het gedane werk (omschrijving en tijdsregistratie) meteen ook in het logboek.

Ook het opvolgingsformulier krijgt hier een plaats.

[> Logboek openen](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

## Opvolgingsformulier

Als voorbereiding op de wekelijkse afspraak met je begeleidende lector vul je het opvolgingsformulier in (wat is er gebeurd de voorbije week en wat zullen we doen de komende week, groepsafspraken, mogelijke vragen ….)

### DONE 

**Dit vul je aan vóór de afspraak!** Wat heb je de voorbije week gedaan?

### TODO:
**Dit vul je aan vóór de afspraak!** Wat ben je van plan te doen de komende week?

### Hoe verloopt het groepswerk?
Noteer hier alle probleempjes, vragen, sterke punten, …

[> Opvolgingsformulier openen](https://hogent-my.sharepoint.com/:w:/r/personal/liesbeth_lewyllie_hogent_be/_layouts/15/Doc.aspx?sourcedoc=%7B332FAE97-C205-4E55-975D-1E1DF1F000CA%7D&file=opvolgingsformulier.docx&action=default&mobileredirect=true)

# Eindpresentatie: voorbeeldvragen

1. Hoe werken resourcebundels? Wat is het nut ervan? Toon in de code hoe je ermee werkt. Leg uit.
2. Wat is het nut/voordeel van de javadoc-comment? Toon aan.
3. Toon aan dat je applicatie voor UC…. een robuuste applicatie is.
4. Wat is de taak/zijn de verantwoordelijkheden van een DomeinController? Staaf telkens met een voorbeeld in jullie project.
5. Wat zijn de verantwoordelijkheden van een repositoryklasse? Staaf telkens met een voorbeeld in jullie project.
6. Wat doet een mapperklasse? Bespreek de code van een methode in zo’n mapperklasse.
7. Illustreer hoe en tot welke producten je tijdens de analyse van UC x bent gekomen (domeinmodel/SSD/OC/AD).
8. Illustreer hoe doing en knowing verantwoordelijkheden gescheiden worden gehouden in het project.
9. Illustreer op welke manier je GRASP patronen (controlller expert/creator) hebt toegepast bij het maken van het ontwerp.
10. Leg bondig het 3-lagen model uit en illustreer de toepassing ervan adhv een voorbeeld uit je code.
11. Het ontwerp van de grafische laag is heel programmeertaalafhankelijk. Leg uit hoe je deze laag opgebouwd hebt in jullie project.
12. Eventafhandeling en/of wisselen van scherm: toon hiervan een voorbeeld uit jullie project en leg de code uit.
13. Illustreer hoe je jouw applicatie getest heb aan de hand van analyse schema’s voor UCx.
14. Bespreek hoe en waarom jouw domeinmodel, EERD en DCD verschillend zijn.
15. Toon aan en leg uit hoe je zeker bent dat domeinklasse X goed werkt.
