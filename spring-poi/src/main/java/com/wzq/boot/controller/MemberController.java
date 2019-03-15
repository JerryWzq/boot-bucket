package com.wzq.boot.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.boot.dto.MemberDTO;
import com.wzq.boot.model.Member;
import com.wzq.boot.service.MemberService;
import com.wzq.boot.vo.MemberVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类描述:
 * member成员的控制层
 *
 * @author
 * @version 1.0.0
 * @date 2018-11-29 11:37
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("/getMember")
    public Member getMemberById(){
        return service.getMemberById(1);
    }

    @GetMapping("/list")
    public PageInfo getList(@ModelAttribute MemberVo memberVo){
        PageHelper.startPage(memberVo.getCurrentPage(), memberVo.getPageSize());
        List<Member> members = service.selectList();
        return new PageInfo(members);
    }

    @RequestMapping("/export")
    public String export(HttpServletResponse response) throws UnsupportedEncodingException {
        List<Member> members = service.selectList();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                Member.class, members);
        // 判断数据
        if(workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        String excelName = "测试excel" ;
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(dateStr + ".xls", "utf-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}