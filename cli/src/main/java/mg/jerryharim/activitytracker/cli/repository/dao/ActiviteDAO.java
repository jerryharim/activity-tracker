package mg.jerryharim.activitytracker.cli.repository.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mg.jerryharim.activitytracker.core.entity.Activite;

public class ActiviteDAO extends DAO<Activite> {

    public ActiviteDAO(Connection connection) {
        super.connection = connection;
    }

    @Override
    public Activite buildResult(ResultSet resultSet) throws SQLException {
        List<String> motcles = new ArrayList<>();
        Activite activite = new Activite(
            resultSet.getDate("dateDebut").toLocalDate(), 
            resultSet.getDate("dateFin").toLocalDate(), 
            resultSet.getTime("heureDebut").toLocalTime(), 
            resultSet.getTime("heureFin").toLocalTime(),
            resultSet.getString("nom"), 
            motcles
        );
        activite.setDetail(resultSet.getString("detail")); 

        return activite;
    }

    public List<Activite> recupererTout() {
        return super.getResults("SELECT * FROM activite");
    }

    /**
     * Retourne le nombre de ligne affecte par l'ajout
     * @param activite
     * @return int
     */
    public int ajouter(Activite activite) {

        int rowAffected = super.executeUpdate(String.format(
            "INSERT INTO activite(nom, detail, dateDebut, dateFin, heureDebut, heureFin)" +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", 
            activite.getNom(), 
            activite.getDetail(), 
            activite.getDateDebut(),
            activite.getDateFin(),
            activite.getHeureDebut(),
            activite.getHeureFin()
        ));

        return rowAffected;
    }
    
}
