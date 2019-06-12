# ---------------------------------------------------------------------------- 
# Document   : 2_init_admin.sql
# Description: création des autorisations du user local pour l'accés du serveur à la BD
# Author:      Vraux 
# Created:     18Févr. 2019
# Modifiée:    15 Mai 2019
# ----------------------------------------------------------------------------    

SET GLOBAL sql_mode = '';
use imp3d;

drop user imp3d@localhost;
create user imp3d@localhost identified by 'imp3d31';

grant  select,insert,update,delete on imp3d.* to imp3d@localhost identified by 'imp3d31';
