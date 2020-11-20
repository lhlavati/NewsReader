package luka.ferit.newsreader.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import luka.ferit.newsreader.R;
import luka.ferit.newsreader.model.Article;
import luka.ferit.newsreader.view.MainActivity;

public class PagerFragment extends Fragment {

    private ImageView imageSingle;
    private TextView titleSingle;
    private TextView descSingle;
    private Context context;
    Article data = new Article();

    public PagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        titleSingle = view.findViewById(R.id.titleSingle);
        descSingle = view.findViewById(R.id.descSingle);
        imageSingle = view.findViewById(R.id.imageSingle);

        titleSingle.setText(data.getTitle());
        descSingle.setText(data.getDescription());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        try {
            imageSingle.setImageBitmap(drawable_from_url(data.getUrlToImage()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    private Bitmap drawable_from_url(String url) throws java.io.IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(url) .openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        return BitmapFactory.decodeStream(input);
    }
}