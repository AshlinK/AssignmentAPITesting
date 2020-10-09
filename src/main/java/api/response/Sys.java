package api.response;

public class Sys {
    private int type;
    private long id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    public int getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
