package jpatest;

import com.microservice.store.product.ProductApplication;
import com.microservice.store.product.domain.Product;
import com.microservice.store.product.mapper.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class ProductRepositoryTest {

    @Resource
    private ProductRepository productRepository;

    @Test
    public void test() throws Exception {
//        //Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);

        productRepository.save(new Product("iphone14","iphone14256g4cores"));

        System.out.println(productRepository.findAll().size());
    }

}
