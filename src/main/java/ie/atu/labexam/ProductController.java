package ie.atu.labexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
    private WarehouseServiceClient warehouseServiceClient;
    private final ProductService productService;

    @Autowired
    public ProductController(WarehouseServiceClient warehouseServiceClient){
        this.warehouseServiceClient = warehouseServiceClient;
    }

    @Autowired
    public ProductController(ProductService ps){
        this.productService = ps;
    }

    @PostMapping("/add-product")
    public Map<String, String> addProduct(@RequestBody Product product){
        String capacityCheck = warehouseServiceClient.productDetails(product);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("Product Added", capacityCheck);
        return responseMessage;
    }

    @PostMapping("/addProduct")
    public String getProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping("/getProduct")
    public ArrayList<Product> getProduct(){
        return productService.getProduct();
    }

}
