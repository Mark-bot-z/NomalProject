package com.substance.gameobject;

import javax.swing.*;

public class Bomb {
    private final ImageIcon bombImage = new ImageIcon("demo2\\src\\com\\image\\bomb.png");
    private int width;
    private int height;

    private int bomb_x;
    private int bomb_y;

    public Bomb(int bomb_x,int bomb_y) {
        this.setHeight(bombImage.getIconHeight());
        this.setWidth(bombImage.getIconWidth());
        this.bomb_x = bomb_x;
        this.bomb_y = bomb_y;
    }

    public ImageIcon getBombImage() {
        return bombImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBomb_x() {
        return bomb_x;
    }

    public void setBomb_x(int bomb_x) {
        this.bomb_x = bomb_x;
    }

    public int getBomb_y() {
        return bomb_y;
    }

    public void setBomb_y(int bomb_y) {
        this.bomb_y = bomb_y;
    }
}
