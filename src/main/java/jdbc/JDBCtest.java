package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCtest {
    public void initConnection() {
        try {
            CustomDataSource dataSource = CustomDataSource.getInstance();
            Connection connection = dataSource.getConnection();
            System.out.println("Connection successful: " + (connection != null));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCtest jdbctest = new JDBCtest();
        jdbctest.initConnection();

        User user = new User(1L, "user", "usersurname", 2);
        SimpleJDBCRepository repo = new SimpleJDBCRepository();

        repo.deleteUser(1L);
        user.setAge(10);
        repo.createUser(user);

        repo.updateUser(user);

        List<User> allUser = repo.findAllUser();
        for (User user1 : allUser) {
            System.out.println(user1.toString());
        }

    }
}