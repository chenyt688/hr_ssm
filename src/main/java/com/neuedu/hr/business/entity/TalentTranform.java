package com.neuedu.hr.business.entity;

public class TalentTranform {
    private int id;
    private String in_depart_name;
    private String in_pos_name;
    private String talent_code;
    private String tran_date;
    private String del_flag;

    public TalentTranform(int id, String in_depart_name, String in_pos_name, String talent_code, String tran_date, String del_flag) {
        this.id = id;
        this.in_depart_name = in_depart_name;
        this.in_pos_name = in_pos_name;
        this.talent_code = talent_code;
        this.tran_date = tran_date;
        this.del_flag = del_flag;
    }

    public TalentTranform() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIn_depart_name() {
        return in_depart_name;
    }

    public void setIn_depart_name(String in_depart_name) {
        this.in_depart_name = in_depart_name;
    }

    public String getIn_pos_name() {
        return in_pos_name;
    }

    public void setIn_pos_name(String in_pos_name) {
        this.in_pos_name = in_pos_name;
    }

    public String getTalent_code() {
        return talent_code;
    }

    public void setTalent_code(String talent_code) {
        this.talent_code = talent_code;
    }

    public String getTran_date() {
        return tran_date;
    }

    public void setTran_date(String tran_date) {
        this.tran_date = tran_date;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }
}
