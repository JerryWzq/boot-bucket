package com.wzq.factory;

import com.wzq.model.City;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class CityObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {
        T ret = super.create(type);
        if(City.class.isAssignableFrom(type)){
            City entity = (City)ret;
            entity.init();
        }
        return ret;
    }

    /**
     * 如果该类是City，则在执行构造方法之后执行init方法
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T ret = super.create(type,constructorArgTypes,constructorArgs);
        if(City.class.isAssignableFrom(type)){
            City entity = (City)ret;
            entity.init();
        }
        return ret;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
