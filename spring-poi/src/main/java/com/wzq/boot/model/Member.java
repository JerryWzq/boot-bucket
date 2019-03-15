package com.wzq.boot.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * 类描述:
 * member实体类
 *
 * @author
 * @version 1.0.0
 * @date 2018-11-29 13:52
 */
@ExcelTarget("member")
@Data
public class Member {
    @Excel(name = "主键id", width = 15)
    private int id;
    @Excel(name = "姓名", width = 30)
    private String name;

}