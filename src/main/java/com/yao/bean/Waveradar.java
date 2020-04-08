package com.yao.bean;

public class Waveradar {
    public String DateTime;
    public float HDiv3;
    public float TDiv3;
    public float Hm0;
    public float Tm02;
    public float Hmax;
    public float H10;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public float getHDiv3() {
        return HDiv3;
    }

    public void setHDiv3(float HDiv3) {
        this.HDiv3 = HDiv3;
    }

    public float getTDiv3() {
        return TDiv3;
    }

    public void setTDiv3(float TDiv3) {
        this.TDiv3 = TDiv3;
    }

    public float getHm0() {
        return Hm0;
    }

    public void setHm0(float hm0) {
        Hm0 = hm0;
    }

    public float getTm02() {
        return Tm02;
    }

    public void setTm02(float tm02) {
        Tm02 = tm02;
    }

    public float getHmax() {
        return Hmax;
    }

    public void setHmax(float hmax) {
        Hmax = hmax;
    }

    public float getH10() {
        return H10;
    }

    public void setH10(float h10) {
        H10 = h10;
    }

    @Override
    public String toString() {
        return "Waveradar{" +
                "DateTime='" + DateTime + '\'' +
                ", HDiv3=" + HDiv3 +
                ", TDiv3=" + TDiv3 +
                ", Hm0=" + Hm0 +
                ", Tm02=" + Tm02 +
                ", Hmax=" + Hmax +
                ", H10=" + H10 +
                '}';
    }
}
