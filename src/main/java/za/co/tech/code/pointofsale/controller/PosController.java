package za.co.tech.code.pointofsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.tech.code.pointofsale.entity.Product;
import za.co.tech.code.pointofsale.entity.Sale;
import za.co.tech.code.pointofsale.entity.SaleItem;
import za.co.tech.code.pointofsale.repository.ProductRepository;
import za.co.tech.code.pointofsale.repository.SaleRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PosController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/products/{barcode}")
    public Product getProduct(@PathVariable String barcode) {
        return productRepository.findById(barcode).orElse(null);
    }

    @PostMapping("/sales")
    public Sale createSale(@RequestBody List<SaleItem> items) {
        double total = items.stream().mapToDouble(SaleItem::getSubtotal).sum();
        for (SaleItem item : items) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }
        Sale sale = new Sale(LocalDateTime.now(), total, items);
        return saleRepository.save(sale);
    }
}