package com.neuedu.hr.business.entity;

public class Position {
    private int pos_id;
    private String pos_name;
    private String pos_code;
    private double pos_salary;
    private String del_flag;

    @Override
    public String toString() {
        return "Position{" +
                "pos_id=" + pos_id +
                ", pos_name='" + pos_name + '\'' +
                ", pos_code='" + pos_code + '\'' +
                ", pos_salary=" + pos_salary +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }

    public Position() {
    }

    public int getPos_id() {

        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public String getPos_code() {
        return pos_code;
    }

    public void setPos_code(String pos_code) {
        this.pos_code = pos_code;
    }

    public double getPos_salary() {
        return pos_salary;
    }

    public void setPos_salary(double pos_salary) {
        this.pos_salary = pos_salary;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public Position(int pos_id, String pos_name, String pos_code, double pos_salary, String del_flag) {

        this.pos_id = pos_id;
        this.pos_name = pos_name;
        this.pos_code = pos_code;
        this.pos_salary = pos_salary;
        this.del_flag = del_flag;
    }
}
