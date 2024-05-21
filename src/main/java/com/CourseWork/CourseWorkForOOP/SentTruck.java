package com.CourseWork.CourseWorkForOOP;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SentTruck {
    private String truckNumber;
    private final LocalTime sentTime;
    private final LocalDate sentDate;

    private String sentTo;
    private double weightOfTruck;

    public SentTruck(String truckNumber, String sentTo, double weightOfTruck) {
        this.truckNumber = truckNumber;
        this.sentTo = sentTo;
        this.weightOfTruck = weightOfTruck;
        sentTime=LocalTime.now();
        sentDate=LocalDate.now();
    }
    public SentTruck() {
        this.truckNumber = "";
        this.sentTo = "";
        this.weightOfTruck = 0;
        sentTime=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        sentDate=LocalDate.now();
    }

    void show(){
        System.out.println("Truck number: "+truckNumber);
        System.out.println("Truck sent to: "+sentTo);
        System.out.println("Weight of truck: "+weightOfTruck);
        System.out.println("Truck has arrived at: "+sentDate+" "+sentTime);

    }

    boolean isSentToEmpty(){
        return sentTo.isEmpty();
    }
    boolean isTruckNumberEmpty(){
        return truckNumber.isEmpty();
    }
    boolean isWeightOfTruckEmpty(){
        return weightOfTruck != 0;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public LocalTime getSentTime() {
        return sentTime;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public double getWeightOfTruck() {
        return weightOfTruck;
    }

    public void setWeightOfTruck(double truckWeight) {
        this.weightOfTruck = truckWeight;
    }
}
