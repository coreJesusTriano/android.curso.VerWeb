package com.example.verweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText webToShow;
    private String uriWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webToShow = findViewById(R.id.url);
    }

    public void goTo(View view){
        TextView advertencia = (TextView) findViewById(R.id.advertencia);
        this.uriWeb = this.webToShow.getText().toString();
        if (uriWeb.isEmpty()) {
            advertencia.setVisibility(View.VISIBLE);
        } else {
            advertencia.setVisibility(View.INVISIBLE);
            openActivityShowWeb();
        }
    }

    private void openActivityShowWeb(){
        Intent activWebShow = new Intent(this, ShowWebActivity.class);
        activWebShow.putExtra("direccion", this.uriWeb);
        startActivity(activWebShow);
    }

    public void closeApp(View view){
        finish();
    }
}