package api.workflow;

import api.util.CommonUtils;
import api.util.Credential;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.concurrent.TimeUnit;

public class MainTest {

    static final String BASE_URL = CommonUtils.get(Credential.API_BASE_URL);

    static final okhttp3.OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }

}
