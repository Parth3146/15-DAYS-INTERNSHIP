package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUrl;
    Button btnGo;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        etUrl = findViewById(R.id.etUrl);
        btnGo = findViewById(R.id.btnGo);
        wv = findViewById(R.id.wv);

        btnGo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnGo:
                String url = etUrl.getText().toString();
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new MyWebViewClint());
                wv.loadUrl(url);
                break;
        }
    }

    private class MyWebViewClint extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}