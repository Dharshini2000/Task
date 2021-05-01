package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private Button b1;
    private RecyclerView recyclerView;
    ArrayList<Article> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Methods methods= retrofit.getRetrofitInstance().create(Methods.class);
        Call<List<Integer>> call=methods.getTopStories();

        call.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                Log.e(TAG,"onResponse : code :"+response.code());
                List<Integer> topstories=response.body();
                for(int i=0;i<5;i++){
                    methods.getArticle(topstories.get(i)).enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response) {
                            Log.e(TAG,"onResponse :Title :"+response.body().getTitle().toString());

                            String title=response.body().getTitle().toString();
                            String url=response.body().getUrl().toString();

                            list.add(new Article(title,url));
                            RecyclerAdapter adapter=new RecyclerAdapter(list);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onFailure(Call<Model> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });

    }
}