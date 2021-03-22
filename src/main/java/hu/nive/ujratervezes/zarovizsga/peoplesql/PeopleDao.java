package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private MariaDbDataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select ip_address from people where first_name = ? and last_name = ?;")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return getResult(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }
    }

    private String getResult(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return "No such IP address in database.";
    }
}
