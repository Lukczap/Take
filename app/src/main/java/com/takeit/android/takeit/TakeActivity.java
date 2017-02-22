package com.takeit.android.takeit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TakeActivity extends Activity {
    Spinner SPINNER;
    Button ADD;
    Button REMOVE;
    EditText EDITTEXT;
    String[] spinnerItems = new String[]{
            "ANDROID",
            "PHP"

    };
    String GETTEXT;
    List<String> stringlist;
    ArrayAdapter<String> arrayadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take);

        SPINNER = (Spinner)findViewById(R.id.spinner);
        ADD = (Button)findViewById(R.id.button);
        REMOVE = (Button)findViewById(R.id.button1);
        EDITTEXT = (EditText)findViewById(R.id.editText);

        stringlist = new ArrayList<>(Arrays.asList(spinnerItems));

        arrayadapter = new ArrayAdapter<>(TakeActivity.this, R.layout.textview, stringlist );

        arrayadapter.setDropDownViewResource(R.layout.textview);

        SPINNER.setAdapter(arrayadapter);

        ADD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GETTEXT = EDITTEXT.getText().toString();

                stringlist.add(GETTEXT);

                arrayadapter.notifyDataSetChanged();

                Toast.makeText(TakeActivity.this, "Item Added", Toast.LENGTH_LONG).show();
            }
        });

        REMOVE.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                arrayadapter.remove((String)SPINNER.getSelectedItem());
                arrayadapter.notifyDataSetChanged();

                Toast.makeText(TakeActivity.this, "Item Removed", Toast.LENGTH_LONG).show();
            }

        });
    }
}
