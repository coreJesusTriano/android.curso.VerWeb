package com.example.verweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowWebActivity extends AppCompatActivity {

    String web;
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_web);
        myWebView = (WebView) findViewById(R.id.webView);
        // Recuperamos la web a la que queremos ir
        Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                this.web = bundle.getString("direccion");
            } else {
                this.web = "google.es";
            }
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://"+this.web);
    }


    public void close(View view) {
        finish();
    }
}