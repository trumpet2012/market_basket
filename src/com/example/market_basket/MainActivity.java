package com.example.market_basket;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.market_basket.MESSAGE";
    private ArrayList<Object> productList;
    private String[] navDrawerItems = {"Products", "Orders", "Cart"};
    private ActionBarDrawerToggle drawerToggle;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView navDrawerList = (ListView) findViewById(R.id.left_menu);

        navDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navDrawerItems));
        navDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked " + navDrawerItems[position], Toast.LENGTH_SHORT).show();
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_drawer, R.string.open_drawer, R.string.close_drawer){
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(R.string.app_name);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("Menu");
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // Populate the product list
        productList = new ArrayList<Object>();
        HashMap<String, String> firstItem = new HashMap<String, String>();
        firstItem.put("name", "First product");
        firstItem.put("desc", "This is the first product");
        productList.add(firstItem);

        HashMap<String, String> secondItem = new HashMap<String, String>();
        secondItem.put("name", "Second product");

        secondItem.put("desc", "This is the second product");
        productList.add(secondItem);

        ListView listView = (ListView) findViewById(R.id.product_list);
        ProductListArrayAdapter listAdapter = new ProductListArrayAdapter(this, productList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked " + position + " item.", Toast.LENGTH_SHORT).show();
                Intent detailIntent = new Intent(MainActivity.this, ProductDetailActivity.class);

                detailIntent.putExtra("position", String.valueOf(position));
                MainActivity.this.startActivity(detailIntent);
            }
        });
    }

    public HashMap<String, String> getProductItem(int productPosition) {
        return (HashMap<String, String>) productList.get(productPosition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch(id){
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search clicked", Toast.LENGTH_SHORT).show();
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings clicked", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
