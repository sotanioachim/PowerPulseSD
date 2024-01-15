package com.devicesservicemanager.DeviceServiceManager.models;

import jakarta.persistence.*;

@Entity
@Table(name="devices")
public class Device {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name="device_id")
    private Long deviceId;

    private String name;
    private String type;

    @Column(name = "max_consumption", nullable = false, columnDefinition = "float default 0.0")
    private double maxConsumption;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    public Device() {
    }

    public Device(Long deviceId, String name, String type,double maxConsumption, User user) {
        this.deviceId = deviceId;
        this.name = name;
        this.type = type;
        this.user = user;
        this.maxConsumption = maxConsumption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

}
