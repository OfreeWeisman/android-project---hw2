package com.technion.android.mylists;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    ArrayList<String> inputs;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> input_texts) {
        super(context, R.layout.list_item, input_texts);
        inputs = input_texts;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView input_text = rowView.findViewById(R.id.input);
        TextView input_index = rowView.findViewById(R.id.index);

        input_text.setText(inputs.get(position));
        input_index.setText(String.valueOf(position + 1));

        return rowView;
    }
}
