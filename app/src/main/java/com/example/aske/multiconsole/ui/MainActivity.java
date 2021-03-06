package com.example.aske.multiconsole.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.example.aske.multiconsole.App;
import com.example.aske.multiconsole.R;
import com.example.aske.multiconsole.ui.adapter.VideogameAdapter;
import com.example.aske.multiconsole.ui.model.VideogameModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, VideogameAdapter.VideogameClickListener{
    @Inject
    MainContract.MainPresenter presenter;
    @Inject
    VideogameAdapter adapter;
    @Inject
    RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        initView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

        presenter.attachView(this);
        presenter.init(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    // ******
    // README
    // ******
    // Do not count on "onDestroy" method being called.
    // So lets detach view on "onPause" method.
    // It's important to check if activity is finishing to
    // ensure that we must detach view to avoid memory leaks.
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            presenter.detachView();
        }
    }



    @Override
    public void renderVideogames(List<VideogameModel> videogames) {
        adapter.setItems(videogames);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setmListener(this);
    }

    private void initView() {
        initRecyclerView();
    }

    @Override
    public void onClick(int position) {
        VideogameModel selectedVideogame = adapter.getVideoGame(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("idv", selectedVideogame.getId());
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), "CLICK: "+selectedVideogame.getTitulo(), Toast.LENGTH_SHORT).show();
    }
}
