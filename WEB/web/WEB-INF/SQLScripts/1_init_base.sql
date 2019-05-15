drop schema if exists imp3d;
create schema imp3d;
use imp3d;
CREATE TABLE Ambiance (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  FablabNom   varchar(255) NOT NULL, 
  Temperature double NOT NULL, 
  Humidite    double NOT NULL, 
  Datation    timestamp NOT NULL UNIQUE, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Cartouche (
  ID               int(11) NOT NULL AUTO_INCREMENT, 
  Imprimante3dNom  varchar(255) NOT NULL, 
  DateRemplacement timestamp NOT NULL, 
  DateFabrication  timestamp, 
  TypeCartouche  varchar(255) NOT NULL, 
  NumeroDeSerie    varchar(255) NOT NULL UNIQUE, 
  QuantiteRestante int(10), 
  CoutAuMetre      int(10) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Codenouveau (
  Code      varchar(255) NOT NULL, 
  FablabNom varchar(255) NOT NULL, 
  PRIMARY KEY (Code)) ;
CREATE TABLE Fablab (
  Nom             varchar(255) NOT NULL, 
  Imprimante3dNom varchar(255) NOT NULL, 
  MinTemperature  double NOT NULL, 
  MaxTemperature  double NOT NULL, 
  MinHumidite     double NOT NULL, 
  MaxHumidite     double NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Imprimante3d (
  Nom               varchar(255) NOT NULL, 
  JobID             int(11), 
  NbHeuresDeTravail double, 
  Etat              varchar(25), 
  DureeRestante     double, 
  CoutHoraire       int(10) NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Job (
  ID                 int(11) NOT NULL AUTO_INCREMENT, 
  UtilisateurCode    varchar(255) NOT NULL, 
  Nom                varchar(255) NOT NULL, 
  DateRealisation    timestamp NOT NULL UNIQUE, 
  Etat               varchar(25) NOT NULL, 
  DureeConsommee     double NOT NULL, 
  ResteAFaireEstimee double, 
  SupportConsomme    int(10), 
  MatiereConsommee   int(10), 
  SupportEstime      int(10), 
  MatiereEstimee     int(10), 
  Prix               int(10) DEFAULT 0, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Operateur (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  FablabNom  varchar(255) NOT NULL, 
  Nom        varchar(255), 
  Prenom     varchar(255) NOT NULL, 
  MotDePasse varchar(255) NOT NULL, 
  Mail       varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Utilisateur (
  Code            varchar(255) NOT NULL, 
  FablabNom       varchar(255) NOT NULL, 
  Nom             varchar(255) NOT NULL, 
  Prenom          varchar(255) NOT NULL, 
  MotDePasse      varchar(255) NOT NULL, 
  Mail            varchar(255) NOT NULL UNIQUE, 
  Etablissement   varchar(255), 
  DateInscription timestamp NOT NULL, 
  NbJobsRealises  int(10), 
  NbEchecs        int(10), 
  MailValide      tinyint(1) DEFAULT 0 NOT NULL, 
  PRIMARY KEY (Code)) ;
ALTER TABLE Codenouveau ADD CONSTRAINT FKCodenouvea343340 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Cartouche ADD CONSTRAINT FKCartouche323632 FOREIGN KEY (Imprimante3dNom) REFERENCES Imprimante3d (Nom);
ALTER TABLE Operateur ADD CONSTRAINT FKOperateur120528 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Utilisateur ADD CONSTRAINT FKUtilisateu428262 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Fablab ADD CONSTRAINT FKFablab469355 FOREIGN KEY (Imprimante3dNom) REFERENCES Imprimante3d (Nom);
ALTER TABLE Ambiance ADD CONSTRAINT FKAmbiance747320 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Imprimante3d ADD CONSTRAINT FKImprimante983223 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Job ADD CONSTRAINT FKJob569345 FOREIGN KEY (UtilisateurCode) REFERENCES Utilisateur (Code);
