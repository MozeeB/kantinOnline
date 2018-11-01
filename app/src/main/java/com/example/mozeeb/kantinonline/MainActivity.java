package com.example.mozeeb.kantinonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.mozeeb.kantinonline.adapter.BarangAdapter;
import com.example.mozeeb.kantinonline.model.Barang;
import com.example.mozeeb.kantinonline.user.DetailsActivity;
import com.example.mozeeb.kantinonline.user.HistoryActivity;
import com.example.mozeeb.kantinonline.user.SettingActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //a list to store all the products
    List<Barang> productList;

    //the recyclerview
    public BarangAdapter dataAdapter;
    public RecyclerView recyclerView;
    public ArrayList<Barang> dataModelArrayList=new ArrayList<Barang>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Barang(
                        1,
                        "Teh Pucuk",
                        2.0,
                        "Harga Rp.50000",
                        R.drawable.pucuk));



        productList.add(
                new Barang(
                        1,
                        "Pocari Sweat",
                        5.0,
                        "Harga Rp.7000",
                        R.drawable.pocari));

        productList.add(
                new Barang(
                        1,
                        "Indomie Goreng",
                        2.0,
                        "Harga Rp.5000",
                        R.drawable.indomie));
        productList.add(
                new Barang(
                        2,
                        "Lasegar",
                        3.0,
                        "Harga Rp.6000",
                        R.drawable.lasegar));
        productList.add(
                new Barang(
                        3,
                        "Sari Roti",
                        7.0,
                        "Harga Rp.7000",
                        R.drawable.sario));
        productList.add(
                new Barang(
                        4,
                        "Beng Beng",
                        9.0,
                        "Harga Rp.5000",
                        R.drawable.beng));
        productList.add(
                new Barang(
                        5,
                        "Citato",
                        7.4,
                        "Harga Rp.7000",
                        R.drawable.citato));
        productList.add(
                new Barang(
                        6,
                        "Kusuka",
                        8.0,
                        "Harga Rp.8000",
                        R.drawable.kusuka));
        productList.add(
                new Barang(
                        7,
                        "Sprite",
                        6.0,
                        "Harga Rp.6000",
                        R.drawable.sprite));

        //creating recyclerview adapter
        BarangAdapter adapter = new BarangAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent h = new Intent(MainActivity.this, MainActivity.class);
            startActivity(h);
        } else if (id == R.id.nav_order) {
            Intent t = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(t);

        } else if (id == R.id.nav_setting) {
            Intent set = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(set);

        } else if (id == R.id.nav_logout) {
            Intent l = new Intent(MainActivity.this, Login.class);
            startActivity(l);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
