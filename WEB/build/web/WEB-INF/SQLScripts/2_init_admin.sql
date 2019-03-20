# -----------------------------------------------------------------------
#    crée les autorisation du user local pour l'accés du serveur à la BD
# -----------------------------------------------------------------------

use imp3d;

drop user imp3d@localhost;
create user imp3d@localhost identified by 'imp3d31';

grant  select,insert,update,delete on imp3d.* to imp3d@localhost identified by 'imp3d31';
