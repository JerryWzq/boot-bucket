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
        size = citySize.name();
        System.err.println("City's init method........");
    }
}
