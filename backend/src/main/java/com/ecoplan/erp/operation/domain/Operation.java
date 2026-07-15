package com.ecoplan.erp.operation.domain;

import com.ecoplan.erp.common.entity.BaseEntity;
import com.ecoplan.erp.vehicle.domain.Vehicle;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "operation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Operation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate operationDate;

    @Column(nullable = false, length = 100)
    private String driverName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(nullable = false, length = 200)
    private String departure;

    @Column(nullable = false, length = 200)
    private String destination;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private Integer departureKm;

    @Column(nullable = false)
    private Integer arrivalKm;

    @Column(nullable = false)
    private Integer distanceKm;

    public Operation(
            LocalDate operationDate,
            String driverName,
            Vehicle vehicle,
            String departure,
            String destination,
            LocalDateTime departureTime,
            LocalDateTime arrivalTime,
            Integer departureKm,
            Integer arrivalKm
    ) {
        this.operationDate = operationDate;
        this.driverName = driverName;
        this.vehicle = vehicle;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureKm = departureKm;
        this.arrivalKm = arrivalKm;
        this.distanceKm = arrivalKm - departureKm;
    }

    public void update(
            LocalDate operationDate,
            String driverName,
            Vehicle vehicle,
            String departure,
            String destination,
            LocalDateTime departureTime,
            LocalDateTime arrivalTime,
            Integer departureKm,
            Integer arrivalKm
    ) {

        this.operationDate = operationDate;
        this.driverName = driverName;
        this.vehicle = vehicle;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureKm = departureKm;
        this.arrivalKm = arrivalKm;
        this.distanceKm = arrivalKm - departureKm;
    }
}