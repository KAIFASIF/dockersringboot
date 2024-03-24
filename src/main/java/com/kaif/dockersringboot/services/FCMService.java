package com.kaif.dockersringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repos.DeviceRepo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private DeviceRepo deviceRepo;

    private Logger logger = LoggerFactory.getLogger(FCMService.class);

    public void sendNotificationByToken(Device payload) throws FirebaseMessagingException {
        System.out.println("*************sss********************************************");
        System.out.println(payload);
        System.out.println("*********************************************************");
        // String payloadJson = convertToJson(payload);

        Message message = Message.builder()
                .setToken("fjFrS7TjTxjsONSCo92kK3:APA91bHOZ23_f1P-Im7XZ7FSUEi_a-XPfg19XnlShBre19iwKRAfKpH9JddDOExyGO0NZpHFJXMc2Nbpn2sKBKHE_QuXIfYANSrw7D1IyElPFflJHETPzHlFI3AaQu2cM8xAvJ84Zb13")
                .putData("jsonData", "kaif") 
                .build();
                firebaseMessaging.send(message);
    }

    public void sendPushNotification(Device payload) {
        // try {
        //     Message message = Message.builder()
        //     .setToken("fjFrS7TjTxjsONSCo92kK3:APA91bHOZ23_f1P-Im7XZ7FSUEi_a-XPfg19XnlShBre19iwKRAfKpH9JddDOExyGO0NZpHFJXMc2Nbpn2sKBKHE_QuXIfYANSrw7D1IyElPFflJHETPzHlFI3AaQu2cM8xAvJ84Zb13")
        //     .putData("jsonData", "kaif") 
        //     .build();
        //     message.sendMessage(getSamplePayloadData().toString());
        // } catch (Exception e) {
        //     logger.error(e.getMessage());
        // }
    }

    private Map<String, String> getSamplePayloadData() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", "msgid");
        pushData.put("text", "txt");
        pushData.put("user", "pankaj singh");
        return pushData;
    }

    private String convertToJson(Device payload) { 
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stateOfCharge", payload.getStateOfCharge());
        jsonObject.put("packVoltage", payload.getPackVoltage());
        jsonObject.put("current", payload.getCurrent());
        jsonObject.put("temperature1", payload.getTemperature1());
        jsonObject.put("temperature2", payload.getTemperature2());
        jsonObject.put("temperature3", payload.getTemperature3());
        jsonObject.put("temperature4", payload.getTemperature4());
        jsonObject.put("minCellVoltage", payload.getMinCellVoltage());
        jsonObject.put("maxCellVoltage", payload.getMaxCellVoltage());
        jsonObject.put("faultStatus", payload.getFaultStatus());
        jsonObject.put("fetProtectionStatus", payload.getFetProtectionStatus());
        return jsonObject.toString();
    }

    // public void sendNotificationByToken(Device payload) throws
    // FirebaseMessagingException {

    // var notification =
    // Notification.builder().setTitle("Title").setBody("Body").build();
    // var message = Message.builder().setToken(
    // "dp_u97twW-QnwEgMVQFJuq:APA91bEM8wEhyn0KrbINtoHdWpT0asBCnBygHyRmw7Vmd_KeqhrTfXSjFQdGxpP7n_lP48CV59rgYWXAJidgwr6aqsDPBi7yILk_dfQABuHtXBGgfu3Wm0vwF-YzoicDfTgL9H5NJsiw")
    // .setNotification(notification).build();
    // firebaseMessaging.send(message);
    // deviceRepo.save(payload);

    // }

    // public void sendNotificationByToken(Device payload) throws
    // FirebaseMessagingException {

    // System.out.println("*************************************************************");
    // System.out.println(payload);
    // System.out.println("*************************************************************");
    // deviceRepo.save(payload);
    // var notification = Notification.builder().setTitle("Fault
    // message").setBody("TBody description").build();
    // var jsonDataObj = new JSONObject(payload);
    // var message = Message.builder().setNotification(notification)
    // .putAllData("jsonDataObj", jsonDataObj)
    // .build();
    // firebaseMessaging.send(message);

    // }

}