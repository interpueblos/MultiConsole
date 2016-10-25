package com.example.aske.multiconsole.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aske.multiconsole.App;
import com.example.aske.multiconsole.R;
import com.example.aske.multiconsole.data.entities.Videogame;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by abasurto on 24/10/2016.
 */

public class DetailActivity extends AppCompatActivity implements DetailContract.DetailView{
    @Inject
    DetailContract.DetailPresenter presenter;
    @BindView(R.id.detail_image)
    ImageView screenshot;
    @BindView(R.id.detail_titulo)
    TextView titulo;
    @BindView(R.id.detail_descripcion)
    TextView descripcion;
    @BindView(R.id.detail_compania)
    TextView compania;
    @BindView(R.id.detail_plataforma)
    TextView plataforma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ((App) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        int idv = 1;
        if(b!=null)
        {
            idv =b.getInt("idv");
            //idv = (new Integer(j)).intValue();
        }

        presenter.attachView(this);
        presenter.init(this, idv);
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
    public void renderVideogame(Videogame videogame) {
        int idDrawableNoImage = this.getResources().getIdentifier("noimage", "drawable", this.getPackageName());
        int idDrawable = this.getResources().getIdentifier(videogame.getScreenshot(), "drawable", this.getPackageName());

        if (idDrawable == 0) idDrawable = idDrawableNoImage;

        Picasso.with(this)
                .load(idDrawable)
                .placeholder(idDrawableNoImage)
                .error(idDrawableNoImage)
                .into(screenshot);
        titulo.setText(videogame.getTitulo() + "(" + videogame.getFecha() + ")");
        descripcion.setText(videogame.getDescripcion());
        compania.setText(videogame.getCompañia());
        plataforma.setText(videogame.getPlataforma());
    }

}
