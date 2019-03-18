package com.example.layoutsdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivityRelative extends AppCompatActivity {


    ImageView imageViewRelative;
    TextView textViewRelative;
    Menu menu_layouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        imageViewRelative = findViewById(R.id.imageViewRelative);
        textViewRelative = findViewById(R.id.textViewRelative);
        //menu_layouts = findViewById(R.)
    }

    public void fnChangeRelative(View view)
    {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageViewRelative.getLayoutParams();
        params.addRule(RelativeLayout.BELOW, R.id.textViewRelative);
        imageViewRelative.setLayoutParams(params);

        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) textViewRelative.getLayoutParams();
        params2.addRule(RelativeLayout.BELOW, R.id.buttonRelative);
        textViewRelative.setLayoutParams(params2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layouts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idMenu = item.getItemId();
        Intent intent = null;

        if(idMenu == R.id.linear)
        {
            intent = new Intent(this, MainActivityLinear.class);
        }
        else if(idMenu == R.id.relative)
        {
            return true;
        }
        else if(idMenu == R.id.constraint)
        {
            intent = new Intent(this, MainActivity.class);
        }
        else if(idMenu == R.id.table)
        {
            intent = new Intent(this, MainActivityTable.class);
        }
        else if(idMenu == R.id.absolute)
        {
            intent = new Intent(this, MainActivityAbsolute.class);
        }
        else if(idMenu == R.id.frame)
        {
            intent = new Intent(this, MainActivityFrame.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
