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
  ID               int(11) NOT NULL AUTO_INCREMENT, 
  Imprimante3DNom  varchar(255) NOT NULL, 
  DateRemplacement date NOT NULL, 
  DateFabrication  date, 
  NumeroDeSerie    varchar(255) NOT NULL UNIQUE, 
  QuantiteRestante int(10), 
  CoutAuMetre      int(10) NOT NULL, 
  CartoucheID      int(11) NOT NULL, 
  PRIMARY KEY (ID)) ;
CREATE TABLE codenouveau (
  Code      varchar(255) NOT NULL, 
  FabLabNom varchar(255) NOT NULL, 
  PRIMARY KEY (Code)) ;
CREATE TABLE fablab (
  Nom             varchar(255) NOT NULL, 
  imprimante3dNom varchar(255) NOT NULL, 
  MinTemperature  double NOT NULL, 
  MaxTemperature  double NOT NULL, 
  MinHumidite     double NOT NULL, 
  MaxHumidite     double NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE imprimante3d (
  Nom               varchar(255) NOT NULL, 
  JobID             int(11), 
  CartoucheID       int(11) NOT NULL, 
  FabLabNom         varchar(255) NOT NULL, 
  NbHeuresDeTravail double, 
  Etat              varchar(25), 
  DureeRestante     double, 
  CoutHoraire       int(10) NOT NULL, 
  imprimante3dNom   varchar(255) NOT NULL, 
  PRIMARY KEY (Nom)) ;
CREATE TABLE Job (
  ID                 int(11) NOT NULL AUTO_INCREMENT, 
  UtilisateurCode    varchar(255), 
  UtilisateurID      varchar(255) NOT NULL, 
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
  PRIMARY KEY (Code)) ;
ALTER TABLE codenouveau ADD CONSTRAINT FKcodenouvea757942 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE imprimante3d ADD CONSTRAINT FKimprimante127988 FOREIGN KEY (CartoucheID) REFERENCES Cartouche (ID);
ALTER TABLE Operateur ADD CONSTRAINT FKOperateur120528 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE Utilisateur ADD CONSTRAINT FKUtilisateu428262 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE fablab ADD CONSTRAINT FKfablab362569 FOREIGN KEY (imprimante3dNom) REFERENCES imprimante3d (Nom);
ALTER TABLE Ambiance ADD CONSTRAINT FKAmbiance747320 FOREIGN KEY (FabLabNom) REFERENCES fablab (Nom);
ALTER TABLE imprimante3d ADD CONSTRAINT FKimprimante662771 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Job ADD CONSTRAINT FKJob569345 FOREIGN KEY (UtilisateurCode) REFERENCES Utilisateur (Code);
