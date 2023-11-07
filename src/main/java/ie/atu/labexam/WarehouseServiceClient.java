package ie.atu.labexam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "warehouse-service", url="http://localhost:8082")
public interface WarehouseServiceClient {
    @PostMapping("/capacity-check")
    String productDetails(@RequestBody ProductService productService);
}
