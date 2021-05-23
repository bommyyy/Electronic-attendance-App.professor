package com.example.myapplication;

public class Sub_item {
    String name;
    String num;

    public Sub_item(String num, String name){
        this.num=num;
        this.name=name;
    }

    public Sub_item(){}

    public String getNum(){
        return num;
    }

    public void setNum(String num){
        this.num= num;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name =name;
    }
}
