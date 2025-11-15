package com.ev.ampora_backend.service;

import com.ev.ampora_backend.dto.VehicleDTO;
import com.ev.ampora_backend.entity.User;
import com.ev.ampora_backend.entity.Vehicle;
import com.ev.ampora_backend.repository.UserRepository;
import com.ev.ampora_backend.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
  private final VehicleRepository vehicleRepo;
  private final UserRepository userRepo;

  public VehicleDTO saveVehicle(VehicleDTO dto){
      User user = userRepo.findById(dto.getUserId()).orElseThrow(()->new RuntimeException("User not found"));
      Vehicle vehicle=Vehicle.builder().model(dto.getModel()).batteryCapacityKwh(dto.getBatteryCapacityKwh()).efficiencyKmPerKwh(dto.getEfficiencyKmPerKwh()).connectorType(dto.getConnectorType()).user(user).build();
      Vehicle saved= vehicleRepo.save(vehicle);
      dto.setVehicleId(saved.getVehicleId());
      return dto;

  }

}
