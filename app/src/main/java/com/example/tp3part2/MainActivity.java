package com.example.tp3part2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    ListView list;
    MyAdapter adapter;
    ArrayList<Achat> data = new ArrayList<>();
    EditText itemName;
    EditText itemQte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemName = findViewById(R.id.input);
        itemQte = findViewById(R.id.input1);

        // FrameLayout container = findViewById(R.id.container);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.input);
        list = findViewById(R.id.list);
// costum item to show
        data.add(new Achat("Farine", 10));

        // Corrected to use MyAdapter instead of ArrayAdapter
        adapter = new MyAdapter(this, data);
        list.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = itemName.getText().toString();
                String inputQteText = itemQte.getText().toString();

                try {
                    double input = Double.parseDouble(inputQteText);
                    adapter.addAchat(new Achat(inputText, input));
                } catch (NumberFormatException e) {
                    // Handle the error, for example by showing a toast or logging
                    e.printStackTrace(); // Print the stack trace for debugging
                }
            }
        });

    }
}