package com.yao.bean;

public class Windsensor {
    public String DateTime;
    public float windspeed;
    public float winddir;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public float getWinddir() {
        return winddir;
    }

    public void setWinddir(float winddir) {
        this.winddir = winddir;
    }

    @Override
    public String toString() {
        return "Windsensor{" +
                "DateTime='" + DateTime + '\'' +
                ", windspeed=" + windspeed +
                ", winddir=" + winddir +
                '}';
    }
}
