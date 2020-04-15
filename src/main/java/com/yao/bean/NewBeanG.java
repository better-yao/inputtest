package com.yao.bean;

public class NewBeanG {
    public double X;
    public double Y;
    public float Heading;
    public String DateTime;
    public double Roll;
    public double Pitch;

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public float getHeading() {
        return Heading;
    }

    public void setHeading(float heading) {
        Heading = heading;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public double getRoll() {
        return Roll;
    }

    public void setRoll(double roll) {
        Roll = roll;
    }

    public double getPitch() {
        return Pitch;
    }

    public void setPitch(double pitch) {
        Pitch = pitch;
    }

    @Override
    public String toString() {
        return "NewBeanG{" +
                "X=" + X +
                ", Y=" + Y +
                ", Heading=" + Heading +
                ", DateTime='" + DateTime + '\'' +
                ", Roll=" + Roll +
                ", Pitch=" + Pitch +
                '}';
    }
}
