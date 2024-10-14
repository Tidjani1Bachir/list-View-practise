package com.example.tp3part2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


import com.example.tp3part2.Achat;
import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Achat> {
    private Activity context;
    private ArrayList<Achat> listAchats;

    public MyAdapter(@NonNull Context context, ArrayList<Achat> listAchats) {
        super(context, R.layout.ma_ligne, listAchats);
        this.context = (Activity) context;
        this.listAchats = listAchats;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.ma_ligne, null);
        }

        EditText editItem = convertView.findViewById(R.id.editItem);
        EditText editQte = convertView.findViewById(R.id.editQte);
        TextView itemName = convertView.findViewById(R.id.itemName1);
        TextView itemQte = convertView.findViewById(R.id.itemQte);
        Button editButton = convertView.findViewById(R.id.edit);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        final Achat achat = listAchats.get(position);
        itemName.setText(achat.getItem());
        itemQte.setText(String.valueOf(achat.getQte()));

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editItem.getText().toString();
                String newQteStr = editQte.getText().toString();

                // Check for valid input
                if (!newItem.isEmpty() && !newQteStr.isEmpty()) {
                    float newQte = Float.parseFloat(newQteStr);

                    // Make modifications to the object
                    achat.setItem(newItem);
                    achat.setQte(newQte);
                    notifyDataSetChanged();
                } else {
                    // Handle invalid input (show a message, etc.)
                    // For example:
                     //Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAchats.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public void addAchat(Achat achat) {
        listAchats.add(achat);
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }
}
