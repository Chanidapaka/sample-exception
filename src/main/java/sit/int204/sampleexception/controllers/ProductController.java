package sit.int204.sampleexception.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import sit.int204.sampleexception.dtos.PageDto;
import sit.int204.sampleexception.dtos.ProductDtoA;
import sit.int204.sampleexception.dtos.SampleData;
import sit.int204.sampleexception.entities.Product;
import sit.int204.sampleexception.exceptions.ItemNotFoundException;
import sit.int204.sampleexception.exceptions.MyErrorResponse;
import sit.int204.sampleexception.services.ProductService;
import sit.int204.sampleexception.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoA> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(modelMapper.map(productService.findProductById(id), ProductDtoA.class));
    }

    @GetMapping("")
    public ResponseEntity<PageDto<ProductDtoA>> getAllProducts(
            @RequestParam Integer pageNo, @RequestParam Integer pageSize
    ) {
        Page<Product> productPage = productService.findAllProduct(pageNo, pageSize);
        return ResponseEntity.ok(listMapper.toPageDTO(productPage, ProductDtoA.class, modelMapper));
    }
    //ทดลองใช้
    @PostMapping("/validations")
    public ResponseEntity<Object> testValidation (
            @Valid @RequestBody SampleData sampleData) {
        return ResponseEntity.ok(sampleData);
    }

}
