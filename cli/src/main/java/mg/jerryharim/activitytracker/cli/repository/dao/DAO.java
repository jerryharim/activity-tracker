package mg.jerryharim.activitytracker.cli.repository.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {

    protected Connection connection;

	public T getResult(String query) {
        List<T> all = getResults(query);
        return all.isEmpty() ? null : all.get(0);
	}

    /**
     * Get all result of this query
     * @param query
     * @return List<T>
     */
    public List<T> getResults(String query) {
        List<T> all = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            while (queryResult.next()) {
                all.add(buildResult(queryResult));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;
    }

    public abstract T buildResult(ResultSet resultSet) throws SQLException;

	public int executeUpdate(String query) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
	}

}
