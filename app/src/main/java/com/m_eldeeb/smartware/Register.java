package com.m_eldeeb.smartware;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.m_eldeeb.smartware.interfaces.GetData;
import com.m_eldeeb.smartware.models.RegisterModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.name;

public class Register extends AppCompatActivity {
TextView name,email,phone,faculity,grade,course;
    Button register;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name= (TextView) findViewById(R.id.name);
        email= (TextView) findViewById(R.id.email);
        phone= (TextView) findViewById(R.id.phone);
        faculity= (TextView) findViewById(R.id.faculty);
        grade= (TextView) findViewById(R.id.grade);
        course= (TextView) findViewById(R.id.course);
        progressBar= (ProgressBar) findViewById(R.id.progressBar2);
register= (Button) findViewById(R.id.register);
       String course1=getIntent().getStringExtra("course");
        course.setText(course1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();

            }
        });
    }
    /*
    public void register() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Call<ResponseBody> connection;
        GetData registerFunction = retrofit.create(GetData.class);

        connection = registerFunction.register("d","d","d,","d","jj","g");
        connection.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                String RegisterResult = null;
                try {
                    RegisterResult = response.body().string();
                    Log.v("sss",RegisterResult);
                    JSONObject jso = new JSONObject(RegisterResult);
                    String code = jso.getString("code");
                    if(code.equals("200")){

                    }
                    else {  String error = jso.getString("msg");
                        Toast.makeText(getBaseContext(), error, Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }




            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(getBaseContext(), "no internet or some thing wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }*/

    public void register() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mobiles = database.getReference("register");

        //progressBar.setVisibility(View.VISIBLE);
        if (name.getText().toString() == null || email.getText().toString() == null ||
                course.getText().toString() == null ||
                phone.getText().toString() == null ||
                faculity.getText().toString() == null ||
                grade.getText().toString() == null) {
            Toast.makeText(getBaseContext(), "fill all data", Toast.LENGTH_SHORT).show();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            RegisterModel model = new RegisterModel();
            model.setName(name.getText().toString());
            model.setEmail(email.getText().toString());
            model.setPhone(phone.getText().toString());
            model.setFaculty(faculity.getText().toString());
            model.setGrade(grade.getText().toString());
            model.setCourse(course.getText().toString());
            model.setName(name.getText().toString());

            mobiles.push().setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        // progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Register.this, "done", Toast.LENGTH_SHORT).show();

                    } else {
                        // progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Register.this, "there is some problem try later ", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}
