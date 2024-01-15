package com.devicesservicemanager.DeviceServiceManager.repositories;

import com.devicesservicemanager.DeviceServiceManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
