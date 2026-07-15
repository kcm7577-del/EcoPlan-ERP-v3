package com.ecoplan.erp.vehicle.service;

import com.ecoplan.erp.common.exception.BusinessException;
import com.ecoplan.erp.common.exception.ErrorCode;
import com.ecoplan.erp.vehicle.domain.Vehicle;
import com.ecoplan.erp.vehicle.dto.VehicleCreateRequest;
import com.ecoplan.erp.vehicle.dto.VehicleResponse;
import com.ecoplan.erp.vehicle.dto.VehicleUpdateRequest;
import com.ecoplan.erp.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Long create(VehicleCreateRequest request) {

        if (vehicleRepository.existsByVehicleNumber(request.getVehicleNumber())) {
            throw new BusinessException(ErrorCode.DUPLICATE_VEHICLE_NUMBER);
        }

        Vehicle vehicle = new Vehicle(
                request.getVehicleNumber(),
                request.getVehicleModel(),
                request.getFuelType(),
                request.getAverageFuelEfficiency(),
                request.getVehicleStatus(),
                request.getRemark()
        );

        return vehicleRepository.save(vehicle).getId();
    }

    @Transactional(readOnly = true)
    public List<VehicleResponse> findAll() {

        return vehicleRepository.findAll()
                .stream()
                .map(VehicleResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public VehicleResponse findById(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.VEHICLE_NOT_FOUND));

        return VehicleResponse.from(vehicle);
    }

    public void update(Long id, VehicleUpdateRequest request) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.VEHICLE_NOT_FOUND));

        vehicle.update(
                request.getVehicleNumber(),
                request.getVehicleModel(),
                request.getFuelType(),
                request.getAverageFuelEfficiency(),
                request.getVehicleStatus(),
                request.getRemark()
        );
    }

    public void delete(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.VEHICLE_NOT_FOUND));

        vehicleRepository.delete(vehicle);
    }
}