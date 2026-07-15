package com.ecoplan.erp.vehicle.controller;

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
    public Long create(@Valid @RequestBody VehicleCreateRequest request) {

        return vehicleService.create(request);
    }

    @GetMapping
    public List<VehicleResponse> findAll() {

        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public VehicleResponse findById(@PathVariable Long id) {

        return vehicleService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody VehicleUpdateRequest request
    ) {

        vehicleService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        vehicleService.delete(id);
    }

}