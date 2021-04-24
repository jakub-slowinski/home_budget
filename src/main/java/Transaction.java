import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.LocalDate;

class Transaction {

    enum Option {
        ADD_TRANSACTION(1, "Dodanie transakcji"),
        MODIFY_TRANSACTION(2, "Modyfikacja transakcji"),
        DELETE_TRANSACTION(3, "Usunięcie transakcji"),
        LIST_INCOMES(4, "Listowanie przychodów"),
        LIST_OUTCOMES(5, "Listowanie wydatków"),
        EXIT(0, "Wyjście z programu"),
        ;


        private Integer id;
        private String transactionType;
        private String description;
        private BigDecimal amount;
        private LocalDate dateStamp;

        Option(Integer id, String transactionType, String description, BigDecimal amount, LocalDate dateStamp) {
            this.id = id;
            this.transactionType = transactionType;
            this.description = description;
            this.amount = amount;
            this.dateStamp = dateStamp;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public LocalDate getDateStamp() {
            return dateStamp;
        }

        public void setDateStamp(LocalDate dateStamp) {
            this.dateStamp = dateStamp;
        }
    }
}
