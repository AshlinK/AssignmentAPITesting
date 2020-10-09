package api.endpoint;

import api.response.CitiesData;
import api.response.WeatherDetails;
import retrofit2.Call;
import retrofit2.http.*;

public interface WeatherEndpoint {
    @GET("weather")
    Call<WeatherDetails> getWeatherCity(@Query("q") String cityName, @Query("appid") String apiKey);

    @GET("weather")
    Call<WeatherDetails> getWeatherLatLng(@Query("lat") double lat,@Query("lon") double lon,@Query("appid") String apiKey);

    @GET("find")
    Call<CitiesData> getWeatherCityInCircle(@Query("lat") double lat, @Query("lon") double lon, @Query("cnt") int cnt, @Query("appid") String apiKey);






}
