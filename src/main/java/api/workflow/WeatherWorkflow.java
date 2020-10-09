package api.workflow;

import api.endpoint.WeatherEndpoint;
import api.response.CitiesData;
import api.response.WeatherDetails;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;


public class WeatherWorkflow extends MainTest {

    protected WeatherEndpoint service;

    public WeatherWorkflow() {
        this.service = createService(WeatherEndpoint.class);
    }

    public Response<WeatherDetails> getWeatherCity(String cityName, String apiKey) throws IOException {
        Call<WeatherDetails> call = service.getWeatherCity(cityName, apiKey);
        return call.execute();
    }

    public Response<WeatherDetails> getWeatherLatLng(double lat,double lon,String apikey) throws IOException{
        Call<WeatherDetails> call=service.getWeatherLatLng(lat,lon,apikey);
        return call.execute();
    }

    public Response<CitiesData> getWeatherCityInCircle(double lat, double lon, int cnt, String apikey) throws IOException{
        Call<CitiesData> call=service.getWeatherCityInCircle(lat,lon,cnt,apikey);
        return call.execute();
    }

}
