package com.example.suijifront.ui.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.suijifront.CsTableActivity;
import com.example.suijifront.R;
import com.example.suijifront.TodoAddActivity;

public class TodoFragment extends Fragment {

    private TodoViewModel todoViewModel;
    private Button todo_add;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        todo_add=(Button) view.findViewById(R.id.todo_add);
        todo_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TodoAddActivity.class);
                startActivity(intent);
            }
        });
        final TextView textView = view.findViewById(R.id.title2);
        todoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }
}