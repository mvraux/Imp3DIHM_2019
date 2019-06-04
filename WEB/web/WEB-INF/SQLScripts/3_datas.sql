# ---------------------------------------------------------------------------- 
# Document   : 3_datas.sql
# Description: Base de données factice pour phase test de la conception d'IHM
# Author:      Vraux 
# Created:     18 Févr. 2019
# Modifiée:    15 Mai 2019
# Modification : déplacement des clefs étrangères en liaison avec le faflab
#                les quantités sont maintenant des double
#                les durées sont des entiers
#                le nom de chaque job est maintenant unique
# ---------------------------------------------------------------------------- 

use imp3d;

/*FABLAB*/
insert into fabLab ( Nom,MinTemperature,MaxTemperature,MinHumidite,MaxHumidite) values
    ("FabLab_Victor_Hugo",15,35,30,70);

/*IMPRIMANTES*/
insert into imprimante3d (Nom,NbHeuresDeTravail,CoutHoraire,FablabNom) values 
    ("uprint1",1500,800,"FabLab_Victor_Hugo");

/*OPERATEUR DE BASE*/
insert into operateur (FabLabNom, Nom, Prenom, MotDePasse, Mail ) values
    ("FabLab_Victor_Hugo", "Dumas", "Jean pierre","24C9E15E52AFC47C225B757E7BEE1F9D" /* = encrypted "user1"*/, "operateur@gmail.com" );
insert into operateur (FabLabNom, Nom, Prenom, MotDePasse, Mail ) values
    ("FabLab_Victor_Hugo", "Camus", "Alfred","24C9E15E52AFC47C225B757E7BEE1F9D" /* = encrypted "user1"*/, "acamus@gmail.com" );

/*UTILISATEURS*/
insert into utilisateur (Code, FabLabNom,Nom, Prenom, MotDePasse, Mail ,Etablissement ,DateInscription , NbJobsRealises ,NbEchecs , MailValide ) values
    ("SDQ5S7GFS98S","FabLab_Victor_Hugo","Millet","Bertrand","24C9E15E52AFC47C225B757E7BEE1F9D"/*= mdp = user1 encrypted*/,"user1@gmail.com","Lycée Bellevue","2018-01-01",2,1,TRUE);
insert into utilisateur (Code, FabLabNom,Nom, Prenom, MotDePasse, Mail ,Etablissement ,DateInscription , NbJobsRealises ,NbEchecs , MailValide ) values
    ("45A7W4D73","FabLab_Victor_Hugo","Lobe","Julie","C65A7625E9CE93B77E3F8E5D5EA86","julie.lobe@gmail.com","Rive gauche","2019-01-15",1,0,FALSE);
insert into utilisateur (Code, FabLabNom,Nom, Prenom, MotDePasse, Mail ,Etablissement ,DateInscription , NbJobsRealises ,NbEchecs , MailValide ) values
    ("21F3D4D56","FabLab_Victor_Hugo","Masso","Roland","C65A7625E9CE93B77E3F8E5D5EA86","roland.masso@gmail.com","Lycée Victor Hugo","2019-02-12",0,0,TRUE);

/*JOB*/
insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix, Imprimante3dNom) values
    ("45A7W4D73","poignée","2019-01-17 22:00:00","FINI",12000,0,40.32,12.18,0,0,1400,"uprint1");
insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix, Imprimante3dNom) values
    ("SDQ5S7GFS98S","cale","2019-01-17 10:00:00","FINI",32000,0,15.43,12.83,0,0,2620,"uprint1");
insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix, Imprimante3dNom) values
    ("45A7W4D73","vis","2019-01-05","FINI",13540,0,9.29,7.01,0,0,1660,"uprint1");
insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix, Imprimante3dNom) values
    ("SDQ5S7GFS98S","pieceqq","2019-01-17","FINI",15300,0,10.44,9.25,0,0,1950,"uprint1");
insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix, Imprimante3dNom) values
    ("SDQ5S7GFS98S","support","2019-04-04","EN_COURS",9832,2340,10.76,9.11,0,0,1050,"uprint1");

/*CODES*/
insert into codenouveau (Code, FabLabNom) values
    ("48876Q9SD4","FabLab_Victor_Hugo");
insert into codenouveau (Code, FabLabNom) values
    ("887SDQ657S","FabLab_Victor_Hugo");

/*CARTOUCHE*/
insert into cartouche (Imprimante3DNom, DateRemplacement, DateFabrication, 
            NumeroDeSerie, IndentifiantType, QuantiteRestante, CoutAuCm3) values
    ("uprint1","2019-01-01","2018-09-10","CARTEST4991-SUP","20B",487,150);
insert into cartouche (Imprimante3DNom, DateRemplacement, DateFabrication, 
            NumeroDeSerie, IndentifiantType, QuantiteRestante, CoutAuCm3) values
    ("uprint1","2019-01-01","2018-12-01","CARTEST4991-MAT","12A",527,1500);

/*AMBIANCE*/
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",12,60,"2019-02-18");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",12,70,"2019-02-19");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",14,50,"2019-02-20");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",13,40,"2019-02-21");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",9,50,"2019-02-22");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",6,30,"2019-02-23");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",10,50,"2019-02-24");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",12,70,"2019-02-25");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",15,50,"2019-02-26");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",17,60,"2019-02-27");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",20,50,"2019-02-28");
insert into ambiance (FabLabNom, Temperature, Humidite, Datation) values
    ("FabLab_Victor_Hugo",21,70,"2019-03-01");
