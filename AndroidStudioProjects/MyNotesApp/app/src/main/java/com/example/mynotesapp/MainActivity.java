package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mynotesapp.adapter.MyNewArrayAdapter;
import com.example.mynotesapp.model.Reminder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private EditText etAddRem;

    private ImageButton btnImgAdd;

    private ListView listView;

    private ArrayList<Reminder> myArrayList;

    private ArrayList<String> myArrayList1;

    private MyNewArrayAdapter myNewArrayAdapter;

    private Reminder reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    private void init()
    {
        etAddRem = findViewById(R.id.et_add_reminder);
        btnImgAdd = findViewById(R.id.add_reminder);

        myArrayList = new ArrayList<>();

       // String rem = "This is the first reminder";
        myArrayList1 = new ArrayList<>();
       // myArrayList1.add(rem);

        reminder = new Reminder("First Reminder","10:00 pm");
        myArrayList.add(reminder);

        myNewArrayAdapter = new MyNewArrayAdapter(this,R.layout.list_tem, myArrayList1);

        listView = findViewById(R.id.list_view);

        listView.setAdapter(myNewArrayAdapter);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.add_reminder)
        {
            Log.d(TAG, "onClick: clicked image");
            if(!etAddRem.getText().toString().isEmpty())
            {
                myArrayList1.add(etAddRem.getText().toString());

                myNewArrayAdapter.notifyDataSetChanged();
            }
        }
    }
}
