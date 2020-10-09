package api.response;

import java.util.List;

public class CitiesData {
    private String message;
    private int cod;
    private int count;
    private List<WeatherDetails> list;

    public String getMessage() {
        return message;
    }

    public int getCod() {
        return cod;
    }

    public int getCount() {
        return count;
    }

    public List<WeatherDetails> getList() {
        return list;
    }
}
