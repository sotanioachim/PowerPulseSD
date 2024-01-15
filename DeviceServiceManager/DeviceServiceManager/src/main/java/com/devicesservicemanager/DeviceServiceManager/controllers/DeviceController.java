package com.devicesservicemanager.DeviceServiceManager.controllers;

import com.devicesservicemanager.DeviceServiceManager.dtos.CreateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.UpdateDeviceDTO;
import com.devicesservicemanager.DeviceServiceManager.dtos.builders.DeviceBuilder;
import com.devicesservicemanager.DeviceServiceManager.models.Device;
import com.devicesservicemanager.DeviceServiceManager.publisher.RabbitMQProducer;
import com.devicesservicemanager.DeviceServiceManager.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
@CrossOrigin("*")
public class DeviceController {
    private final DeviceService deviceService;
    private final RabbitMQProducer producer;

    @Autowired
    public DeviceController(DeviceService deviceService, RabbitMQProducer producer){
        this.deviceService = deviceService;
        this.producer = producer;
    }

    @GetMapping
    public ResponseEntity<List<Device>> getDevices(){
        return new ResponseEntity<>(deviceService.getDevices(), HttpStatus.OK);
    }

    @GetMapping(path="{deviceId}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long deviceId){
        return new ResponseEntity<>(deviceService.getDeviceById(deviceId),HttpStatus.OK);
    }

    @GetMapping(path="/ForUser/{userId}")
    public ResponseEntity<List<Device>> getDevicesByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(deviceService.getDevicesByUserId(userId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device){
        Device savedDevice = deviceService.createDevice((device));
        producer.sendMessage(DeviceBuilder.toMeasurementDeviceDTO(savedDevice));
        producer.sendMessageDeviceId(savedDevice.getDeviceId());
        return new ResponseEntity<>(savedDevice,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Device> updateDevice(@RequestBody UpdateDeviceDTO deviceDTO){
        Device updatedDevice = deviceService.updateDevice((deviceDTO));
        producer.sendMessage(DeviceBuilder.toMeasurementDeviceDTO(updatedDevice));
        return new ResponseEntity<>(updatedDevice,HttpStatus.OK);
    }

    @DeleteMapping(path="{deviceId}")
    public void deleteDevice(@PathVariable Long deviceId){
        deviceService.deleteDevice(deviceId);
    }
}
