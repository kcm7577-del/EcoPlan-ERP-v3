package com.ecoplan.erp.vehicle.controller;

import com.ecoplan.erp.common.response.ApiResponse;
import com.ecoplan.erp.vehicle.dto.VehicleCreateRequest;
import com.ecoplan.erp.vehicle.dto.VehicleResponse;
import com.ecoplan.erp.vehicle.dto.VehicleUpdateRequest;
import com.ecoplan.erp.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> create(
            @Valid @RequestBody VehicleCreateRequest request
    ) {

        Long id = vehicleService.create(request);

        return ApiResponse.success(id);
    }

    @GetMapping
    public ApiResponse<List<VehicleResponse>> findAll() {

        return ApiResponse.success(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<VehicleResponse> findById(
            @PathVariable Long id
    ) {

        return ApiResponse.success(vehicleService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Void> update(
            @PathVariable Long id,
            @Valid @RequestBody VehicleUpdateRequest request
    ) {

        vehicleService.update(id, request);

        return ApiResponse.success();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(
            @PathVariable Long id
    ) {

        vehicleService.delete(id);

        return ApiResponse.success();
    }

}