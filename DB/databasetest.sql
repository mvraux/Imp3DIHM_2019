drop schema if exists imp3d;
create schema imp3d;
use imp3d;

CREATE TABLE Ambiance (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  FabLabNom   varchar(255) NOT NULL, 
  Temperature double NOT NULL, 
  Humidite    double NOT NULL, 
  Datation    date, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Cartouche (
  ID               varchar(255) NOT NULL, 
  Imprimante3DNom  varchar(255) NOT NULL, 
  DateRemplacement date NOT NULL, 
  DateFabrication  date NOT NULL, 
  NumeroDeSerie    varchar(255) NOT NULL, 
  QuantiteRestante int(10), 
  CoutAuMetre      int(10) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE CodeNouveau (
  Code      varchar(255) NOT NULL, 
  FabLabNom varchar(255) NOT NULL, 
  PRIMARY KEY (Code)) ;
CREATE TABLE FabLab (
  Nom            varchar(255) NOT NULL, 
  MinTemperature double NOT NULL, 
  MaxTemperature double NOT NULL, 
  MinHumidite    double NOT NULL, 
  MaxHumidite    double NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Imprimante3D (
  Nom               varchar(255) NOT NULL, 
  FabLabNom         varchar(255) NOT NULL, 
  NbHeuresDeTravail double, 
  Etat              varchar(25), 
  DureeRestante     double NOT NULL, 
  CoutHoraire       int(10) NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Job (
  ID                 varchar(255) NOT NULL, 
  Imprimante3DNom    varchar(255) NOT NULL, 
  UtilisateurID      varchar(255) NOT NULL, 
  Nom                varchar(255) NOT NULL, 
  DateRealisation    double NOT NULL, 
  Etat               varchar(25) NOT NULL, 
  DureeConsommee     double NOT NULL, 
  ResteAFaireEstimee double, 
  SupportConsomme    int(10), 
  MatiereConsommee   int(10), 
  SupportEstime      int(10) NOT NULL, 
  MatiereEstimee     int(10) NOT NULL, 
  Prix               int(10) DEFAULT 0 NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Operateur (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  FabLabNom  varchar(255) NOT NULL, 
  Nom        varchar(255), 
  Prenom     varchar(255) NOT NULL, 
  MotDePasse varchar(255) NOT NULL, 
  Mail       varchar(255) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Utilisateur (
  ID              varchar(255) NOT NULL, 
  FabLabNom       varchar(255) NOT NULL, 
  Nom             varchar(255) NOT NULL, 
  Prenom          varchar(255) NOT NULL, 
  MotDePasse      varchar(255) NOT NULL, 
  Mail            varchar(255) NOT NULL, 
  Etablissement   varchar(255) NOT NULL, 
  DateInscription date NOT NULL, 
  NbJobsRealises  int(10), 
  NbEchecs        int(10), 
  MailValide      tinyint(1) DEFAULT 0, 
  PRIMARY KEY (ID));
 
ALTER TABLE CodeNouveau ADD CONSTRAINT FKCodeNouvea852895 FOREIGN KEY (FabLabNom) REFERENCES FabLab (Nom);
ALTER TABLE Cartouche ADD CONSTRAINT FKCartouche276977 FOREIGN KEY (Imprimante3DNom) REFERENCES Imprimante3D (Nom);
ALTER TABLE Operateur ADD CONSTRAINT FKOperateur956027 FOREIGN KEY (FabLabNom) REFERENCES FabLab (Nom);
ALTER TABLE Utilisateur ADD CONSTRAINT `< gère` FOREIGN KEY (FabLabNom) REFERENCES FabLab (Nom);
ALTER TABLE Job ADD CONSTRAINT `< job en cours` FOREIGN KEY (Imprimante3DNom) REFERENCES Imprimante3D (Nom);
ALTER TABLE Job ADD CONSTRAINT demande FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur (ID);
ALTER TABLE Ambiance ADD CONSTRAINT `historique >` FOREIGN KEY (FabLabNom) REFERENCES FabLab (Nom);
ALTER TABLE Imprimante3D ADD CONSTRAINT `met à disposition` FOREIGN KEY (FabLabNom) REFERENCES FabLab (Nom);
