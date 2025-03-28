package sit.int204.sampleexception.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sit.int204.sampleexception.entities.Product;
import sit.int204.sampleexception.exceptions.ItemNotFoundException;
import sit.int204.sampleexception.repositories.ProductRepo;


import java.util.List;

//class 5
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    //- ดึงข้อมูลสินค้าทั้งหมดจากฐานข้อมูล โดยใช้การแบ่งหน้า (pagination) ด้วย PageRequest.of(page, size) เพื่อกำหนดจำนวนข้อมูลต่อหน้าและหน้าที่ต้องการ
    //- คืนค่าผลลัพธ์เป็น Page<Product> ซึ่งช่วยให้สามารถจัดการข้อมูลที่มีจำนวนมากได้ง่ายขึ้น
    public Page<Product> findAllProduct(int page, int size){
        return productRepo.findAll(PageRequest.of(page, size));
    }

    //- ดึงข้อมูลสินค้าทั้งหมดจากฐานข้อมูล (ไม่ใช้การแบ่งหน้า)
    //- คืนค่าผลลัพธ์เป็น List<Product>
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    //- ค้นหาสินค้าตามรหัสสินค้า (productCode)
    //- หากไม่พบสินค้าจะโยน exception ชื่อ ItemNotFoundException เพื่อแจ้งว่าไม่พบสินค้านั้นๆ
    public Product findProductById(String productCode) {
        return productRepo.findById(productCode).orElseThrow(
                () -> new ItemNotFoundException("Product id "
                + productCode + " does not exist !!!")
        );
    }

    //- เพิ่มสินค้าลงในฐานข้อมูล
    //- ใช้ productRepo.save(product) เพื่อบันทึกข้อมูลสินค้าใหม่
    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    //- อัปเดตข้อมูลสินค้าบนฐานข้อมูล
    //- ใช้ productRepo.save(product) เพื่ออัปเดตข้อมูลสินค้า
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    //- ลบสินค้าจากฐานข้อมูลตามรหัสสินค้า (productCode)
    public void deleteProduct(String productCode) {
        productRepo.deleteById(productCode);
    }
}
