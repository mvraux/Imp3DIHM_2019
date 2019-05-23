drop schema if exists imp3d;
create schema imp3d;
use imp3d;
CREATE TABLE Ambiance (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  FablabNom   varchar(255) NOT NULL, 
  Temperature double NOT NULL, 
  Humidite    double NOT NULL, 
  Datation    timestamp NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Cartouche (
  ID               int(10) NOT NULL AUTO_INCREMENT, 
  Imprimante3dNom  varchar(255), 
  DateRemplacement timestamp NOT NULL, 
  DateFabrication  timestamp, 
  TypeCartouche  varchar(255) NOT NULL, 
  NumeroDeSerie    varchar(255) NOT NULL UNIQUE, 
  QuantiteRestante real, 
  CoutAuMetre      int(10) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Codenouveau (
  Code      varchar(255) NOT NULL, 
  FablabNom varchar(255) NOT NULL, 
  PRIMARY KEY (Code)) ;
CREATE TABLE Fablab (
  Nom            varchar(255) NOT NULL, 
  MinTemperature double NOT NULL, 
  MaxTemperature double NOT NULL, 
  MinHumidite    double NOT NULL, 
  MaxHumidite    double NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Imprimante3D (
  Nom               varchar(255) NOT NULL, 
  FablabNom         varchar(255) NOT NULL, 
  NbHeuresDeTravail double, 
  Etat              varchar(255) NOT NULL, 
  DureeRestante     int(11), 
  CoutHoraire       int(10) NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Job (
  ID                 int(10) NOT NULL AUTO_INCREMENT, 
  Imprimante3DNom    varchar(255) NOT NULL, 
  UtilisateurCode    varchar(255) NOT NULL, 
  Nom                varchar(255) NOT NULL, 
  DateRealisation    timestamp NOT NULL, 
  Etat               varchar(255) NOT NULL, 
  DureeConsommee     int(11), 
  ResteAFaireEstimee int(11), 
  SupportConsomme    real, 
  MatiereConsommee   real, 
  SupportEstime      real, 
  MatiereEstimee     real, 
  Prix               int(11) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Operateur (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  FablabNom  varchar(255) NOT NULL, 
  Nom        varchar(255) NOT NULL, 
  Prenom     varchar(255), 
  MotDePasse varchar(255) NOT NULL, 
  Mail       varchar(255) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE Utilisateur (
  Code            varchar(255) NOT NULL, 
  FablabNom       varchar(255) NOT NULL, 
  Nom             varchar(255) NOT NULL, 
  Prenom          varchar(255), 
  MotDePasse      varchar(255) NOT NULL, 
  Mail            varchar(255) NOT NULL, 
  Etablissement   varchar(255) NOT NULL, 
  DateInscription timestamp NOT NULL, 
  NbJobsRealises  int(10), 
  NbEchecs        int(10), 
  MailValide      tinyint(1) NOT NULL, 
  PRIMARY KEY (Code)) ;
ALTER TABLE Codenouveau ADD CONSTRAINT FKCodenouvea343340 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Ambiance ADD CONSTRAINT FKAmbiance747320 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Utilisateur ADD CONSTRAINT FKUtilisateu428262 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Operateur ADD CONSTRAINT FKOperateur120528 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Cartouche ADD CONSTRAINT FKCartouche323664 FOREIGN KEY (Imprimante3dNom) REFERENCES Imprimante3D (Nom);
ALTER TABLE Job ADD CONSTRAINT FKJob972928 FOREIGN KEY (Imprimante3DNom) REFERENCES Imprimante3D (Nom);
ALTER TABLE Imprimante3D ADD CONSTRAINT FKImprimante388131 FOREIGN KEY (FablabNom) REFERENCES Fablab (Nom);
ALTER TABLE Job ADD CONSTRAINT FKJob569345 FOREIGN KEY (UtilisateurCode) REFERENCES Utilisateur (Code);
