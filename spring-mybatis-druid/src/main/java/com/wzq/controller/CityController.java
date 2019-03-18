package com.wzq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.model.City;
import com.wzq.service.CityService;
import com.wzq.vo.BaseVo;
import com.wzq.vo.CityVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public Object getData(@ModelAttribute BaseVo baseVo){
        logger.info("参数信息：{}", baseVo);
        PageHelper.startPage(baseVo.getCurrentPage(), baseVo.getPageSize());
        List<City> cities = cityService.selectAll();
        return new PageInfo<>(cities);
    }

    @PostMapping("/add")
    public Object add(@RequestBody CityVo cityVo){
        logger.info("添加城市：{}", cityVo);
        City city = new City();
        city.setCityName(cityVo.getCityName());
        city.setCitySize(cityVo.getCitySize());
        city.setPId(cityVo.getPId());
        return cityService.add(city);
    }


}
