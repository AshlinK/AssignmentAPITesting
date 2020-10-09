package api;

import api.response.CitiesData;
import api.response.Weather;
import api.response.WeatherDetails;
import api.util.CommonUtils;
import api.util.Constants;
import api.util.Credential;
import api.workflow.MainTest;
import api.workflow.WeatherWorkflow;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class WeatherTest extends MainTest {
    private WeatherDetails weatherDetails;
    private WeatherWorkflow weatherWorkflow;
    private String cityName;
    private String apiKey;

    public WeatherTest() {
        weatherDetails = new WeatherDetails();
        weatherWorkflow = new WeatherWorkflow();
        cityName= CommonUtils.get(Credential.CITY_NAME);
        apiKey= CommonUtils.get(Credential.API_KEY);
    }

    @Test(enabled = true)
    public void getWeatherByCityName() throws IOException {
        /**
         *  Get the weather details based on the city name and verify if the status code is 200.
         */
        Response<WeatherDetails> response=weatherWorkflow.getWeatherCity(cityName,apiKey);
        Assert.assertEquals(response.code(),200,"Status code does not match");
        Assert.assertEquals(response.body().getName(),cityName,"City name does not match");
        Assert.assertEquals(response.body().getId(),2643743,"Id does not match");
        Assert.assertEquals(response.body().getCod(),200,"Cod does not match");

    }

    @Test(enabled = true)
    public void getWeatherByLatAndLng() throws IOException {
        /**
         * Get the weather details based on city name and then using the data in the response
         * body try to get the weather details based on latitude and longitude that came in
         * response. Compare both the responses.
         */
        Response<WeatherDetails> responseWeatherCity=weatherWorkflow.getWeatherCity(cityName,apiKey);
        Assert.assertEquals(responseWeatherCity.code(),200,"Status code does not match");

        WeatherDetails weatherDetailsCity=responseWeatherCity.body();
        Weather weatherCity=weatherDetailsCity.getWeather().get(0);

        double lat=weatherDetailsCity.getCoord().getLat();
        double lon=weatherDetailsCity.getCoord().getLon();

        Response<WeatherDetails> responseLatLon=weatherWorkflow.getWeatherLatLng(lat,lon,apiKey);
        Assert.assertEquals(responseLatLon.code(),200,"Status code does not match");

        WeatherDetails weatherDetailsLatLon=responseLatLon.body();
        Weather weatherLatLon=weatherDetailsLatLon.getWeather().get(0);

        Assert.assertEquals(weatherDetailsLatLon.getCoord().getLat(),lat,"Latitude does not match");
        Assert.assertEquals(weatherDetailsLatLon.getCoord().getLon(),lon,"Longitude does not match");
        Assert.assertEquals(weatherDetailsLatLon.getBase(),weatherDetailsCity.getBase(),"Base does not match");
        Assert.assertEquals(weatherDetailsLatLon.getName(),weatherDetailsCity.getName(),"City name does not match");
        Assert.assertEquals(weatherDetailsLatLon.getId(),weatherDetailsCity.getId(),"Id does not match");
        Assert.assertEquals(weatherDetailsLatLon.getCod(),weatherDetailsCity.getCod(),"Cod does not match");
        Assert.assertEquals(weatherDetailsLatLon.getVisibility(),weatherDetailsCity.getVisibility(),"Visibility does not match");
        Assert.assertEquals(weatherDetailsLatLon.getDt(),weatherDetailsCity.getDt(),"Dt does not match");

        Assert.assertEquals(weatherLatLon.getId(),weatherCity.getId(),"Weather id does not match");
        Assert.assertEquals(weatherLatLon.getMain(),weatherCity.getMain(),"Weather main does not match");
        Assert.assertEquals(weatherLatLon.getDescription(),weatherCity.getDescription(),"Weather description does not match");
        Assert.assertEquals(weatherLatLon.getIcon(),weatherCity.getIcon(),"Weather icon does not match");

        Assert.assertEquals(weatherDetailsLatLon.getMain().getTemp(),weatherDetailsCity.getMain().getTemp(),"Main Temp does not match");
        Assert.assertEquals(weatherDetailsLatLon.getMain().getTemp_min(),weatherDetailsCity.getMain().getTemp_min(),"Main Temp min does not match");
        Assert.assertEquals(weatherDetailsLatLon.getMain().getTemp_max(),weatherDetailsCity.getMain().getTemp_max(),"Main Temp max does not match");
        Assert.assertEquals(weatherDetailsLatLon.getMain().getFeels_like(),weatherDetailsCity.getMain().getFeels_like(),"Main Feel's like does not match");
        Assert.assertEquals(weatherDetailsLatLon.getMain().getHumidity(),weatherDetailsCity.getMain().getHumidity(),"Main humidity does not match");
        Assert.assertEquals(weatherDetailsLatLon.getMain().getPressure(),weatherDetailsCity.getMain().getPressure(),"Main Pressure does not match");

        Assert.assertEquals(weatherDetailsLatLon.getSys().getType(),weatherDetailsCity.getSys().getType(),"Sys type does not match");
        Assert.assertEquals(weatherDetailsLatLon.getSys().getId(),weatherDetailsCity.getSys().getId(),"Sys id does not match");
        Assert.assertEquals(weatherDetailsLatLon.getSys().getCountry(),weatherDetailsCity.getSys().getCountry(),"Sys country does not match");
        Assert.assertEquals(weatherDetailsLatLon.getSys().getSunrise(),weatherDetailsCity.getSys().getSunrise(),"Sys sunrise does not match");
        Assert.assertEquals(weatherDetailsLatLon.getSys().getSunset(),weatherDetailsCity.getSys().getSunset(),"Sys sunset does not match");
    }

    @Test(enabled = true)
    public void getCitiesInCircle() throws IOException{
        /**
         * Get the weather details on cities in a circle and validate whether the expected cities are
         * present in the response list or not. You can choose to pick any two cities nearby to each
         * other and make a request based on the static or hard coded latitude and longitude data
         * and validate whether those two cities are present in the list or not.
         */
        double lat= Constants.lat;
        double lon=Constants.lon;
        int cnt=Constants.cnt;
        String firstCity=Constants.firstCity;
        String secondCity=Constants.secondCity;

        Response<CitiesData> responseWeatherCity=weatherWorkflow.getWeatherCityInCircle(lat,lon,cnt,apiKey);
        Assert.assertEquals(responseWeatherCity.code(),200,"Status code does not match");

        CitiesData citiesData= responseWeatherCity.body();
        Assert.assertEquals(citiesData.getCount(),cnt,"Count does not match");

        List<WeatherDetails> weatherDetails=citiesData.getList();
        Assert.assertEquals(weatherDetails.size(),cnt,"List size does not match with count");
        Assert.assertEquals(weatherDetails.get(0).getName(),firstCity,"First city name does not match");
        Assert.assertEquals(weatherDetails.get(1).getName(),secondCity,"Second city name does not match");

    }

}
