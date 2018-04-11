package com.huazi.generator.controller;

import com.huazi.generator.entity.Vehicle;
import com.huazi.generator.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicle")
public class VehilceController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/get")
    @ResponseBody
    public Map<String,Object> get(@RequestBody Vehicle vehicle){
        List<Vehicle> list=vehicleService.get(vehicle);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return map;
    }
}
