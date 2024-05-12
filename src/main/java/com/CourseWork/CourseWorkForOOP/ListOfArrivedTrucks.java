package com.CourseWork.CourseWorkForOOP;

import java.util.ArrayList;

public class ListOfArrivedTrucks {
    ArrayList<ArrivedTruck> arrivedTrucks=new ArrayList<>();

    void show(){
        for (int i=0;i<arrivedTrucks.size();i++){
            arrivedTrucks.get(i).show();
        }
    }
    void add(ArrivedTruck arrivedTruck){
        arrivedTrucks.add(arrivedTruck);
    }
    ArrivedTruck get(int number){
        return arrivedTrucks.get(number);
    }
    ArrivedTruck getLast(){
        return arrivedTrucks.get(arrivedTrucks.size()-1);
    }
    boolean isEmpty(){
        return arrivedTrucks.isEmpty();
    }

    int getSize(){
        return arrivedTrucks.size();
    }
}
