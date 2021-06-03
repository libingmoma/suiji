package com.example.suijifront.ui.course;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.suijifront.CsContentActivity;
import com.example.suijifront.CsTableActivity;
import com.example.suijifront.JitangActivity;
import com.example.suijifront.MainActivity;
import com.example.suijifront.R;

public class CourseFragment extends Fragment {

    private CourseViewModel courseViewModel;
    private Button courseTableCheck;
    private Button course1;

    public View onCreateView( @NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        courseTableCheck=(Button) view.findViewById(R.id.courseTableCheck);
        courseTableCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CsTableActivity.class);
                startActivity(intent);
            }
        });

        course1=(Button) view.findViewById(R.id.course1);
        course1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CsContentActivity.class);
                startActivity(intent);
            }
        });


        final TextView textView = view.findViewById(R.id.title1);
//        courseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;
    }

}