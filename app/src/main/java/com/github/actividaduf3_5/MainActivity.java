package com.github.actividaduf3_5;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    public static int TAM = 24;

    Button btnChangeSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeSize = findViewById(R.id.btnChangeSize);

        btnChangeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SizeDialog sd = new SizeDialog();
                sd.setCancelable(false);
                sd.show(getSupportFragmentManager(), "SizeDialog");
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, new InicioFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_Java:
                seeNewFragment(new JavaFragment());
                return true;
            case R.id.menu_Python:
                seeNewFragment(new PythonFragment());
                return true;
            case R.id.menu_Exit:
                seeExitMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void seeNewFragment(Fragment fr) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fr)
                .commit();
    }

    private void seeExitMenu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sure you want to exit?")
                .setPositiveButton("Yes", (dialog, id) -> finish())
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }



}