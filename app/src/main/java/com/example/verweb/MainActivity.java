package com.example.verweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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

        EventoTeclado eTeclado = new EventoTeclado();
        webToShow.setOnEditorActionListener(eTeclado);
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

    public class EventoTeclado implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i== EditorInfo.IME_ACTION_SEND){
                goTo(null);
            }
            return false;
        }

/*        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i== EditorInfo.IME_ACTION_DONE){
                reset(null);
            }
            return false;
        }*/
    }
}