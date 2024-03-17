package com.kaif.dockersringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repo.DeviceRepo;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    public Device saveDevice(Device data){        
        return deviceRepo.save(data);

    }
    
}
