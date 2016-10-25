package com.example.aske.multiconsole.ui.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aske.multiconsole.R;
import com.example.aske.multiconsole.ui.model.VideogameModel;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by abasurto on 20/10/2016.
 */

public class VideogameAdapter extends RecyclerView.Adapter<VideogameAdapter.ViewHolder> {

    private List<VideogameModel> items;

    private VideogameClickListener mListener;

    @Inject
    public VideogameAdapter() {
        this.items = Collections.emptyList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideogameAdapter.ViewHolder holder, int position) {
        VideogameModel item = this.items.get(position);
        holder.title.setText(item.getTitulo());
        Resources res = holder.imageView.getResources();
        int resID = res.getIdentifier(item.getScreeshot() , "drawable", "com.example.aske.multiconsole");
        //holder.imageView.setImageResource(resID);

        int idDrawableNoImage = holder.imageView.getResources().getIdentifier("noimage", "drawable","com.example.aske.multiconsole");
        //int idDrawable = holder.imageView.getResources().getIdentifier(item.getScreeshot(), "drawable", "com.example.aske.multiconsole");

        if (resID == 0) resID = idDrawableNoImage;

        Picasso.with(holder.imageView.getContext())
                .load(resID)
                .placeholder(idDrawableNoImage)
                .error(idDrawableNoImage)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.items != null ? this.items.size() : 0;
    }

    public void setItems(List<VideogameModel> videogameList) {
        this.items = videogameList;
        notifyDataSetChanged();
    }

    public VideogameModel getVideoGame(int position) {
        return this.items.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.card_titulo)
        TextView title;
        @BindView(R.id.card_image)
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());
        }

    }

    public interface VideogameClickListener {
        void onClick(int position);
    }

    public VideogameClickListener getmListener() {
        return mListener;
    }

    public void setmListener(VideogameClickListener mListener) {
        this.mListener = mListener;
    }

}
