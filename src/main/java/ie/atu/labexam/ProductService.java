package ie.atu.labexam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> warehouse = new ArrayList<Product>();
    public String addProduct(Product product) {
        String message = "You added the product: " + product.getProductName();
        warehouse.add(product);
        return message;
    }
    public ArrayList<Product> getProduct(){
        return warehouse;
    }

}
