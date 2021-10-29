package com.icanerdogan.appvideogamesjavav1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.icanerdogan.appvideogamesjavav1.adapter.RecyclerViewAdapter;
import com.icanerdogan.appvideogamesjavav1.databinding.FragmentHomeBinding;
import com.icanerdogan.appvideogamesjavav1.model.BaseModel;
import com.icanerdogan.appvideogamesjavav1.model.GameModel;
import com.icanerdogan.appvideogamesjavav1.model.RetrofitModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    //Recycler Adapter
    RecyclerViewAdapter rAdapter;

    //Retrofit Model
    RetrofitModel retrofitModel = new RetrofitModel();

    // Recycler View
    RecyclerView recyclerView;

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.gameRecyclerView;

        retrofitModel.loadData(getActivity(), recyclerView);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
