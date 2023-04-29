package com.example.synegymod4;

import java.io.Serializable;

public class User implements Serializable {

   private String nameId;
   private String departPoint;
   private String arrivePoint;
   private String timeDepart;
   private String timeArrive;
   private String ticketPrice;

    public User(String nameId, String departPoint, String arrivePoint, String timeDepart, String timeArrive, String ticketPrice) {
        this.nameId = nameId;
        this.departPoint = departPoint;
        this.arrivePoint = arrivePoint;
        this.timeDepart = timeDepart;
        this.timeArrive = timeArrive;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Данные железнодорожного билета " +
                "ваш ID " + nameId + '\n' +
                "Место отправления " + departPoint + '\n' +
                "Место прибытия " + arrivePoint + '\n' +
                "Время отправления " + timeDepart + '\n' +
                "Время прибытия " + timeArrive + '\n' +
                "Цена билета " + ticketPrice;
    }
}
