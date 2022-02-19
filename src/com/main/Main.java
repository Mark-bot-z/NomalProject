package com.main;

import com.substance.Window;
import com.substance.service.Container;

public class Main {
    public static void main(String[] args) {
        Window window = Window.getInstance();
        Container container = Container.getInstance();
//        添加面板容器
        window.add(container);
//        添加监听器，就是调用面板容器中重写的方法
        window.addMouseMotionListener(container);
        window.start();
        try {
//            真正的游戏开始了
            container.startEnemy();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
