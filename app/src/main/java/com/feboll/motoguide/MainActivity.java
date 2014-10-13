package com.feboll.motoguide;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
	private Cursor brandDB;
	private DBhelper db;
	ArrayList<String> brand = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
			//Достаем данные из базы по брендам
			db = new DBhelper(this);
			brandDB = db.getBrand(); // you would not typically call this on the main thread
			do{	brand.add(brandDB.getString(1));	} while (brandDB.moveToNext());
			brandDB.close();
			db.close();

			Display display = getWindowManager().getDefaultDisplay();

			GridView gridview = (GridView) findViewById(R.id.gridView);

			gridview.setAdapter(new GridAdapter(MainActivity.this, display.getWidth(), brand));

			gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
					Toast.makeText(MainActivity.this, brand.get(position), Toast.LENGTH_SHORT).show();
				}
			});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
