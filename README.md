# ArgosNg

## Description

Premiers pas dans l'univers JEE avec Maven, Hibernate & Spring. 

Je tente ici de mettre au point un PoC du vieillissant Argos (outil de gestion des organismes de formation du Conseil Régional des Hauts de France) en le divisant en plusieurs petits services indépendants.


## Environnement

**IDE:** Eclipse 4.11.0

**Server:** Tomcat 9.0.19

**JDK:** jdk-1.8.0_191

**DataBase:** PostgreSQL 9.1


## Installation

###Mise en place du projet

Cloner le repo

Créer un nouvel environnement de travail (si nécessaire)

Importez le projet dans Eclipse
	File > Import... > Existing Maven Projects
	
Installez les dépendances du projet
	Clic droit sur argosNg > Run as > Maven install
	

###Configuration de l'accès à la base de donnée.

Ouvrez le fichier `applicationContext.xml` dans `argosNg_web/src/main/webapp/WEB-INF`

Remplacez les propriétés  `url`, `username` et `password` par les votres.



## Lancement

Clic droit sur `argosNg_web` > Run as > Run on server > Tomcat v9.0 Server at localhost > Finish




