package mg.jerryharim.activitytracker.cli.repository.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MotCleDAO extends DAO<String> {

    @Override
    public String buildResult(ResultSet resultSet) {
        try {
            return resultSet.getString("nom");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

	public boolean ajouter(String motCle) {
		return false;
	}

    public int recupererIdentifiant(String motCle) {
        return -1;
    }

}

