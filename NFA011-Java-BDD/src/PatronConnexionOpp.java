import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// ici fermeture des flux dans l'ordre et récupération de l'objet inséré en BDD avec son ID
/*
 * notes : toujours utiliser des Wrappers (types Object) 
 * pour le type des attributs qui vont être insérés en BDD(les types primitifs n'acceptent pas le valeur null) 
 */
public class PatronConnexionOpp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		List<String> messages = new ArrayList<String>();
		
		try {
			connexion = MaConnexion.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("select * from Produit");
		    /* 
		     * Ouverture de la connexion, initialisation d'un Statement, initialisation d'un ResultSet, etc.
		     */
			/* Exécution d'une requête d'écriture avec renvoi de l'id auto-généré */
			int statut = statement.executeUpdate( "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES ('jmarc2@mail.fr', MD5('lavieestbelle78'), 'jean-marc', NOW());" , Statement.RETURN_GENERATED_KEYS);

			/* Formatage pour affichage dans la JSP finale. */
			messages.add( "Résultat de la requête d'insertion : " + statut + "." );

			/* Récupération de l'id auto-généré par la requête d'insertion. */
			resultat = statement.getGeneratedKeys();
			/* Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
			while ( resultat.next() ) {
			    messages.add( "ID retourné lors de la requête d'insertion :" + resultat.getInt( 1 ) );
			}
		} catch ( SQLException e ) {
		    /* Traiter les erreurs éventuelles ici. */
		} finally {
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		            /* Et enfin on ferme la connexion */
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		}
	}

}
