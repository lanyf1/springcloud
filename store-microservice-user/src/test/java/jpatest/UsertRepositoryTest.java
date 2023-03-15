package jpatest;

import com.microservice.store.product.UsertApplication;
import com.microservice.store.product.domain.User;
import com.microservice.store.product.mapper.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsertApplication.class)
public class UsertRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
//        //Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("test1","123456","123456@qq.com"));

        System.out.println(userRepository.findAll().size());
    }

}
