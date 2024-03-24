
package com.kaif.dockersringboot.subscriber;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repos.DeviceRepo;

@Service
public class DeviceSubscribe {

    @Autowired
    private DeviceRepo deviceRepo;

    Logger log = LoggerFactory.getLogger(DeviceSubscribe.class);

    @KafkaListener(topics = "device-topic", groupId = "customergroup")
    public void listen(Device payload) {
        log.info("Subscribed customer json: {}", payload);
        deviceRepo.save(payload);
    }

}
