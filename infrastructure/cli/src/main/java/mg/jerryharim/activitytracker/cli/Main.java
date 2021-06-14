package mg.jerryharim.activitytracker.cli;

import java.sql.Connection;

import mg.jerryharim.activitytracker.cli.repository.RepositoryActivite;
import mg.jerryharim.activitytracker.cli.repository.dao.DAOFactory;
import mg.jerryharim.activitytracker.cli.repository.dao.DatabaseManager;
import mg.jerryharim.activitytracker.core.usecase.EnregistrementActivite;
import mg.jerryharim.activitytracker.core.usecase.ListeActivite;
import picocli.CommandLine;

public class Main {
    
    public static void main(String[] args) {

        // spi
        Connection connection = DatabaseManager.getInstance().getConnection();
        DAOFactory daoFactory = new DAOFactory(connection);
        daoFactory.initialiseDatabase();
        RepositoryActivite registreActivite = new RepositoryActivite(daoFactory.getActiviteDAO());

        // domain
        EnregistrementActivite enregistrementActivite = new EnregistrementActivite(registreActivite);
        ListeActivite listeActivite = new ListeActivite(registreActivite);

        // api
        int statusCode = new CommandLine(
            new CommandeAjoutActivite(enregistrementActivite, listeActivite)
        ).execute(args);
        System.exit(statusCode);
    }
    
}
