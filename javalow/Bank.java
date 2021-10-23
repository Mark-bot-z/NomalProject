package com.javalow;

import java.util.Scanner;

/**
 * @author Mark-Z
 * @version 1.1.0(pro版，设置自定义的个人信息)注:个人信息和对应账户有一一对应的关系,也就是说同一个索引保存的是同一个人的
 * @date 2021-10-22
 */
class Bank {
    private Account[] account;
    private int numberOfA=0;
    private int numberOfC=0;
    private Customer[] customer;
    private Scanner scanner = new Scanner(System.in);

    //用来保存当前登录的账户的地址(退出即销毁)----->很重要后续一连串操作靠它进行,相当于验证码!!!
    private int xnumber;

    //保存个人信息(退出登录即销毁)
    String s = null;

    public Bank(){
        this.account=new Account[10];
        this.customer=new Customer[10];
    }

    public void addAccount(int cid, int cidPassword) {
            account[numberOfA]=new Account(cid,cidPassword);
            numberOfA++;
    }
    /*
        private int numberOfA=0;
        private int numberOfC=0;
        用这两个变量来记录当前用户的个数,这样一来searchCid方法不会造成空指针
        原因:由于创建账户时有先后顺序(详见260行代码),同用一个变量会把指针指向null---customer[x].say()(详见66行代码)
     */
    public void addCustomer(String name,String address, int IDnumber, int phone) {
            customer[numberOfC]=new Customer(name, address, IDnumber, phone);
            numberOfC++;
    }
    //返回一个账户对象数组中具体的账户对象(未使用)
    public Account getAccount(int index) {
        return account[index];
    }

    public Account[] getAccount(){
        //返回整个存储账户对象的地址(未使用)
        return account;
    }
    //返回一个用户对象数组中具体的用户对象
    public Customer getCustomer(int index) {
        return customer[index];
    }

    public Customer[] getCustomer(){
        //返回整个存储账户对象的地址(未使用)
        return customer;
    }
    //(未使用)
    public int getAlength() {
        return account.length;
    }

    //搜索指定的账户的个人信息(卡号)
    public String searchCid(int cid){
//        String s = "-------------------------------List--------------------------------"+"\n";
        System.out.println("-----------------List------------------");
        for (int x = 0;x<numberOfA;x++){
            try {
                if (cid==account[x].getCid()){
                    s="\t\t\t"+" 账户信息"+"\n"+account[x].getInfo()+"\t\t\t"+" 个人信息"+"\n"+customer[x].say()+"\n";
                    return s;
                }
            }catch (Exception exception){
                System.out.print("");
            }
        }return ">>>>>没有该账户的信息<<<<<";
    }
    //匹配指定的账户的信息(密码)
//    public boolean searchCidPassword(int cidPassword){
//        for (int x = 0;x<account.length;x++){
//            if (cidPassword==account[x].getCidPassword()) {
//                return true;
//            }
//        }
//    }

    //验证账号密码
    public boolean validation(int cid,int cidPassword){
        for (int x = 0;x<=numberOfA;x++){
            try {
                if (cidPassword==account[x].getCidPassword() & cid==account[x].getCid()) {
                    //搞不懂为什么验证成功会打印两次
                    System.out.println("验证成功！！！");
                    //把找到的账户位置赋值给xnumber(只有一次赋值)
                     xnumber =x;
                    return true;
                }
            }catch (Exception ignored){
                System.out.print("");
            }
        }
        System.out.println("账号或密码错误！");
        return false;
    }

    //登录账户

    /**
     *最关键的环节:其实写到这里,我自己也蒙了(现在看到里面的各种结构,人都傻了),想了好久
     */
    public void login() {
        System.out.println("--------------->登录<----------------");
        while (true) {
            for (int q = 3; q >= 0; q--) {

                System.out.print("请输入你的卡号： ");
                int cid = scanner.nextInt();
                System.out.print("请输入你的密码； ");
                int cidPassword = scanner.nextInt();
                if (!validation(cid, cidPassword)) {
//                    if (q-1 != 0){
//                        System.out.println("你还有"+(q-1)+"次机会，次数用完会退出登录！！！");
//                    }
//                    if (q-1 == 0){
//                        System.out.println("次数已尽");
//                        break loop1;
//                    }
                            /**
                             * @deprecated
                             *@author Mark-Z
                             * @date 2021-10-11
                             * @version 1.0.1
                             */
                    /*
                    每次密码输入错误时:
                    借助另一个方法来判断次数是否用尽,用尽则返回true,然后退出
                     */
                    if (main(q)) {
                        System.out.println("--------------<已强制下线>--------------");
                        return;
                    }

//                    System.out.println("请重新输入--->");

                }
                if (validation(cid, cidPassword)) {
                    System.out.println("--------------<登录成功>--------------");
                    for (; ; ) {
                        System.out.print("你是要存钱(1)还是取钱(2)还是修改个人信息(3),还是退出登录(exit)： ");
                        loop2:
                        while (true) {
                            String sc = scanner.next();
                            if ("存钱".equals(sc) || "1".equals(sc)) {
                                System.out.print("你要存多少钱：");
//                               account[xnumber].withDraw(scanner.nextDouble());
                                setw(scanner.nextDouble(), xnumber);
                            }
                            if ("取钱".equals(sc) || "2".equals(sc)) {
                                System.out.print("你要取多少钱： ");
//                                account[i].save(scanner.nextDouble());
                                sets(scanner.nextDouble(), xnumber);
                            }
                            if ("3".equals(sc)) {
                                System.out.println("------------修改个人信息-------------");
                                System.out.println(">>>>>>>>>>这是当前账户的信息<<<<<<<<<<");
                                System.out.println(customer[xnumber].say());
                                System.out.println(">>>>>>>>>>>>>>显示完毕<<<<<<<<<<<<<<");
                                setInfo(xnumber);
                                System.out.println("--------------修改完毕---------------");
                            }
                            if ("exit".equals(sc)) {
                                //下线及销毁该变量
                                xnumber = 0;
                                System.out.println("-------------<用户已下线>-------------");
                                return;
                            }
                            //显示结果
                            System.out.println(customer[xnumber].say());
                            for (;;) {
//                                (这里需要输入两次2才能退出,我也不知道是为什么)
                                System.out.print("是否还要进行操作？按1继续/按2退出： ");
                                if (1 == scanner.nextInt()) {
                                    break loop2;
                                } else if (2 == scanner.nextInt()) {
                                    //下线及销毁该变量
                                    xnumber = 0;
                                    System.out.println("-------------<用户已下线>-------------");
                                    return;
                                } else {
                                    System.out.println(">>>输入错误<<<");
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    /*
    中间被注释的代码块可以被忽略
     */
//            while (true) {
//                System.out.print("你是要存钱(1)还是取钱(2)还是修改个人信息(3),还是退出登录(exit)： ");
//                String sc = scanner.next();
//                if ("存钱".equals(sc) || "1".equals(sc)) {
//                    System.out.print("你要存多少钱：");
////                               account[i].withDraw(scanner.nextDouble());
//                    setw(scanner.nextDouble(), i);
//                }
//                if ("取钱".equals(sc) || "2".equals(sc)) {
//                    System.out.print("你要取多少钱： ");
////                                account[i].save(scanner.nextDouble());
//                    sets(scanner.nextDouble(), i);
//                }
////                            if ("3".equals(sc)){
////                            }
//                if ("exit".equals(sc)) {
//                    break loop;
//                }
//                customer[i].say();
//                System.out.println("-------------<用户已下线>-------------");
//            }
////    }
////                else{
////                    try {
////                        throw new Exception("无法找到该账户！请先创建账户！");
////                    } catch (Exception exception) {
////                        exception.printStackTrace();
////                    }
////                }
//    }
//
//
    //存钱
    public void setw(double withDraw,int index){
            account[index].withDraw(withDraw);
    }
    /*
    这两方法也靠验证码进行
    --->其实就是validation方法中赋值给xnumber
    该账户和对应的个人信息的地址
     */
    //取钱
    public void sets(double save,int index){
            account[index].save(save);
    }

    //                for (int i = 3;i>0;i--){
//                    System.out.print("请输入你的cid号： ");
//                    int c =scanner.nextInt();
//                    System.out.print("请输入你的cid密码： ");
//                    int p =scanner.nextInt();
//                        if (account[i].getCid()==c&&account[i].getCidPassword()==p){
//                            while (true){
//                                try {
//                                    System.out.print("你是要存钱还是取钱： ");
//                                    String sc = scanner.next();
//                                    if ("存钱".equals(sc)){
//                                        System.out.print("你要存多少钱：");
//                                        account[i].withDraw(scanner.nextDouble());
//                                    }
//                                    if("取钱".equals(sc)){
//                                        System.out.print("你要取多少钱： ");
//                                        account[i].save(scanner.nextDouble());
//                                    }
//                                    System.out.println();
//                                }catch (Exception ignored){
//                                    System.out.println("error");
//                                }
//                                }
//
//                        }else {
//                            System.out.println("账号或密码错误！"+"\n");
//                            main(i,c,p,account);
//                        }
   //关于方法的重载
    static boolean main(int j) {
        if (0 != (j - 1)) {
            System.out.println("输入错误，你还有" + (j - 1) + "次机会！");
            System.out.print("请重新输入--> ");
        }
        if (0 == (j - 1)) {
            System.out.println("拜拜啦，兄弟！");
            return true;
        }
        return false;
    }

    //用户添加账户
    public void setWill(){
        while(true){
            System.out.print("是否取消操作(1[取消]/2[继续])： ");
            int yesorno = scanner.nextInt();
            if (yesorno==1){
                return;
            }else if(yesorno==2){
                System.out.println("-------------->创建账户<--------------");
                System.out.print("输入卡号： ");
                int cid = scanner.nextInt();
                System.out.print("密码: ");
                int cidPassword = scanner.nextInt();
                addAccount(cid, cidPassword);
                /*
                这里的机制比较能看懂(哈哈哈)
                 */
                System.out.print("姓名： ");
                String name = scanner.next();
                System.out.print("地址： ");
                String address = scanner.next();
                System.out.print("身份证号： ");
                int IDnumber = scanner.nextInt();
                System.out.print("手机号： ");
                int phone = scanner.nextInt();
                addCustomer(name, address, IDnumber, phone);
                System.out.println("--------------->完成<----------------");
                return;
            }else{
                System.out.println(">>>选择错误<<<");
            }
        }
        }


    //修改指定的账户信息
    public void setInfo(int index){
        System.out.println("请输入你想修改的名字(按回车为下一个,下同): ");
        String n = scanner.next();
        getCustomer(index).setName(setName(index,n));

        System.out.println("请输入你想修改的的住址: ");
        String a = scanner.next();
        getCustomer(index).setAddress(setAddress(a,index));

        System.out.print("请输入你想修改的的手机号: ");
        int p = scanner.nextInt();
        getCustomer(index).setPhone(setPhone(index,p));
   }
    //以下是实现回车返回默认值的方法(利用回车等于空串的方法)
    public String setName(int index,String name){
        if (name.equals("")){
            return getCustomer(index).getName();
        }
        return name;
    }
    public String setAddress(String address,int index ){
        if (address.equals("")){
            return getCustomer(index).getAddress();
        }
        return address;
    }
    /*
    包装成字符串来比较
     */
    public int setPhone(int index, int phone){
        if (Integer.toString(phone).equals("")){
            return getCustomer(index).getIDnumber();
        }return phone;
    }
}

