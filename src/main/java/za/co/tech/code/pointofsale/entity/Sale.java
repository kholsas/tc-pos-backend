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
    @OneToMany
    private List<SaleItem> items;

    public Sale() {}
    public Sale(LocalDateTime dateTime, double total, List<SaleItem> items) {
        this.dateTime = dateTime;
        this.total = total;
        this.items = items;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public List<SaleItem> getItems() { return items; }
    public void setItems(List<SaleItem> items) { this.items = items; }
}