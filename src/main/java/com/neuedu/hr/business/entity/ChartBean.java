package com.neuedu.hr.business.entity;

public class ChartBean {
    private String name;
    private int count;

    public ChartBean(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public ChartBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ChartBean{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
