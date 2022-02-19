package com.substance.gameobject;

import javax.swing.*;
import java.util.Random;

public class Enemy {
    //敌人的大小
    private int width;
    private int height;
    //    敌人的位置
    private int enemy_x;
    private int enemy_y;
    private static final Random random = new Random();

    public ImageIcon getEnemyImageIcon() {
        return enemyImageIcon;
    }

    private final ImageIcon enemyImageIcon = new ImageIcon("demo2\\src\\com\\image\\enemy.png");

    public Enemy() {
        this.height = enemyImageIcon.getIconHeight();
        this.width = enemyImageIcon.getIconWidth();
//        设置敌机出生点---> x轴，y轴以后
        this.enemy_x = random.nextInt(0,500);
        this.enemy_y = random.nextInt(-660,0);
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

    public int getEnemy_x() {
        return enemy_x;
    }

    public void setEnemy_x(int enemy_x) {
        this.enemy_x = enemy_x;
    }

    public int getEnemy_y() {
        return enemy_y;
    }

    public void setEnemy_y(int enemy_y) {
        this.enemy_y = enemy_y;
    }

    public void setSpeed() {
        this.enemy_y += 3;
    }
}
