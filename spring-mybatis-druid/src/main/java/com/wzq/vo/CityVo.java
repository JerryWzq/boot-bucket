package com.wzq.vo;

import com.wzq.constant.CitySize;
import lombok.Data;

@Data
public class CityVo {
    private String cityName;
    private Integer pId;
    private CitySize citySize;
}
