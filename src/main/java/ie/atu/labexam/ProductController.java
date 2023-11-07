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

    @Autowired
    public ProductController(WarehouseServiceClient warehouseServiceClient){
        this.warehouseServiceClient = warehouseServiceClient;
    }

    @PostMapping("/add-product")
    public Map<String, String> addProduct(@RequestBody ProductService productService){
        String capacityCheck = warehouseServiceClient.productDetails(productService);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("Product Added", capacityCheck);
        return responseMessage;
    }

}
