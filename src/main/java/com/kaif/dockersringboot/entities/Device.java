package com.kaif.dockersringboot.entities;

import lombok.Data;

@Data
public class Device {
    private Long time;
    private String msg;
    private Long humidity;
    private Long temperature;

}
