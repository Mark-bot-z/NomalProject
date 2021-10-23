package com.javalow;

import java.util.Scanner;

/**
 * @Description 封装性的具体应用(520行代码实现该小小小项目)
 * @author Mark-Z
 * @version 1.2.3(增强版):1.添加图形化界面2.登录后可以修改个人信息和密码(暂没有实现)3.有错误反馈机制4.不足之处,实在不知道怎么改了
 * @date 2021-10-22
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        System.out.println("""
                ------------------银行系统-----------------
                                1.创建账户
                                2.登录账户
                                3.搜索账户
                                4.退出
                                注：登录后可以修改个人信息
                ---------------------------------------------
                """);
        while (true) {
            System.out.print("请选择一个数字继续： ");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    bank.setWill();
                }
                case 2 -> {
                    bank.login();
                }
                case 3 -> {
                    System.out.println("----------------搜索账户----------------");
                    System.out.println("请输入要搜索的农业银行卡号： ");
                    System.out.println(bank.searchCid(scanner.nextInt()));
                    System.out.println("--------------->搜索完毕<---------------");
                }
                case 4 -> System.exit(101);
                default -> {
                    try {
                        throw new Exception("Error!");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
//        String s1= bank.getAccount(0).getInfo();
//        System.out.println(s1);
    }

//        bank.addAccount(1234,123243);
//        bank.addCustomer("da","f",23,34);
//        bank.getAccount(0);
//        bank.getCustomer(0);

}