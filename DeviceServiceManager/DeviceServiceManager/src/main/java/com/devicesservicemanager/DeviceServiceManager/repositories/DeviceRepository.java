package com.devicesservicemanager.DeviceServiceManager.repositories;

import com.devicesservicemanager.DeviceServiceManager.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

    Optional<Device> findByName(String name);
}
