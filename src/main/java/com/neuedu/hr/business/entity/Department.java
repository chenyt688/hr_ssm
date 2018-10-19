package com.neuedu.hr.business.entity;

public class Department {
    private int depart_id;
    private String depart_name;
    private String depart_code;
    private String depart_phone;
    private String del_flag;

    @Override
    public String toString() {
        return "Department{" +
                "depart_id=" + depart_id +
                ", depart_name='" + depart_name + '\'' +
                ", depart_code='" + depart_code + '\'' +
                ", depart_phone='" + depart_phone + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }

    public int getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(int depart_id) {
        this.depart_id = depart_id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getDepart_code() {
        return depart_code;
    }

    public void setDepart_code(String depart_code) {
        this.depart_code = depart_code;
    }

    public String getDepart_phone() {
        return depart_phone;
    }

    public void setDepart_phone(String depart_phone) {
        this.depart_phone = depart_phone;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public Department() {

    }

    public Department(int depart_id, String depart_name, String depart_code, String depart_phone, String del_flag) {

        this.depart_id = depart_id;
        this.depart_name = depart_name;
        this.depart_code = depart_code;
        this.depart_phone = depart_phone;
        this.del_flag = del_flag;
    }
}
