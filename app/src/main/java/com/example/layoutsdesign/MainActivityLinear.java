package com.example.layoutsdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivityLinear extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        linearLayout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);
    }

    public void fnChangeOrientation(View view)
    {
        if(linearLayout.getOrientation() == LinearLayout.HORIZONTAL)
        {
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            textView.setText("This is Vertical Linear Layout");

            
        }
        else if(linearLayout.getOrientation() == LinearLayout.VERTICAL)
        {
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            textView.setText("This is Horizontal Linear Layout");
        }
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
            return true;
        }
        else if(idMenu == R.id.relative)
        {
            intent = new Intent(this, MainActivityRelative.class);
        }
        else if(idMenu == R.id.constraint)
        {
            intent = new Intent(this, MainActivityLinear.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
