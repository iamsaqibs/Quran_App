package com.theteksol.quran.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.theteksol.quran.R;

public class SearchActivity extends AppCompatActivity {

    EditText search_text;
    Button search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_btn = (Button) findViewById(R.id.search_button);
        search_text = (EditText) findViewById(R.id.search_text);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e){
            e.printStackTrace();
        }


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchWord();
            }
        });

    }

    private void searchWord() {
        String word = search_text.getText().toString();
        if (!word.isEmpty()){
            Intent intent = new Intent(this, SearchResult.class);
            intent.putExtra("Word", word);
            startActivity(intent);
        }

        else {
            Toast.makeText(this, "No Words Entered", Toast.LENGTH_SHORT).show();
        }
    }
}
