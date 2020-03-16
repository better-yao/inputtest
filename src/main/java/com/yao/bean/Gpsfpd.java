package com.yao.bean;

public class Gpsfpd {
    public String DateTime;
    public Float Heading;
    public Float Roll;
    public Float Pitch;
    public Float Latitude;
    public Float Longitude;
    public Float Altitude;
    public Float Ve;
    public Float Vn;
    public Float Vu;
    public Float Baseline;
    public Float spmx;
    public Float spmy;
    public Float spmz;
    public Float aftx;
    public Float afty;
    public Float aftz;
    public Float sway;
    public Float surge;
    public Float heave;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public Float getHeading() {
        return Heading;
    }

    public void setHeading(Float heading) {
        Heading = heading;
    }

    public Float getRoll() {
        return Roll;
    }

    public void setRoll(Float roll) {
        Roll = roll;
    }

    public Float getPitch() {
        return Pitch;
    }

    public void setPitch(Float pitch) {
        Pitch = pitch;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    public Float getAltitude() {
        return Altitude;
    }

    public void setAltitude(Float altitude) {
        Altitude = altitude;
    }

    public Float getVe() {
        return Ve;
    }

    public void setVe(Float ve) {
        Ve = ve;
    }

    public Float getVn() {
        return Vn;
    }

    public void setVn(Float vn) {
        Vn = vn;
    }

    public Float getVu() {
        return Vu;
    }

    public void setVu(Float vu) {
        Vu = vu;
    }

    public Float getBaseline() {
        return Baseline;
    }

    public void setBaseline(Float baseline) {
        Baseline = baseline;
    }

    public Float getSpmx() {
        return spmx;
    }

    public void setSpmx(Float spmx) {
        this.spmx = spmx;
    }

    public Float getSpmy() {
        return spmy;
    }

    public void setSpmy(Float spmy) {
        this.spmy = spmy;
    }

    public Float getSpmz() {
        return spmz;
    }

    public void setSpmz(Float spmz) {
        this.spmz = spmz;
    }

    public Float getAftx() {
        return aftx;
    }

    public void setAftx(Float aftx) {
        this.aftx = aftx;
    }

    public Float getAfty() {
        return afty;
    }

    public void setAfty(Float afty) {
        this.afty = afty;
    }

    public Float getAftz() {
        return aftz;
    }

    public void setAftz(Float aftz) {
        this.aftz = aftz;
    }

    public Float getSway() {
        return sway;
    }

    public void setSway(Float sway) {
        this.sway = sway;
    }

    public Float getSurge() {
        return surge;
    }

    public void setSurge(Float surge) {
        this.surge = surge;
    }

    public Float getHeave() {
        return heave;
    }

    public void setHeave(Float heave) {
        this.heave = heave;
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
                ", spmx=" + spmx +
                ", spmy=" + spmy +
                ", spmz=" + spmz +
                ", aftx=" + aftx +
                ", afty=" + afty +
                ", aftz=" + aftz +
                ", sway=" + sway +
                ", surge=" + surge +
                ", heave=" + heave +
                '}';
    }

}
