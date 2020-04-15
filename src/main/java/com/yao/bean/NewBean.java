package com.yao.bean;

public class NewBean {
    public double Latitude;
    public double Longitude;
    public float Heading;
    public String DateTime;
    public double Roll;
    public double Pitch;

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
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
        return "NewBean{" +
                "Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Heading=" + Heading +
                ", DateTime='" + DateTime + '\'' +
                ", Roll=" + Roll +
                ", Pitch=" + Pitch +
                '}';
    }
}
