package api.response;

import java.util.List;

public class WeatherDetails {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Wind wind;
    private int visibility;
    private Cloud clouds;
    private long dt;
    private Sys sys;
    private long id;
    private long timezone;
    private String name;
    private int cod;

    public int getVisibility() {
        return visibility;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public long getId() {
        return id;
    }

    public long getTimezone() {
        return timezone;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
