package com.ev.ampora_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VehicleDTO {
    private String vehicleId;
    private String model;
    private double batteryCapacityKwh;
    private double efficiencyKmPerKwh;
    private String connectorType;
    private String userId;
}
