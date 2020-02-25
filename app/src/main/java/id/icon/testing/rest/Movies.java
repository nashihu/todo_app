package id.icon.testing.rest;

import java.util.List;

import id.icon.testing.model.MainItem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Movies {
    //MOVIE SEARCH AUTOCOMPLETE
    @GET("/posts")
    Call<List<MainItem>> search();

    @POST("/posts/{id}")
    Call<String> edit(@Body() MainItem mainItem);

//    //TOP RATED MOVIES
//    @GET("movie/top_rated")
//    Call<MoviesResponse> topRated(@Query("api_key") String apiKey);
//
//    //MOVIE DETAIL
//    @GET("/3/movie/{id}")
//    Call<MovieResponse> movieDetails(@Path("id") int movieID, @Query("api_key") String apiKey);
//
//    //MOVIE IMAGES
//    @GET("/movie/{id}/images")
//    Call<ImagesResponse> movieImages(@Query("api_key") String apiKey, @Path("id") int movieID);
}