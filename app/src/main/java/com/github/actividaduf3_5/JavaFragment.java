package com.github.actividaduf3_5;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class JavaFragment extends Fragment {

    TextView tv;

    public JavaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_java, container, false);

        tv = view.findViewById(R.id.tvJava);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, MainActivity.TAM);

        return view;
    }
}