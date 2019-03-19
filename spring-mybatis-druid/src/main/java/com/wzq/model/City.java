package com.wzq.model;

import com.wzq.constant.CitySize;
import lombok.Data;

@Data
public class City {

    private Integer id;
    private String cityName;
    private Integer pId;
    private String size;
    private CitySize citySize;

    public City() {
        System.err.println("City's constructor>>>>>>>");
    }

    public City(Integer id, String cityName, Integer pId, String size, CitySize citySize) {
        System.err.println("City's constructor。。。。。");
        this.id = id;
        this.cityName = cityName;
        this.pId = pId;
        this.size = size;
        this.citySize = citySize;
    }

    public City(Integer id, String cityName, Integer pId, CitySize citySize) {
        this.id = id;
        this.cityName = cityName;
        this.pId = pId;
        this.citySize = citySize;
    }

    public void init(){
        //有参构造生成对象时可用，否则citySize会报空指针
//        size = citySize.name();
        this.citySize = CitySize.LARGE;
        System.err.println("City's init method........");
    }
}
