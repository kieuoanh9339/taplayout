package com.oanhkieu.th2.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oanhkieu.th2.R;
import com.oanhkieu.th2.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    List<Song> songs;

    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override

    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SongViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.onBind(songs.get(position));
    }



    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder{

        private TextView txtSongName, txtSingerName, txtAlbum, txtType, txtIsLike;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongName= itemView.findViewById(R.id.txtSongName);
            txtSingerName= itemView.findViewById(R.id.txtSingerName);
            txtAlbum= itemView.findViewById(R.id.txtAlbum);
            txtType= itemView.findViewById(R.id.txtType);
            txtIsLike= itemView.findViewById(R.id.txtIsLike);
        }

        public void onBind(Song song){
            txtSongName.setText("Name song: "+song.getSongName());
            txtSingerName.setText("Singer: "+song.getSinger().getSingerName());
            txtAlbum.setText("Album: "+song.getAlbum());
            txtIsLike.setText("Like: "+(song.isLike()?"yes":"no"));
            txtType.setText("Type: "+song.getType());
        }
    }
}
