package com.devicesservicemanager.DeviceServiceManager.dtos;

public class MeasurementDeviceDTO {
    private Long deviceId;
    private double maxConsumption;

    public MeasurementDeviceDTO(Long deviceId, double maxConsumption) {
        this.deviceId = deviceId;
        this.maxConsumption = maxConsumption;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public double getMaxConsumption() {
        return maxConsumption;
    }

    public void setMaxConsumption(double maxConsumption) {
        this.maxConsumption = maxConsumption;
    }
}
