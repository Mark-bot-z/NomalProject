package com.substance.gameobject;

import javax.swing.*;

public class Hero {
    private static Hero heroInstance = null;
    private static int hero_x = 300;
    private static int hero_y = 400;
    private final ImageIcon hero = new ImageIcon("demo2\\src\\com\\image\\hero.png");

    public static Hero getHeroInstance() {
        if (heroInstance == null) {
            return heroInstance = new Hero();
        } else {
            return heroInstance;
        }
    }
    private Hero(){

    }
    public ImageIcon getHero() {
        return hero;
    }

    public int getHero_x() {
        return hero_x;
    }

    public void setHero_x(int hero_x) {
        Hero.hero_x = hero_x;
    }

    public int getHero_y() {
        return hero_y;
    }

    public void setHero_y(int hero_y) {
        Hero.hero_y = hero_y;
    }
}
