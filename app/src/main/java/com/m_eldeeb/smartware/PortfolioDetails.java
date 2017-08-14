package com.m_eldeeb.smartware;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.m_eldeeb.smartware.models.PortfolioModel;
import com.squareup.picasso.Picasso;

public class PortfolioDetails extends AppCompatActivity {
PortfolioModel model;

    TextView title,desc;
    ImageView image;
    Button see;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_details);
model= (PortfolioModel) getIntent().getSerializableExtra("portfolio");

        title= (TextView) findViewById(R.id.title);

        desc= (TextView) findViewById(R.id.desc);
        image= (ImageView) findViewById(R.id.image);
        see= (Button) findViewById(R.id.see);
        title.setText(model.getTitle());
        desc.setText(model.getDescription());
        try {
            Picasso.with(this)
                    .load(String.valueOf(model.getImage()))
                    .into(image);
        }
        catch (Exception e){}
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(model.getUrl()));
                    startActivity(i);
                }catch (Exception e){}


            }
        });

    }
}
