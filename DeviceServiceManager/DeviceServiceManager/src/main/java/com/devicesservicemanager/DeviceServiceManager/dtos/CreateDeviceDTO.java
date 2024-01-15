package com.devicesservicemanager.DeviceServiceManager.dtos;

public class CreateDeviceDTO {
    private Long deviceId;
    private String name;
    private String type;

    private double maxConsumption;
    private Long userId;

    public CreateDeviceDTO() {
    }

    public CreateDeviceDTO(Long deviceId, String name, String type,double maxConsumption, Long userId) {
        this.deviceId = deviceId;
        this.name = name;
        this.type = type;
        this.maxConsumption = maxConsumption;
        this.userId = userId;
    }

    public double getMaxConsumption() {
        return maxConsumption;
    }

    public void setMaxConsumption(double maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
