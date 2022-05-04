package com.example.nasaapod.data;

import com.example.nasaapod.data.model.ApodImage;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApodService {

    /**
     *  api call to get the current APOD image
     *  */
    @GET("apod")
    Call<List<ApodImage>> apod(
            @Query("api_key") String api_key, @Query("count") int count
    );
}
