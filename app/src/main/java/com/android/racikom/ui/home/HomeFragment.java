package com.android.racikom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.racikom.MyAdapter;
import com.android.racikom.News;
import com.android.racikom.R;
import com.android.racikom.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();


        recyclerview = view.findViewById(R.id.rc);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(),newsArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        newsArrayList = new ArrayList<>();

        newsHeading = new String[]{

                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7),
                getString(R.string.head_8),

        };

        imageResourceID = new int[]{
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
        };
        for (int i =0; i< newsHeading.length; i++){

            News news = new News(newsHeading[i], imageResourceID[i]);
            newsArrayList.add(news);
        }
    }
}