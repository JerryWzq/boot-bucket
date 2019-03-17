package com.wzq.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Province")
public class Province {
    private Integer id;
    private String provinceCode;
    private String provinceName;
}
