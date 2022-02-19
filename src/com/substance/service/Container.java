package com.substance.service;

import com.substance.Window;
import com.substance.gameobject.Bomb;
import com.substance.gameobject.Bullet;
import com.substance.gameobject.Enemy;
import com.substance.gameobject.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Container extends JPanel implements MouseMotionListener {
    private static List<Enemy> enemyList = new ArrayList<>();
    private static List<Bullet> bulletList = new ArrayList<>();
    private static ArrayList<Bomb> bombList = new ArrayList<>();
    private int hero_x = Hero.getHeroInstance().getHero_x();
    private int hero_y = Hero.getHeroInstance().getHero_y();
    private Image heroImage = Hero.getHeroInstance().getHero().getImage();

    public static Container getInstance() {
        for (int i = 0; i < 10; i++) {
            enemyList.add(new Enemy());
        }
        return new Container();
    }

    class ClearnerBomb implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < bombList.size(); i++) {
                    bombList.remove(i);
                }
            }
        }
    }

    class Clear implements Runnable{
        @Override
        public void run() {
            while(true){
                for (int j = 0; j < enemyList.size() - 1; j++) {
                    for (int k = 0; k < bulletList.size() - 1; k++) {
                        if (isTrue(bulletList.get(k), enemyList.get(j))) {
                            Bomb bomb = new Bomb(enemyList.get(j).getEnemy_x(), enemyList.get(j).getEnemy_y());
                            bombList.add(bomb);
                            enemyList.remove(j);
                            enemyList.add(new Enemy());
                            bulletList.remove(k);
                            fraction++;
                        }
                    }
                }
                repaint();
            }
        }
    }

    public void startEnemy() throws Exception {
        new Thread(new ClearnerBomb()).start();
        new Thread(new Clear()).start();
        int counts = 0;
        while (true) {
            counts++;
            if (counts % 5 == 0) {
                Bullet bull = new Bullet();
                bull.setBullet_x(hero_x + 48);
                bull.setBullet_y(hero_y);
                bulletList.add(bull);
            }
            for (Bullet bullet : bulletList) {
                bullet.setSpeed();
            }
            for (int i = 0; i < bulletList.size(); i++) {
                if (bulletList.get(i).getBullet_y() < 0) {
                    bulletList.remove(i);
                }
            }
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).setSpeed();
                if (enemyList.get(i).getEnemy_y() > Window.height) {
                    enemyList.remove(i);
                    fraction -= 10;
                    if (fraction < 0){
                        System.exit(-1);
                    }
//                    敌人源源不断地增加和消失
                    enemyList.add(i, new Enemy());
                }
            }
            Thread.sleep(10);
            repaint();
        }
    }

    private boolean isTrue(Bullet bullet, Enemy enemy) {
        Rectangle rectangle = new Rectangle(enemy.getEnemy_x(), enemy.getEnemy_y(), enemy.getWidth(), enemy.getHeight());
        Point point = new Point(bullet.getBullet_x() + bullet.getWidth() / 2, bullet.getBullet_y() + bullet.getHeight() / 2);
        return rectangle.contains(point);
    }

    private static int fraction = 0;
    @Override
    public synchronized void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setFont(new Font("SansSerif",Font.ITALIC,48));
        graphics.drawString("当前得分：" + fraction,20,55);
        graphics.drawImage(heroImage, hero_x, hero_y, null);
        for (Enemy enemy : enemyList) {
            graphics.drawImage(
                    enemy.getEnemyImageIcon().getImage(),
                    enemy.getEnemy_x(),
                    enemy.getEnemy_y(), null
            );
        }
        for (Bullet bullet : bulletList) {
            graphics.drawImage(
                    bullet.getBulletImage().getImage(),
                    bullet.getBullet_x(),
                    bullet.getBullet_y(), null
            );
        }
        for (Bomb bomb : bombList) {
            graphics.drawImage(bomb.getBombImage().getImage(),
                    bomb.getBomb_x(),
                    bomb.getBomb_y(), null
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        鼠标按下并移动调用
        hero_x = e.getX() - 50;
        hero_y = e.getY() - 80;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
