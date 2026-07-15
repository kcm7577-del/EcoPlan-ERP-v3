package com.ecoplan.erp.vehicle.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "vehicle_number", nullable = false, unique = true, length = 20)
    private String vehicleNumber;

    @NotBlank
    @Column(name = "vehicle_model", nullable = false, length = 100)
    private String vehicleModel;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false, length = 20)
    private FuelType fuelType;

    @NotNull
    @DecimalMin("0.1")
    @Column(name = "average_fuel_efficiency", nullable = false)
    private Double averageFuelEfficiency;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_status", nullable = false, length = 30)
    private VehicleStatus vehicleStatus;

    @Column(name = "remark", length = 500)
    private String remark;

    public Vehicle(
            String vehicleNumber,
            String vehicleModel,
            FuelType fuelType,
            Double averageFuelEfficiency,
            VehicleStatus vehicleStatus,
            String remark
    ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.averageFuelEfficiency = averageFuelEfficiency;
        this.vehicleStatus = vehicleStatus;
        this.remark = remark;
    }

    public void update(
            String vehicleNumber,
            String vehicleModel,
            FuelType fuelType,
            Double averageFuelEfficiency,
            VehicleStatus vehicleStatus,
            String remark
    ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.averageFuelEfficiency = averageFuelEfficiency;
        this.vehicleStatus = vehicleStatus;
        this.remark = remark;
    }
}