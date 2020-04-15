package com.yao.bean;

public class OneTest {
    public String DateTime;
    public double X;
    public double Y;
    public double utmzone;
    public double altitude;
    public double heading;
    public double roll;
    public double pitch;

    public String getDateTime() {
        return DateTime;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

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

    public double getUtmzone() {
        return utmzone;
    }

    public void setUtmzone(double utmzone) {
        this.utmzone = utmzone;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "OneTest{" +
                "DateTime='" + DateTime + '\'' +
                ", X=" + X +
                ", Y=" + Y +
                ", utmzone=" + utmzone +
                ", altitude=" + altitude +
                '}';
    }
}
