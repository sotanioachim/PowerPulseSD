package com.devicesservicemanager.DeviceServiceManager.services;

import com.devicesservicemanager.DeviceServiceManager.dtos.CreateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.UpdateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.builders.DeviceBuilder;
import com.devicesservicemanager.DeviceServiceManager.models.Device;
import com.devicesservicemanager.DeviceServiceManager.models.User;
import com.devicesservicemanager.DeviceServiceManager.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;
    private UserService userService;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,UserService userService){
        this.deviceRepository=deviceRepository;
        this.userService=userService;
    }
    public List<Device> getDevices(){
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long deviceId){
        return deviceRepository.findById(deviceId).get();
    }

    public List<Device> getDevicesByUserId(Long userId) {
        List<Device> allDevices = deviceRepository.findAll();

        List<Device> devicesForUserId = allDevices.stream()
                .filter(device -> device.getUser() != null && device.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());

        return devicesForUserId;}
    public void deleteDevice(Long deviceId){
        deviceRepository.deleteById(deviceId);
    }

    public Device updateDevice(UpdateDeviceDTO updateDevice){
        Device device = deviceRepository.findById(updateDevice.getDeviceId()).get();
        device.setName(updateDevice.getName());
        device.setType(updateDevice.getType());
        device.setMaxConsumption(updateDevice.getMaxConsumption());
        deviceRepository.save(device);
        return device;
    }

    public Device createDevice(Device device){
       // User user = userService.getUserById(createDeviceDTO.getUserId());
       // Device device = DeviceBuilder.toEntity(createDeviceDTO);
       // device.setUser(user);
        return deviceRepository.save(device);
    }

}
