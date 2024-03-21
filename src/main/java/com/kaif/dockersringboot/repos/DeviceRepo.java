package com.kaif.dockersringboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaif.dockersringboot.entities.Device;


public interface DeviceRepo extends JpaRepository<Device, Long> {

}