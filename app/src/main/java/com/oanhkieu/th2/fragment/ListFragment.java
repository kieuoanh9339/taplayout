package com.oanhkieu.th2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.oanhkieu.th2.Database;
import com.oanhkieu.th2.R;
import com.oanhkieu.th2.model.Song;

import java.util.List;

public class ListFragment extends Fragment {

    private View rootView;
    private Database database;
    private SongAdapter adapter;
    private RecyclerView rcv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_list,container, false);
//        database= new Database(requireContext());
//        List<Song> songs= database.getAllSong();
//        adapter = new SongAdapter(songs);
//        rcv=rootView.findViewById(R.id.rsvSong);
//        rcv.setAdapter(adapter);
        return rootView;
    }
}
