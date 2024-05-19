package com.CourseWork.CourseWorkForOOP;

import java.util.ArrayList;

public class ListOfSentTrucks {
    ArrayList<SentTruck> sentTrucks=new ArrayList<>();

    void show(){
        for (SentTruck sentTruck : sentTrucks) {
            sentTruck.show();
        }
    }
    void add(SentTruck sentTruck){
        sentTrucks.add(sentTruck);
    }
    SentTruck get(int number){
        return sentTrucks.get(number);
    }
    SentTruck getLast(){
        return sentTrucks.get(sentTrucks.size()-1);
    }
    Boolean isEmpty(){
        return sentTrucks.isEmpty();
    }

    int getSize(){
        return sentTrucks.size();
    }
}
