import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

class TransactionDao {

    public void addTransaction(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transactions(type, description, amount, dateStamp) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getTransactionType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setDate(4, transaction.getDateStamp());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Brak zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public void modifyTransaction(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transactions SET transactionType = ?, description = ?, amount = ?, dateStamp = ?) WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getTransactionType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setDate(4, transaction.getDateStamp());
            preparedStatement.setInt(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Brak zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public List<Transaction> outcomes() {
        return;
    }//wspominales zeby robic to listami, ale dalej brakuje mi konceptu



    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/home_budget?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
