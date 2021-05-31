package com.example.suijifront.ui.myself;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.suijifront.R;

public class MyselfFragment extends Fragment {

    private MyselfViewModel myselfViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myselfViewModel =
                new ViewModelProvider(this).get(MyselfViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myself, container, false);
        final TextView textView = root.findViewById(R.id.tv_name);
        myselfViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}