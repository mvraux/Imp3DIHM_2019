/* 
 * Génération du code SQL à partir de Visual Paradigm
 * après suppression de la ligne "type=InnoDB"
 * non-compatible avec cette version de MYSQL
 * transformation du nom des tables en minuscules 
 */
/**
 * Author:  Vraux Maxence
 * Created: 18 févr. 2019
 */

drop schema if exists imp3d;
create schema imp3d;
use imp3d;

CREATE TABLE ambiance (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  FabLabNom   varchar(255) NOT NULL, 
  Temperature double NOT NULL, 
  Humidite    double NOT NULL, 
  Datation    date, 
  PRIMARY KEY (ID));
CREATE TABLE cartouche (
  ID               int(11) NOT NULL AUTO_INCREMENT, 
  Imprimante3DNom  varchar(255) NOT NULL, 
  DateRemplacement date NOT NULL, 
  DateFabrication  date, 
  NumeroDeSerie    varchar(255) NOT NULL UNIQUE, 
  QuantiteRestante int(10), 
  CoutAuMetre      int(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE codenouveau (
  Code      varchar(255) NOT NULL, 
  FabLabNom varchar(255) NOT NULL, 
  PRIMARY KEY (Code));
CREATE TABLE fablab (
  Nom            varchar(255) NOT NULL, 
  MinTemperature double NOT NULL, 
  MaxTemperature double NOT NULL, 
  MinHumidite    double NOT NULL, 
  MaxHumidite    double NOT NULL, 
  PRIMARY KEY (Nom));
CREATE TABLE imprimante3d (
  Nom               varchar(255) NOT NULL, 
  FabLabNom         varchar(255) NOT NULL, 
  NbHeuresDeTravail double, 
  Etat              varchar(25), 
  DureeRestante     double, 
  CoutHoraire       int(10) NOT NULL, 
  PRIMARY KEY (Nom));
CREATE TABLE job (
  ID                 int(11) NOT NULL AUTO_INCREMENT, 
  Imprimante3DNom    varchar(255) NOT NULL, 
  UtilisateurCode      varchar(255) NOT NULL, 
  Nom                varchar(255) NOT NULL, 
  DateRealisation    date NOT NULL, 
  Etat               varchar(25) NOT NULL, 
  DureeConsommee     double NOT NULL, 
  ResteAFaireEstimee double, 
  SupportConsomme    int(10), 
  MatiereConsommee   int(10), 
  SupportEstime      int(10), 
  MatiereEstimee     int(10), 
  Prix               int(10) DEFAULT 0, 
  PRIMARY KEY (ID));
CREATE TABLE operateur (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  FabLabNom  varchar(255) NOT NULL, 
  Nom        varchar(255), 
  Prenom     varchar(255) NOT NULL, 
  MotDePasse varchar(255) NOT NULL, 
  Mail       varchar(255) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE utilisateur (
  Code            varchar(255) NOT NULL, 
  FabLabNom       varchar(255) NOT NULL, 
  Nom             varchar(255) NOT NULL, 
  Prenom          varchar(255) NOT NULL, 
  MotDePasse      varchar(255) NOT NULL, 
  Mail            varchar(255) NOT NULL, 
  Etablissement   varchar(255), 
  DateInscription date NOT NULL, 
  NbJobsRealises  int(10), 
  NbEchecs        int(10), 
  MailValide      tinyint(1) DEFAULT 0 NOT NULL, 
  PRIMARY KEY (Code));

ALTER TABLE codenouveau ADD CONSTRAINT FKcodenouvea757942 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE cartouche ADD CONSTRAINT FKcartouche404221 FOREIGN KEY (Imprimante3DNom) REFERENCES imprimante3d (Nom);
ALTER TABLE operateur ADD CONSTRAINT FKoperateur849443 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE utilisateur ADD CONSTRAINT FKutilisateu673020 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE imprimante3d ADD CONSTRAINT FKimprimante708551 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE ambiance ADD CONSTRAINT FKambiance391513 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE job ADD CONSTRAINT FKjob683260 FOREIGN KEY (Imprimante3DNom) REFERENCES imprimante3d (Nom);
ALTER TABLE job ADD CONSTRAINT FKjob281956 FOREIGN KEY (UtilisateurCode) REFERENCES utilisateur (Code);


