package mg.jerryharim.activitytracker.repository.dao;

import java.sql.ResultSet;

public class MotCleDAO extends DAO<String> {

    @Override
    public String buildResult(ResultSet resultSet) throws SQLException {
        return resultSet.getString("nom");
    }

	public boolean ajouter(String motCle) {
		return false;
	}

    public int recupererIdentifiant(String motCle) {
        return -1;
    }

}

