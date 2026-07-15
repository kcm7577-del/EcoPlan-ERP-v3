package com.ecoplan.erp.vehicle.dto;

import com.ecoplan.erp.vehicle.domain.FuelType;
import com.ecoplan.erp.vehicle.domain.Vehicle;
import com.ecoplan.erp.vehicle.domain.VehicleStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VehicleResponse {

    private Long id;

    private String vehicleNumber;

    private String vehicleModel;

    private FuelType fuelType;

    private Double averageFuelEfficiency;

    private VehicleStatus vehicleStatus;

    private String remark;

    public static VehicleResponse from(Vehicle vehicle) {

        return VehicleResponse.builder()
                .id(vehicle.getId())
                .vehicleNumber(vehicle.getVehicleNumber())
                .vehicleModel(vehicle.getVehicleModel())
                .fuelType(vehicle.getFuelType())
                .averageFuelEfficiency(vehicle.getAverageFuelEfficiency())
                .vehicleStatus(vehicle.getVehicleStatus())
                .remark(vehicle.getRemark())
                .build();
    }
}