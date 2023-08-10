package shoppy.hexagramme.com.shoppy;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private static final String defaultDescription = "No description currenlty available for this item.";
    private final AtomicLong counter = new AtomicLong();
    private static final String defaultPrice = "9.99";
    private static final String defaultName = "Dummy Item";
    
    @PostMapping("/add")
    public Product newProduct(
        @RequestParam(value = "name", defaultValue = defaultName ) String name,
        @RequestParam(value = "price", defaultValue = defaultPrice ) double price,
        @RequestParam(value = "description", defaultValue = defaultDescription ) String description
        ) {
            return new Product(counter.incrementAndGet(), name, price, description);
            //TODO: check if product name is in use/valid before creation
            //TODO: data validation on entries
            //TODO: append to list of all products
        }
    @GetMapping("/view")
    public ProductList viewAllProducts() {
        //TODO: return actual ProductList, saved in mongo db connection
        return new ProductList();
    }
}

