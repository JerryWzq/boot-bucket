package com.wzq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.model.Province;
import com.wzq.service.ProvinceService;
import com.wzq.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/list")
    public Object getData(@ModelAttribute BaseVo baseVo){
        PageHelper.startPage(baseVo.getCurrentPage(), baseVo.getPageSize());
        List<Province> provinces = provinceService.selectAll();
        return new PageInfo<>(provinces);
    }
}
