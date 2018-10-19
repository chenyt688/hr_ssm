package com.neuedu.hr.business.entity;

public class RoleAndMenu {
    private String  role_code;
    private String menu_code;
    private char power; //用户权限状态 1表示拥有权限，反之用0表示

    public RoleAndMenu(String role_code, String menu_code, char power) {
        this.role_code = role_code;
        this.menu_code = menu_code;
        this.power = power;
    }

    public RoleAndMenu() {
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public char getPower() {
        return power;
    }

    public void setPower(char power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "RoleAndMenu{" +
                "role_code='" + role_code + '\'' +
                ", menu_code='" + menu_code + '\'' +
                ", power=" + power +
                '}';
    }
}
