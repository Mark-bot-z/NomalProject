package com.javalow;

/**
 * @author Mark-Z
 * @version 0.1.0 该类作为生成用户账户的一个模板
 * @date 2021-10-22
 */
class Account {
    private int cid;
    private int cidPassword;
    private double balance;

    public String getInfo() {
        return "" + "cid(卡号): " + cid
                + "\n" + "balance(余额): "
                + balance + "（元）"+"\n";
    }

    public Account(int cid, int cidPassword) {
        this.cid = cid;
        this.cidPassword = cidPassword;
    }

    public void withDraw(double d1) {
        if (d1 < 100) {
            System.out.println("存钱失败!最少要100元");
        } else {
            balance += d1;
            System.out.println("存钱成功");
        }
        System.out.println(getInfo());
    }

    public void save(double d2) {
        if (d2 < balance) {
            balance -= d2;
            System.out.println("取钱成功");
            System.out.println(getInfo());
        } else {
            System.out.println("账户内金额小于取出的金额，无法取出");
        }
    }

    public int getCid() {
        return cid;
    }

    //没有提供给一个给用户修改密码的方法
    public void setCidPassword(int cidPassword) {
        this.cidPassword = cidPassword;
    }

    public int getCidPassword() {
        return cidPassword;
    }
}
