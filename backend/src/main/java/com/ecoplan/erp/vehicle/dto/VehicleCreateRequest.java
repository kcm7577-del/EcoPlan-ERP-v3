package com.ecoplan.erp.vehicle.dto;

import com.ecoplan.erp.vehicle.domain.FuelType;
import com.ecoplan.erp.vehicle.domain.VehicleStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VehicleCreateRequest {

    @NotBlank
    private String vehicleNumber;

    @NotBlank
    private String vehicleModel;

    @NotNull
    private FuelType fuelType;

    @NotNull
    @DecimalMin("0.1")
    private Double averageFuelEfficiency;

    @NotNull
    private VehicleStatus vehicleStatus;

    private String remark;

}