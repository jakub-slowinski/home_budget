import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
            preparedStatement.setDate(4, Date.valueOf(transaction.getDateStamp()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Brak zapisu do bazy: " + e.getMessage());
        }
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
            preparedStatement.setDate(4, Date.valueOf(transaction.getDateStamp()));
            preparedStatement.setInt(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Brak zapisu do bazy: " + e.getMessage());
        }
    }

    public void deleteTransaction(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transactions WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Brak zapisu do bazy: " + e.getMessage());
        }
    }

    ResultSet resultSet;

    public List<Transaction> outcomes = new ArrayList<>() {
        while(resultSet.next())
        {
            Transaction outcome = new Transaction(resultSet);
            outcomes.add(outcome);
        }
    }


    public List<Transaction> incomes = new ArrayList<>() {
        while(resultSet.next())
        {
            Transaction income = new Transaction(resultSet);
            incomes.add(income);
        }
    }


    public void closeConnection() {
        try {
            System.out.println("Zamykam połączenie");
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException("Błąd zamknięcia połączenia", e);
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
