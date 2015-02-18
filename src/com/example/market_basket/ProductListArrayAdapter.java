package com.example.market_basket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * William Trent Holliday
 * 2/11/15
 */
public class ProductListArrayAdapter extends ArrayAdapter<Object> {

    private final Context context;
    private final ArrayList<Object> values;

    public ProductListArrayAdapter(Context context, ArrayList<Object> values) {
        super(context, R.layout.item_list, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_list, parent, false);
        TextView firstLine = (TextView) rowView.findViewById(R.id.firstLine);
        HashMap<String, String> listItem = ((HashMap) values.get(position));
        firstLine.setText(listItem.get("name"));
        TextView secondLine = (TextView) rowView.findViewById(R.id.secondLine);
        secondLine.setText(listItem.get("desc"));

        return rowView;
    }

}
