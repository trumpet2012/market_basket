package com.example.market_basket;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.HashMap;

/**
 * William Trent Holliday
 * 2/3/15
 */
public class ProductDetailActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("position");

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setText("Product detail for the item at position " + message);

        // Set the text view as the activity layout
        setContentView(textView);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        // Handle presses on the action bar items
        switch( item.getItemId()){
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openSearch(){
        TextView searchView = new TextView(this);
        searchView.setText("Search");
        setContentView(searchView);
    }

    public void openSettings(){
        TextView settingsView = new TextView(this);
        settingsView.setText("Settings");
        setContentView(settingsView);
    }
}