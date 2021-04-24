import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

class Transaction {

    private Integer id;
    private String transactionType;
    private String description;
    private BigDecimal amount;
    private LocalDate dateStamp;

    public Transaction(Integer id, String transactionType, String description, BigDecimal amount, LocalDate dateStamp) {
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

    public Date getDateStamp() {
        return Date.valueOf(dateStamp);
    }

    public void setDateStamp(LocalDate dateStamp) {
        this.dateStamp = dateStamp;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionType='" + transactionType + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", dateStamp=" + dateStamp +
                '}';
    }
}
