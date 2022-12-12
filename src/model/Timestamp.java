package model;

import java.util.Date;

public class Timestamp{

    private int seq;
    private int employeeid;
    private Date datetimelogin;
    private Date datetimelogout;

    public Timestamp(){

    }

    public Timestamp(int employeeid , Date datetimelogout){
        this.employeeid = employeeid;
        this.datetimelogout = datetimelogout;
    }

    public Timestamp(int employeeid , Date datetimelogin , Date datetimelogout){
        this.employeeid = employeeid;
        this.datetimelogin = datetimelogin;
        this.datetimelogout = datetimelogout;
    }

    public Timestamp(int seq , int employeeid , Date datetimelogin , Date datetimelogout){
        this.seq = seq;
        this.employeeid = employeeid;
        this.datetimelogin = datetimelogin;
        this.datetimelogout = datetimelogout;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }

    public Date getDateTimeLogIn() {
        return datetimelogin;
    }

    public void setDateTimeLogIn(Date datetimelogin) {
        this.datetimelogin = datetimelogin;
    }

    public Date getDateTimeLogOut() {
        return datetimelogout;
    }

    public void setDateTimeLogOut(Date datetimelogout) {
        this.datetimelogout = datetimelogout;
    }
}
