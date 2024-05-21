package com.CourseWork.CourseWorkForOOP;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
        arrivalTime=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        arrivalDate=LocalDate.now();
    }

    void show(){
        System.out.println("Truck number: "+truckNumber);
        System.out.println("Truck arrived from: "+arrivedFrom);
        System.out.println("Weight of truck: "+weightOfTruck);
        System.out.println("Truck has arrived at: "+arrivalDate+" "+arrivalTime);

    }

    boolean isArrivedFromEmpty(){
        return arrivedFrom.isEmpty();
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

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public LocalTime setArrivalTime(int hour,int minute,int second,int nanoOfSeconds){
        return LocalTime.of(hour,minute,second,nanoOfSeconds);
    }
    public LocalTime setArrivalTime(int hour,int minute,int second){
        return LocalTime.of(hour,minute,second);
    }


    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public LocalDate setArrivalDate(int year,int month,int dayOfMonth) {
        return LocalDate.of(year,month,dayOfMonth);
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
