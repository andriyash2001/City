package com.example.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.city.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout drawer;
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.placesView);
        array=getResources().getStringArray(R.array.places_array);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
Intent intent=new Intent(MainActivity.this,Text_Content_Activity.class);

intent.putExtra("category",category_index);
intent.putExtra("position",position);
startActivity(intent);

            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.places);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id==R.id.id_places)
        {
            toolbar.setTitle(R.string.places);
            array=getResources().getStringArray(R.array.places_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=0;
        }
        else if (id==R.id.id_about)
        {
            toolbar.setTitle(R.string.about);
            array=getResources().getStringArray(R.array.about_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=1;
        }
        else if (id==R.id.id_gallery)
        {
            toolbar.setTitle(R.string.gallery);
            Intent intent1= new Intent(MainActivity.this,Text_Content_Activity1.class);
            startActivity(intent1);
            //category_index=2;//
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}