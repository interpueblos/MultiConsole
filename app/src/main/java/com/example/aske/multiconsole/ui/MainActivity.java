package com.example.aske.multiconsole.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.aske.multiconsole.App;
import com.example.aske.multiconsole.R;
import com.example.aske.multiconsole.ui.adapter.VideogameAdapter;
import com.example.aske.multiconsole.ui.model.VideogameModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.MainView{
    @Inject
    MainContract.MainPresenter presenter;
    @Inject
    VideogameAdapter adapter;
    @Inject
    RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        initView();
        presenter.attachView(this);
        presenter.init(this);
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
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        initRecyclerView();
    }
}
