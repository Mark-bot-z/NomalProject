package com.javalow;

/**
 * @author Mark-Z
 * @version 0.1.0 该类作为生成用户的一个模板
 * @date 2021-10-22
 */
class Customer {
    private String name;
    private String address;
    private int IDnumber;
    private int phone;

    public Customer(String name, String address, int IDnumber, int phone) {
        this.name = name;
        this.address = address;
        this.IDnumber = IDnumber;
        this.phone = phone;
    }

    public String say() {
        return ""+ "姓名：" + name + "\n"
                 + "住址：" + address + "\n"
                 + "身份证号：" + IDnumber + "\n"
                 + "手机号：" + phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIDnumber() {
        return IDnumber;
    }
    //    //    (有异常未使用)
    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }
    //    (有异常未使用)
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
