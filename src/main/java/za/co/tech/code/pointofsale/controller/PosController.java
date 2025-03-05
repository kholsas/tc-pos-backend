package za.co.tech.code.pointofsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import za.co.tech.code.pointofsale.entity.Product;
import za.co.tech.code.pointofsale.entity.Sale;
import za.co.tech.code.pointofsale.entity.SaleItem;
import za.co.tech.code.pointofsale.repository.ProductRepository;
import za.co.tech.code.pointofsale.repository.SaleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PosController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Value("${till.number:TILL001}")
    private String tillNumber;

    @GetMapping("/products/{barcode}")
    public Product getProduct(@PathVariable String barcode) {
        return productRepository.findById(barcode).orElse(null);
    }

    @PostMapping("/sales")
    public Sale createSale(@RequestBody List<SaleItem> items, @RequestHeader("User-Id") String userId) {
        double total = items.stream().mapToDouble(SaleItem::getSubtotal).sum();
        for (SaleItem item : items) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }
        // Generate unique transaction number
        String transactionNumber = "T" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        String tillNumber = this.tillNumber;
        Sale sale = new Sale(LocalDateTime.now(), total, items, transactionNumber, tillNumber, userId);
        return saleRepository.save(sale);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam("name") String name) {
        List<Product> results = productRepository.findByNameContainingIgnoreCase(name);
        if (results.isEmpty()) {
            return List.of(); // Return empty list instead of null or empty string
        }
        return results;
    }
}