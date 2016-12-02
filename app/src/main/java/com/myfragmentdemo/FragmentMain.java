package com.myfragmentdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class FragmentMain extends Fragment {
    ArrayAdapter<String> adapter;
    TextView editText;
    ListView lv = null;

    ArrayList<String> array = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_main, null);

        lv = (ListView) v.findViewById(R.id.list_main);
        lv.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, array));


        editText = (TextView) v.findViewById(R.id.list_main_list);

        array.add("Apple");
        array.add("Orange");
        array.add("Banana");
        array.add("Strawberry");
        array.add("Pineapple");

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity().getApplicationContext(), FragmentAdd.class);
                String message = array.get(position);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        return v;
    }


}
