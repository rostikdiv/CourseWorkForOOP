package com.CourseWork.CourseWorkForOOP;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrivedTruck {

    private String truckNumber;
    private final LocalTime arrivalTime;
    private final LocalDate arrivalDate;

    private String arrivedFrom;
    private double weightOfTruck;

    public ArrivedTruck(String truckNumber, String arrivedFrom, double weightOfTruck) {
        this.truckNumber = truckNumber;
        this.arrivedFrom = arrivedFrom;
        this.weightOfTruck = weightOfTruck;
        arrivalTime=LocalTime.now();
        arrivalDate=LocalDate.now();
    }
    public ArrivedTruck(){
        truckNumber = "";
        arrivedFrom = "";
        weightOfTruck = 0;
        arrivalTime=LocalTime.now();
        arrivalDate=LocalDate.now();
    }

    void show(){
        System.out.println("Truck number: "+truckNumber);
        System.out.println("Truck arrived from: "+arrivedFrom);
        System.out.println("Weight of truck: "+weightOfTruck);
        System.out.println("Truck has arrived at: "+arrivalDate+" "+arrivalTime);

    }

    boolean isArrivedFromInitiated(){
        if(arrivedFrom.equals("")){
            return false;
        } else {
            return true;
        }
    }
    boolean isTruckNumberInitiated(){
        if(truckNumber.equals("")){
            return false;
        } else {
            return true;
        }
    }
    boolean isWeightOfTruckInitiated(){
        if(weightOfTruck==0){
            return false;
        } else {
            return true;
        }
    }
    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivedFrom() {
        return arrivedFrom;
    }

    public void setArrivedFrom(String arrivedFrom) {
        this.arrivedFrom = arrivedFrom;
    }

    public double getWeightOfTruck() {
        return weightOfTruck;
    }

    public void setWeightOfTruck(double weightOfTruck) {
        this.weightOfTruck = weightOfTruck;
    }
}
