package com.substance.gameobject;

import javax.swing.*;

public class Bullet {
    private final ImageIcon bulletImage = new ImageIcon("demo2\\src\\com\\image\\bullet.png");
    private int width;
    private int height;

    private int bullet_x = 350;
    private int bullet_y = 400;

    public Bullet() {
        this.width = getBulletImage().getIconWidth();
        this.height = getBulletImage().getIconHeight();
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

    public int getBullet_x() {
        return bullet_x;
    }

    public void setBullet_x(int bullet_x) {
        this.bullet_x = bullet_x;
    }

    public int getBullet_y() {
        return bullet_y;
    }

    public void setBullet_y(int bullet_y) {
        this.bullet_y = bullet_y;
    }

    public ImageIcon getBulletImage() {
        return bulletImage;
    }

    public void setSpeed(){
        this.bullet_y -= 10;
    }
}
