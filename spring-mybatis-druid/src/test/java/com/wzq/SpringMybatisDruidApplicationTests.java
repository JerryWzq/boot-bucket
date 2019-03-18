package com.wzq;

import com.wzq.constant.CitySize;
import com.wzq.factory.CityObjectFactory;
import com.wzq.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisDruidApplicationTests {

    @Test
    public void contextLoads() {

        CityObjectFactory cityObjectFactory = new CityObjectFactory();

        List constructorArgTypes = new ArrayList();
        constructorArgTypes.add(Integer.class);
        constructorArgTypes.add(String.class);
        constructorArgTypes.add(Integer.class);
//        constructorArgTypes.add(String.class);
        constructorArgTypes.add(CitySize.class);

        List constructorArgs = new ArrayList();
        constructorArgs.add(15);
        constructorArgs.add("测试ObjectFactory");
        constructorArgs.add(1);
//        constructorArgs.add("LARGE");
        constructorArgs.add(CitySize.LARGE);

        City city = cityObjectFactory.create(City.class, constructorArgTypes, constructorArgs);
        System.err.println(city.toString());
    }

}
