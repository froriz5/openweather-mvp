package com.sapient.froriz.sunshine.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sapient.froriz.sunshine.R;

/**
 * Created by froriz on 10/2/15.
 */
public class DetailActivity extends AppCompatActivity implements DetailView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }


}
