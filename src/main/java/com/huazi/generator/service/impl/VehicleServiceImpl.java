package com.huazi.generator.service.impl;

import com.huazi.generator.entity.Vehicle;
import com.huazi.generator.mappers.VehicleMapper;
import com.huazi.generator.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleMapper vehicleMapper;
    @Override
    public List<Vehicle> get(Vehicle vehicle) {
        return vehicleMapper.get(vehicle);
    }
}
