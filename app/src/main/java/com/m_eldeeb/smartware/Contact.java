package com.m_eldeeb.smartware;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.m_eldeeb.smartware.models.ContactModel;
import com.m_eldeeb.smartware.models.RegisterModel;

import static com.m_eldeeb.smartware.R.id.course;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact extends Fragment {


    public Contact() {
        // Required empty public constructor
    }

EditText name,email,subject,message;
    Button send;

    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_contact, container, false);
name= (EditText) view.findViewById(R.id.name);
        email= (EditText) view.findViewById(R.id.email);
        subject= (EditText) view.findViewById(R.id.subject);
        message= (EditText) view.findViewById(R.id.message);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar3);

        send= (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contact();
            }
        });
        return view;
    }
public  void Contact(){
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference Contacts = database.getReference("Contacts");

    if (name.getText().toString() == null || email.getText().toString() == null ||
            subject.getText().toString() == null ||
            message.getText().toString() == null) {
        Toast.makeText(getActivity(), "fill all data", Toast.LENGTH_SHORT).show();
    } else {
        progressBar.setVisibility(View.VISIBLE);
        ContactModel model = new ContactModel();
        model.setName(name.getText().toString());
        model.setEmail(email.getText().toString());
        model.setSubject(subject.getText().toString());
        model.setMessage(message.getText().toString());
        Contacts.push().setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressBar.setVisibility(View.INVISIBLE);
                if (task.isSuccessful()) {
                    // progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

                } else {
                    // progressBar.setVisibility(View.INVISIBLE);
                    Log.v("ee",task.toString());
                    Toast.makeText(getActivity(), "there is a problem try later  ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
}
