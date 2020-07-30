package com.example.android.quakereport;

public class earthquake {
    private double mag;
    private String loc;
    private String dat;
    private String tim;
    private String url;

    public earthquake(double magnitude, String location, String date, String time, String Url)
    {
        mag=magnitude;
        loc=location;
        dat=date;
        tim=time;
        url=Url;
    }

    public String getUrl() { return url; }

    public String getTim() { return tim; }

    public String getDat() {
        return dat;
    }

    public String getLoc() {
        return loc;
    }

    public double getMag() {
        return mag;
    }
}
