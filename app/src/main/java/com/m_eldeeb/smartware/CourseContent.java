package com.m_eldeeb.smartware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourseContent extends AppCompatActivity {
TextView text;
    Button register;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);
text= (TextView) findViewById(R.id.text);
        name=getIntent().getStringExtra("course");
        text.setText(getIntent().getIntExtra("content",R.string.web_content));
        register= (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(CourseContent.this,Register.class);
                intent.putExtra("course",name);
                startActivity(intent);
            }
        });
    }
}
