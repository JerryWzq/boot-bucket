package com.wzq.boot.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * 类描述:
 *
 * @author
 * @date 2019-03-08 17:51
 */
@ExcelTarget("member")
@Data
public class MemberDTO {

    @Excel(name = "主键id", width = 15)
    private Integer id;

    @Excel(name = "姓名", width = 30)
    private String name;

}