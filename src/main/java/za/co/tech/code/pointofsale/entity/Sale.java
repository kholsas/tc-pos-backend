package za.co.tech.code.pointofsale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    private double total;
    private String transactionNumber; // Unique transaction number
    private String tillNumber;       // Till identifier
    private String userId;           // User who made the sale

    @OneToMany
    private List<SaleItem> items;

    public Sale() {}

    public Sale(LocalDateTime dateTime, double total, List<SaleItem> items, String transactionNumber, String tillNumber, String userId) {
        this.dateTime = dateTime;
        this.total = total;
        this.items = items;
        this.transactionNumber = transactionNumber;
        this.tillNumber = tillNumber;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public List<SaleItem> getItems() { return items; }
    public void setItems(List<SaleItem> items) { this.items = items; }
    public String getTransactionNumber() { return transactionNumber; }
    public void setTransactionNumber(String transactionNumber) { this.transactionNumber = transactionNumber; }
    public String getTillNumber() { return tillNumber; }
    public void setTillNumber(String tillNumber) { this.tillNumber = tillNumber; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}