package com.neuedu.hr.business.entity;

public class Talent {

    private int talent_id;
    private String talent_name;
    private String talent_code;
    private String talent_status;
    private String talent_sexual;
    private String talent_identity;
    private String talent_dep;
    private String talent_pos;
    private String del_flag;


    @Override
    public String toString() {
        return "Talent{" +
                "talent_id=" + talent_id +
                ", talent_name='" + talent_name + '\'' +
                ", talent_code='" + talent_code + '\'' +
                ", talent_status='" + talent_status + '\'' +
                ", talent_sexual='" + talent_sexual + '\'' +
                ", talent_identity='" + talent_identity + '\'' +
                ", talent_dep='" + talent_dep + '\'' +
                ", talent_pos='" + talent_pos + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }

    public Talent() {
    }

    public int getTalent_id() {

        return talent_id;
    }

    public void setTalent_idd(int talent_id) {
        this.talent_id = talent_id;
    }

    public String getTalent_name() {
        return talent_name;
    }

    public void setTalent_name(String talent_name) {
        this.talent_name = talent_name;
    }

    public String getTalent_code() {
        return talent_code;
    }

    public void setTalent_code(String talent_code) {
        this.talent_code = talent_code;
    }

    public String getTalent_status() {
        return talent_status;
    }

    public void setTalent_status(String talent_status) {
        this.talent_status = talent_status;
    }

    public String getTalent_sexual() {
        return talent_sexual;
    }

    public void setTalent_sexual(String talent_sexual) {
        this.talent_sexual = talent_sexual;
    }

    public String getTalent_identity() {
        return talent_identity;
    }

    public void setTalent_identity(String talent_identity) {
        this.talent_identity = talent_identity;
    }

    public String getTalent_dep() {
        return talent_dep;
    }

    public void setTalent_dep(String talent_dep) {
        this.talent_dep = talent_dep;
    }

    public String getTalent_pos() {
        return talent_pos;
    }

    public void setTalent_pos(String talent_pos) {
        this.talent_pos = talent_pos;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public Talent(int talent_id, String talent_name, String talent_code, String talent_status, String talent_sexual, String talent_identity, String talent_dep, String talent_pos, String del_flag) {

        this.talent_id = talent_id;
        this.talent_name = talent_name;
        this.talent_code = talent_code;
        this.talent_status = talent_status;
        this.talent_sexual = talent_sexual;
        this.talent_identity = talent_identity;
        this.talent_dep = talent_dep;
        this.talent_pos = talent_pos;
        this.del_flag = del_flag;
    }
}
