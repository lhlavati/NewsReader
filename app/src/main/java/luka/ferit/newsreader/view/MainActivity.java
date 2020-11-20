package luka.ferit.newsreader.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import luka.ferit.newsreader.adapter.PagerAdapter;
import luka.ferit.newsreader.fragment.PagerFragment;
import luka.ferit.newsreader.model.Response;
import luka.ferit.newsreader.retrofit.GetDataService;
import luka.ferit.newsreader.R;
import luka.ferit.newsreader.retrofit.RetrofitClientInstance;
import luka.ferit.newsreader.adapter.CustomAdapter;
import luka.ferit.newsreader.model.Article;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private static final String API_KEY = "77caa7c5e2064432b06dcb1ed951c2b0";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Response> call = service.getAllArticles("bbc-news", "top", API_KEY);
        call.enqueue(new Callback<Response>() {

            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                progressDialog.dismiss();
                generateDataList(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Ups, something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<Article> articleList) {
        recyclerView = findViewById(R.id.rvNews);
        adapter = new CustomAdapter(this, articleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}