package com.example.layoutsdesign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityFrame extends AppCompatActivity {

    EditText editTextFrame;
    TextView textViewFrame;
    ImageView imageViewFrame;
    Bitmap bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

        editTextFrame = findViewById(R.id.editTextFrame);
        textViewFrame = findViewById(R.id.textViewFrame);
        imageViewFrame = findViewById(R.id.imageViewFrame);
    }

    public void fnTakePic(View view)
    {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String strName = editTextFrame.getText().toString();
                        textViewFrame.setText("This is frame layout " + strName + " and you have changed your background");
                    }
                });
            }
        };

        Thread thr = new Thread(run);
        thr.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        bp = (Bitmap) data.getExtras().get("data");
        imageViewFrame.setImageBitmap(bp);

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
            intent = new Intent(this, MainActivityRelative.class);
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
            return true;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
