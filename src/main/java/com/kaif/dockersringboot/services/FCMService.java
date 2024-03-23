package com.kaif.dockersringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.kaif.dockersringboot.entities.Device;
import org.json.JSONObject;

@Service
public class FCMService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    // public void sendNotificationByToken(Device payload) throws
    // FirebaseMessagingException {

    // var notification =
    // Notification.builder().setTitle("Title").setBody("Body").build();
    // var message = Message.builder().setToken(
    // "dp_u97twW-QnwEgMVQFJuq:APA91bEM8wEhyn0KrbINtoHdWpT0asBCnBygHyRmw7Vmd_KeqhrTfXSjFQdGxpP7n_lP48CV59rgYWXAJidgwr6aqsDPBi7yILk_dfQABuHtXBGgfu3Wm0vwF-YzoicDfTgL9H5NJsiw")
    // .setNotification(notification).build();
    // firebaseMessaging.send(message);

    // }

    public void sendNotificationByToken(Device payload) throws FirebaseMessagingException {

        System.out.println("*************************************************************");
        System.out.println(payload);
        System.out.println("*************************************************************");
        var notification = Notification.builder().setTitle("Fault message").setBody("TBody description").build();
        var jsonDataObj = new JSONObject(payload);
        var message = Message.builder().setNotification(notification)
                .putData("jsonDataObj", jsonDataObj.toString())
                .build();
        firebaseMessaging.send(message);

    }

}
