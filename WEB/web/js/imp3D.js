/**
    Document    : imp3D.js
    Description : Gestion javascript des 3 pages d'accueil
    Created on  : Mars 2019
    Author      : Tessier
*/

// ---------------- Variables globales en javascript --------------
// 
// liste de tous les utilisateurs envoyé par le script serveur
var utilisateurs;
// liste de tous les operateurs envoyé par le script serveur
var operateurs;
// liste de jobs envoyé par le script serveur 
// tous pour l'opérateur connecté, les siens pour l'utilisateur connecté
var jobs;
// gère le confirmation ou non de la demande
var confirmation = false;

// ----------------- Callback en JS ------------------- 
// cette fonction est lancée au chargement de la page
// elle déclare les callbacks pour chaque événement à prendre en compte
$(function () {
    
    // ------------------ gestion des jobs ------------------------
    // clic sur l'icone avec l'oeil
    $("[nom=jobRead]").on("click", afficheJobRead);
    // clic sur l'icone avec la croix
    $("[nom=jobDelete]").on("click", afficheJobDelete);
    // clic sur le bouton de confirmation de la suppression
    $("#btnJobDelete").on("click", jobDelete);
    $("#popupJobDelete").on("popupafterclose", popupOpenCmd);
    // fermeture de la popup modale lorsque la demande ajax est terminée
    $("#btnCmdClose").on("click", popupCloseCmd);
    
    // -------------- gestion des operateurs ----------------------
    // clic sur l'icone avec la croix
    $("[nom=operateurDelete]").on("click", afficheOperateurDelete);
    // clic sur le bouton de confirmation de la suppression
    $("#btnOperateurDelete").on("click", operateurDelete);
    $("#popupOperateurDelete").on("popupafterclose", popupOpenCmd);
    $("#ocValider").on("click", operateurCreer); 
    $("#popupOperateurCreate").on("popupafterclose", popupOpenCmd);
    
    // -------------- gestion des utilisateurs --------------------
    // clic sur l'icone avec l'oeil
    $("[nom=userRead]").on("click", afficheUserRead);
    // clic sur l'icone avec la croix
    $("[nom=userDelete]").on("click", afficheUserDelete);
    // clic sur le bouton de confirmation de la suppression
    $("#btnUserDelete").on("click", userDelete);
    // On utilise cette méthode car en JQM la fermeture d'une popup
    // suivi d'une ouverture d'une autre popup ne marche pas
    // donc on fait l'ouverture par évènement
    $("#popupUserDelete").on("popupafterclose", popupOpenCmd);
});


/**
 * Demande au serveur en Ajax de supprimer un opérateur
 */
function operateurCreer() {
    var nom = $("#ocNom").val();
    var prenom = $("#ocPrenom").val();
    var mail = $("#ocMail").val();
    var pwd = $("#ocPwd").val();
    
    confirmation = true;
    $('#popupTextSendCmd').text("Un des champs n'est pas valide.");
    if ((nom.length == 0) || (prenom.length == 0) 
                || (mail.length == 0) || (pwd.length == 0)) {
        $('#popupTextSendCmd').text("Un des champs n'est pas valide.");
        $("#popupOperateurCreate").popup("close");
        return;
    }
    $("#popupOperateurCreate").popup("close");
    $("#btnCmdClose").hide();
    $('#progressBar').show();
    $.ajax({
        url  : 'ajax_operateurCreate.jsp',
        type : 'POST',
        data : {
            nom: nom ,
            prenom: prenom,
            mail: mail,
            pwd: pwd
            },
        dataType : 'html',
        success: function(data) {
            $('#progressBar').hide();
            // on met le texte reçu dans la popup de confirmation
            $('#popupTextSendCmd').text(data);
            if (data.indexOf("OK") != -1) {
                // je préfère recharger la page, c'est plus simple
                document.location.href="o_accueil.jsp";
            }
            $("#btnCmdClose").show();
        },
        error : function(resultat, statut, erreur) {
            $('#progressBar').hide();
            $('#popupTextSendCmd').text(data);
            $("#btnCmdClose").show();
            return false;
        }
    });
}

/**
 * Complète la popup de suppression d'un opérateur avec les données correspondantes
 * un attribut 'num' de l'élément sélectionné permet d'identifier l'opérateur
 */
function afficheOperateurDelete() {
    // je récupère l'id de l'élément cliqué !
    var num = this.getAttribute('num');
    $("#odNom").text("Nom: " + operateurs[num].nom);
    $("#odPrenom").text("Prénom: " + operateurs[num].prenom);
    $("#odMail").text("Mail: " + operateurs[num].mail);
    $("#odNum").text(num);
}

/**
 * Demande au serveur en Ajax de supprimer un opérateur
 */
function operateurDelete() {
    var mail = $("#odMail").text();
    var num = $("#odNum").text();
    
    confirmation = true;
    $("#popupOperateurDelete").popup("close");
    $("#btnCmdClose").hide();
    $('#progressBar').show();
    $.ajax({
        url  : 'ajax_operateurDelete.jsp',
        type : 'POST',
        data : 'mail=' + mail,
        dataType : 'html',
        success: function(data) {
            $('#progressBar').hide();
            // on met le texte reçu dans la popup de confirmation
            $('#popupTextSendCmd').text(data);
            // on enlève la ligne de l'opérateur supprimé
            if (data.indexOf("OK") != -1) {
                $("#o" + num).remove();
                // operateurs.splice(num, 1);
                // console.log(operateurs);
            }
            $("#btnCmdClose").show();
        },
        error : function(resultat, statut, erreur) {
            $('#progressBar').hide();
            $('#popupTextSendCmd').text(data);
            $("#btnCmdClose").show();
            return false;
        }
    });
}

/**
 * Complète la popup de détails d'un user avec les données correspondantes
 * un attribut 'num' de l'élément sélectionné permet d'identifier le utilisateur
 */
function afficheUserRead() {
    // je récupère l'id de l'élément cliqué !
    var num = this.getAttribute('num');
    $("#urNom").text("Nom: " + utilisateurs[num].nom);
    $("#urPrenom").text("Prénom: " + utilisateurs[num].prenom);
    $("#urMail").text("Mail: " + utilisateurs[num].mail);
    $("#urMailValide").text("Mail Valide: " + utilisateurs[num].mailValide);
    $("#urDateInscription").text("Date d'inscription: " + utilisateurs[num].dateInscription);
    $("#urNbJobsRealises").text("Nb de jobs réalisés: " + utilisateurs[num].nbJobsRealises);
    $("#urNbEchecs").text("Nb d'échecs: " + utilisateurs[num].nbEchecs);
}

/**
 * Complète la popup de suppression d'un user avec les données correspondantes
 * un attribut 'num' de l'élément sélectionné permet d'identifier l'utilisateur
 */
function afficheUserDelete() {
    // je récupère l'id de l'élément cliqué !
    var num = this.getAttribute('num');
    $("#udNom").text("Nom: " + utilisateurs[num].nom);
    $("#udPrenom").text("Prénom: " + utilisateurs[num].prenom);
    $("#udMail").text("Mail: " + utilisateurs[num].mail);
    $("#udNum").text(num);
}

/**
 * Demande au serveur en Ajax de supprimer un utilisateur
 */
function userDelete() {
    var mail = $("#udMail").text();
    var num = $("#udNum").text();
    
    confirmation = true;
    $("#popupUserDelete").popup("close");
    $("#btnCmdClose").hide();
    $('#progressBar').show();
    $.ajax({
        url  : 'ajax_userDelete.jsp',
        type : 'POST',
        data : 'mail=' + mail,
        dataType : 'html',
        success: function(data) {
            $('#progressBar').hide();
            // on met le texte reçu dans la popup de confirmation
            $('#popupTextSendCmd').text(data);
            // on supprime la ligne du user supprimé
            if (data.indexOf("OK") != -1) {
                $("#u" + num).remove();
                // utilisateurs.splice(num, 1);
                // console.log(utilisateurs);
            }
            $("#btnCmdClose").show();
        },
        error : function(resultat, statut, erreur) {
            $('#progressBar').hide();
            $('#popupTextSendCmd').text(data);
            $("#btnCmdClose").show();
            return false;
        }
    });
}
/**
 * Complète la popup de détails d'un job avec les données correspondantes
 * un attribut 'num' de l'élément sélectionné permet d'identifier le job
 */
function afficheJobRead() {
    // je récupère l'id de l'élément cliqué !
    var num = this.getAttribute('num');
    $("#jrNom").text("Nom: " + jobs[num].nom);
    $("#jrDateRealisation").text("Date Réalisation: " + jobs[num].dateRealisation);
    $("#jrEtat").text("Etat: " + jobs[num].etat);
    $("#jrDureeConsommee").text("Durée Consommée: " + conversion(jobs[num].dureeConsommee));
    $("#jrResteAFaire").text("");
    if (jobs[num].etat == "EN_COURS")
        $("#jrResteAFaire").text("Reste A Faire: " + conversion(jobs[num].resteAFaire));
    $("#jrSupportConsomme").text("Support Consommé: " + jobs[num].supportConsomme + " cm3");
    $("#jrMatiereConsommee").text("Matière Consommée: " + jobs[num].matiereConsommee + " cm3");
    $("#jrSupportEstime").text("");
    $("#jrMatiereEstimee").text("");
    if (jobs[num].etat == "EN_COURS") {
        $("#jrSupportEstime").text("Support Estimé: " + jobs[num].supportEstime + " cm3");
        $("#jrMatiereEstimee").text("Matière Estimée: " + jobs[num].matiereEstimee + " cm3");
    }
    $("#jrPrix").text("Prix: " + jobs[num].prix/100.0 + "€");
}

/**
 * Conversion d'une valeur en seconde en String heure minute seconde
 * @param {type} ds
 * @returns {String}
 */
function conversion(ds) {
    return Math.floor(ds/3600)+ "h" + Math.floor((ds/60)%60) + "'"
                                    + Math.floor(ds%60) + "\"";
}

/**
 * Complète la popup de suppression d'un job avec les données correspondantes
 * un attribut 'num' de l'élément sélectionné permet d'identifier le job
 */
function afficheJobDelete() {
    // je récupère l'id de l'élément cliqué !
    var num = this.getAttribute('num');
    $("#jdNom").text("Nom: " + jobs[num].nom);
    $("#jdDateRealisation").text("Date Réalisation: " + jobs[num].dateRealisation);
    $("#jdEtat").text("Etat: " + jobs[num].etat);
    $("#jdNum").text(num);
}

/**
 * Demande au serveur en Ajax de supprimer un job
 */
function jobDelete() {
    var date = $("#jdDateRealisation").text();
    var num = $("#jdNum").text();
    
    confirmation = true;
    $("#popupJobDelete").popup("close");
    $("#btnCmdClose").hide();
    $.ajax({
        url  : 'ajax_jobDelete.jsp',
        type : 'POST',
        data : 'date=' + date,
        dataType : 'html',
        success: function(data) {
            $('#progressBar').hide();
            // on met le texte reçu dans la popup de confirmation
            $('#popupTextSendCmd').text(data);
            // on enlève la ligne du job supprimé
            if (data.indexOf("OK") != -1) {
                $("#j" + num).remove();
                // console.log(jobs);
            }
            $("#btnCmdClose").show();
        },
        error : function(resultat, statut, erreur) {
            $('#progressBar').hide();
            $('#popupTextSendCmd').text(data);
            $("#btnCmdClose").show();
            return false;
        }
    });
}

// Cette popup s'affiche en mode modal pour obliger l'utilisateur à attendre
// que la commande ajax de suppression dans la base de données soit terminée
function popupOpenCmd() {
    // Comme cette fonction erst appelé à chaque fermeture de la popup
    // de demande de confirmation, si on ne confirme pas
    // il ne faut pas ouvrir la popup 'popupSendCmd'
    if (confirmation)
        $('#popupSendCmd').popup('open');
    confirmation = false;
}

function popupCloseCmd() {
    $('#popupSendCmd').popup('close');
}
    