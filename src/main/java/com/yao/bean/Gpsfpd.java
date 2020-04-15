package com.yao.bean;

public class Gpsfpd {
    public String DateTime;
    public float Heading;
    public float Roll;
    public float Pitch;
    public double Latitude;
    public double Longitude;
    public float Altitude;
    public float Ve;
    public float Vn;
    public float Vu;
    public float Baseline;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public float getHeading() {
        return Heading;
    }

    public void setHeading(float heading) {
        Heading = heading;
    }

    public float getRoll() {
        return Roll;
    }

    public void setRoll(float roll) {
        Roll = roll;
    }

    public float getPitch() {
        return Pitch;
    }

    public void setPitch(float pitch) {
        Pitch = pitch;
    }

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

    public float getAltitude() {
        return Altitude;
    }

    public void setAltitude(float altitude) {
        Altitude = altitude;
    }

    public float getVe() {
        return Ve;
    }

    public void setVe(float ve) {
        Ve = ve;
    }

    public float getVn() {
        return Vn;
    }

    public void setVn(float vn) {
        Vn = vn;
    }

    public float getVu() {
        return Vu;
    }

    public void setVu(float vu) {
        Vu = vu;
    }

    public float getBaseline() {
        return Baseline;
    }

    public void setBaseline(float baseline) {
        Baseline = baseline;
    }

    @Override
    public String toString() {
        return "Gpsfpd{" +
                "DateTime='" + DateTime + '\'' +
                ", Heading=" + Heading +
                ", Roll=" + Roll +
                ", Pitch=" + Pitch +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Altitude=" + Altitude +
                ", Ve=" + Ve +
                ", Vn=" + Vn +
                ", Vu=" + Vu +
                ", Baseline=" + Baseline +
                '}';
    }
}
