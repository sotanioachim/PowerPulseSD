package com.devicesservicemanager.DeviceServiceManager.dtos.builders;

import com.devicesservicemanager.DeviceServiceManager.dtos.CreateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.MeasurementDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.UpdateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.models.Device;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DeviceBuilder {
    public static UpdateDeviceDTO toUpdateDeviceDTO(Device device) {
        UpdateDeviceDTO updateDeviceDTO = new UpdateDeviceDTO(
                device.getDeviceId(),
                device.getName(),
                device.getType(),
                device.getMaxConsumption()
        );
        return updateDeviceDTO;
    }

    public static Device toEntity(UpdateDeviceDTO updateDeviceDTO){
        Device device = new Device(
                updateDeviceDTO.getDeviceId(),
                updateDeviceDTO.getName(),
                updateDeviceDTO.getType(),
                updateDeviceDTO.getMaxConsumption(),
                null
        );
        return device;
    }
    public static Device toEntity(CreateDeviceDTO updateDeviceDTO){
        Device device = new Device(
                0l,
                updateDeviceDTO.getName(),
                updateDeviceDTO.getType(),
                updateDeviceDTO.getMaxConsumption(),
                null
        );
        return device;
    }

    public static MeasurementDeviceDTO toMeasurementDeviceDTO(Device savedDevice){
        MeasurementDeviceDTO measurementDeviceDTO = new MeasurementDeviceDTO(
                savedDevice.getDeviceId(),
                savedDevice.getMaxConsumption()
        );
        return measurementDeviceDTO;
    }
}
