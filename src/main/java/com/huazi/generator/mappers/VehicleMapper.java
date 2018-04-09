package com.huazi.generator.mappers;

import com.huazi.generator.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VehicleMapper {
    public List get(Vehicle vehicle);
}
