package mg.jerryharim.activitytracker.cli.repository.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mg.jerryharim.activitytracker.cli.repository.RepositoryActivite;


public class DAOFactory {

    private Connection connection;
    private ActiviteDAO activiteDAO;
    private MotCleDAO motCleDAO;


    public DAOFactory(Connection connection) {
        this.connection = connection;
    }


	public ActiviteDAO getActiviteDAO() {
        if (this.activiteDAO == null)
            this.activiteDAO = new ActiviteDAO(this.connection);
        return this.activiteDAO;
	}

	public MotCleDAO getMotCleDAO() {
        if (this.motCleDAO == null)
            this.motCleDAO = new MotCleDAO(this.connection);
        return this.motCleDAO;
	}

    /**
     * Initialise le contenue de la base.
     * Utiliser pour h2. 
     * Utiliser IF EXIST lors de la phase de prod
     */
	public void initialiseDatabase() {

        String dropTables = "drop table if exists motcleactivite, motcle, activite";

        String sqlActivite = "CREATE TABLE activite(" + 
            "id int not null auto_increment primary key, " +
            "nom varchar(200), " +
            "dateDebut date, " +
            "dateFin date, " +
            "heureDebut time, " +
            "heureFin time, " +
            "detail varchar(250))";

        String sqlMotCle = "CREATE TABLE motCle(" +
            "id int not null auto_increment primary key, " +
            "nom varchar(200))";

        String sqlMotCleActivite = "CREATE TABLE motCleActivite(" +
            "idActivite int not null, " +
            "idMotCLe int not null)";

        String sqlMotCleActiviteFk1 = "ALTER TABLE motCleActivite " + 
            "add foreign key (idActivite) references activite(id)";

        String sqlMotCleActiviteFk2 = "ALTER TABLE motCleActivite " + 
            "add foreign key (idMotCle) references motCle(id)";
            
		try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(dropTables);
            statement.executeUpdate(sqlActivite);
            statement.executeUpdate(sqlMotCle);
            statement.executeUpdate(sqlMotCleActivite);
            statement.executeUpdate(sqlMotCleActiviteFk1);
            statement.executeUpdate(sqlMotCleActiviteFk2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
