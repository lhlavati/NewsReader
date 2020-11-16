package luka.ferit.newsreader.retrofit;

import java.util.List;

import luka.ferit.newsreader.model.Article;
import luka.ferit.newsreader.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("articles")
    Call<Response> getAllArticles(
            @Query("source") String source,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey);
}
