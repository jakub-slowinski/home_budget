import java.util.Scanner;

public class HomeBudget {

    private static final TransactionDao DAO = new TransactionDao();
    public static void main(String[] args) {

        TransactionDao transactionDao = new TransactionDao();

        Scanner scanner = new Scanner(System.in);
        Transaction.Option option = null;
        while(true) {
            System.out.println("Możliwe do wykonania operacje:");
            System.out.println("1. Dodaj transakcję");
            System.out.println("2. Modyfikuj transakcję");
            System.out.println("3. Usuń transakcję");
            System.out.println("4. Wyświetl przychody");
            System.out.println("5. Wyświetl wydatki");
            System.out.println("0. Zakończ działanie aplikacji");

            String operation = scanner.nextLine();

            switch (option) {
                case ADD_TRANSACTION:
                    transactionDao.addTransaction();
                    break;
                case MODIFY_TRANSACTION:
                    transactionDao.modifyTransaction();
                    break;
                case DELETE_TRANSACTION:
                    transactionDao.deleteTransaction();
                    break;
                case LIST_INCOMES:
                    transactionDao.incomes();
                    break;
                case LIST_OUTCOMES:
                    transactionDao.outcomes();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Nie ma takiej operacji");
            }
        }


        DAO.closeConnection();  //zamyka polaczenie przy zamykaniu aplikacji
    }

}
