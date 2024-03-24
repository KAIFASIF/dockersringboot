// package com.kaif.dockersringboot.entities;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// public class Device {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long time;
//     private String msg;
//     private Long humidity;
//     private Long temperature;

// }

package com.kaif.dockersringboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stateOfCharge;
    private Long packVoltage;
    private Long current;
    private Long temperature1;
    private Long temperature2;
    private Long temperature3;
    private Long temperature4;
    private Long minCellVoltage;
    private Long maxCellVoltage;
    private String faultStatus;
    private String fetProtectionStatus;

}