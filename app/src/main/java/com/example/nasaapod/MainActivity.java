package com.example.nasaapod;

import android.os.Bundle;

import com.example.nasaapod.data.ApodService;
import com.example.nasaapod.data.model.ApodImage;
import com.example.nasaapod.databinding.CardRecyclerBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CardRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CardRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /**
         * TODO: add recyclerView binding
         */
        RecyclerView cardRecycler = binding.recyclerView;


        int spanCount = 2;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
        /**
         * TODO: call setLayoutManager method on cardRecycler to set gridLayoutManager from above
         */
        cardRecycler.setLayoutManager(gridLayoutManager);

        /**
         * TODO: create ApodAdapter with context parameter
         */
        ApodRecyclerAdapter apodAdapter = new ApodRecyclerAdapter(this, new ArrayList<>());

        /**
         * TODO: call setAdapter method on cardRecycler to set apodAdapter
         */
        cardRecycler.setAdapter(apodAdapter);

        /**
         * TODO: replace null with method call
         */
        Call<List<ApodImage>> imagesCall = getImageListFromAPI();

        imagesCall.enqueue(new Callback<List<ApodImage>>() {
            @Override
            public void onResponse(Call<List<ApodImage>> call, Response<List<ApodImage>> response) {

                List<ApodImage> apodImageList = response.body();
                /*
                TODO: call setImages method on adapter with list returned from response body
                 */
                apodAdapter.setImagelist(
                        apodImageList
                );

                /*
                TODO: call notifyDataSetChanged to update recyclerview
                 */
                apodAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailure(Call<List<ApodImage>> call, Throwable t) {}
        });
    }

    private Call<List<ApodImage>> getImageListFromAPI() {

        String apiKey = "DEMO_KEY";
        int APOD_COUNT = 30;

        Retrofit retrofit = new Retrofit
                .Builder()
                /* add Gson */
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.nasa.gov/planetary/")
                .build();

        ApodService apodService = retrofit.create(ApodService.class);
        Call<List<ApodImage>> call = apodService.apod(apiKey, APOD_COUNT);

        return call;
    }
}