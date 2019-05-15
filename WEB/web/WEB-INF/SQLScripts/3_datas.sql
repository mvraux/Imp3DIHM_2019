/* 
 * Base de données factice pour phase test de la conception d'IHM
 */
/**
 * Author:  Vraux Maxence
 * Created: 18 févr. 2019
 */


use imp3d;

/*IMPRIMANTE*/

insert into imprimante3d (Nom,NbHeuresDeTravail,Etat,DureeRestante,CoutHoraire) values
    ("uprint1",1500,"REPOS",22,800);
/*FABLAB*/

insert into fabLab ( Nom,Imprimante3dNom,MinTemperature,MaxTemperature,MinHumidite,MaxHumidite) values
    ("FabLab_Victor_Hugo","uprint1",15,35,30,70);

/*OPERATEUR DE BASE*/

insert into operateur (FabLabNom, Nom, Prenom, MotDePasse, Mail ) values
    ("FabLab_Victor_Hugo", "Dumas", "Jean pierre","F249E840CED9529375E9DA6F2887EC75" /* = encrypted "vhimp3d2019"*/, "operateur@gmail.com" );
insert into operateur (FabLabNom, Nom, Prenom, MotDePasse, Mail ) values
    ("FabLab_Victor_Hugo", "tech", "terrain","F249E840CED9529375E9DA6F2887EC75" /* = encrypted "vhimp3d2019"*/, "techvhimp3d@gmail.com" );


/*UTILISATEURS*/
insert into utilisateur (Code, FabLabNom,Nom, Prenom, MotDePasse, Mail ,Etablissement ,DateInscription , NbJobsRealises ,NbEchecs , MailValide ) values
    ("SDQ5S7GFS98S","FabLab_Victor_Hugo","Millet","Bertrand","C65A7625E9CE93B77E3F8E5D5EA86"/*= mdpuser encrypted*/,"user1@gmail.com","Lycée Bellevue","2018-01-01",2,1,TRUE);

insert into utilisateur (Code, FabLabNom,Nom, Prenom, MotDePasse, Mail ,Etablissement ,DateInscription , NbJobsRealises ,NbEchecs , MailValide ) values
    ("45A7W4D73","FabLab_Victor_Hugo","Lobe","Julie","C65A7625E9CE93B77E3F8E5D5EA86","user2@gmail.com","Rive gauche","2019-01-15",1,0,FALSE);

/*JOB*/

insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix) values
    ("45A7W4D73","poignée","2019-01-17 22:00:00","FINI",18,0,40,12,0,0,14400);

insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix) values
    ("SDQ5S7GFS98S","cale","2019-01-17 10:00:00","FINI",5,0,15,12,0,0,720);

insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix) values
    ("45A7W4D73","vis","2019-01-05","FINI",2,0,9,7,0,0,360);

insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix) values
    ("SDQ5S7GFS98S","pieceqq","2019-01-17","FINI",3,0,10,9,0,0,450);

insert into job (UtilisateurCode, Nom, DateRealisation , Etat, DureeConsommee, ResteAFaireEstimee, SupportConsomme, MatiereConsommee, SupportEstime, MatiereEstimee, Prix) values
    ("SDQ5S7GFS98S","support","2019-04-04","EN_COURS",3,0,10,9,0,0,450);

/*CODES*/

insert into codenouveau (Code, FabLabNom) values
    ("48876Q9SD4","FabLab_Victor_Hugo");

insert into codenouveau (Code, FabLabNom) values
    ("887SDQ657S","FabLab_Victor_Hugo");

/*CARTOUCHE*/

insert into cartouche (Imprimante3DNom, DateRemplacement,TypeCartouche, NumeroDeSerie, QuantiteRestante, CoutAuMetre) values
    ("uprint1","2019-01-01","SUPPORT","CARTESTSUP",487,1500);
insert into cartouche (Imprimante3DNom, DateRemplacement,DateFabrication,TypeCartouche, NumeroDeSerie, QuantiteRestante, CoutAuMetre) values
    ("uprint1","2019-01-01","2018-12-01","MATIERE","CARTESTMAT",487,1500);

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

