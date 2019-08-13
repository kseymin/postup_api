package com.mins.postup;

import com.mins.postup.entity.User;
import com.mins.postup.repogitory.UserRepogitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostupApplicationTests {

    @Autowired
    UserRepogitory userRepogitory;
    @Test
    public void contextLoads() {
        User user1 = User.builder().id("kang99").pwd("1234").name("sungmin").email("kseymin@gmail.com").build();
        userRepogitory.save(user1);

        List<User> ulist = userRepogitory.findAll();
        System.out.println(ulist);
    }

}
