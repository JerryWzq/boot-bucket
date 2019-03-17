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

}
