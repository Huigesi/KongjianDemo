package com.example.administrator.kongjiandemo.ListView;

/**
 * Created by Administrator on 2017/12/8.
 */

public class Itembean {
    private int id;
    private int Red;
    private int Green;
    private int Yellow;

    public Itembean() {
    }

    public Itembean(int id, int red, int green, int yellow) {
        this.id = id;
        Red = red;
        Green = green;
        Yellow = yellow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRed() {
        return Red;
    }

    public void setRed(int red) {
        Red = red;
    }

    public int getGreen() {
        return Green;
    }

    public void setGreen(int green) {
        Green = green;
    }

    public int getYellow() {
        return Yellow;
    }

    public void setYellow(int yellow) {
        Yellow = yellow;
    }
}
