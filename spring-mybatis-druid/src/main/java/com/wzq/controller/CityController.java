package com.wzq.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.model.City;
import com.wzq.service.CityService;
import com.wzq.vo.BaseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping("/select")
    public Object getData(@ModelAttribute BaseVo baseVo){
        logger.info("参数信息：{}", baseVo);
        PageHelper.startPage(baseVo.getCurrentPage(), baseVo.getPageSize());
        List<City> cities = cityService.selectAll();
        return new PageInfo<>(cities);
    }


}
