package ua.itif.lms.dao.repository;

import ua.itif.lms.dao.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    public User getUserByEmailByPassword(String email, String password) {
        DataSourse dataSourse = new DataSourse();
        String query = "SELECT id, name, email, password" + " FROM user " +
                " WHERE user.email=" + email + " AND password=" + password;
        try (Connection connection = dataSourse.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);)
        {
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                );
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
