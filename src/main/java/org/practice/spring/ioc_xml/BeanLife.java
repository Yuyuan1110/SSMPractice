package org.practice.spring.ioc_xml;

public class BeanLife {
    private int bid;
    private String bname;

    public BeanLife() {
        System.out.println("LifeCycle1: Instance");
    }

    public BeanLife(int bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        System.out.println("LifeCycle2: DI");
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "BeanLife{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }

    public void initMethod(){
        System.out.println("LifeCycle3: init");
    }

    public void destroyMethod(){
        System.out.println("LifeCycle4: destroy");
    }
}
