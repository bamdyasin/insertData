package com.earningaide.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText myName, myEmail, myNumber;
    Button mySubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.myProgressBar);
        myName = findViewById(R.id.myName);
        myNumber = findViewById(R.id.myNumber);
        myEmail = findViewById(R.id.myEmail);
        mySubmit = findViewById(R.id.mySubmit);

        mySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = myName.getText().toString();
                String number = myNumber.getText().toString();
                String email = myEmail.getText().toString();


               String url = "https://earningaide.000webhostapp.com/app/data.php?name="+name+"&phone="+number+"&email="+email;   //working
           //     String url = "http://localhost/data/data.php?n="+name+"&p="+number+"&e="+email;


                progressBar.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Server Response Status")
                                .setMessage(response).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                if(name.isEmpty()){
                    myName.setError("Name Is Missing");
                    progressBar.setVisibility(View.GONE);

                }else if (number.isEmpty()){
                    myNumber.setError("Number Is Missing");
                    progressBar.setVisibility(View.GONE);

                }else if(email.isEmpty()){
                    myEmail.setError("Missing Email");
                    progressBar.setVisibility(View.GONE);

                }else {

                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);
                } 
            }
        }); 
//http://localhost/data/data.php?n=MD%20YASIN%20ARAFAT&p=313134&e=yasin@gmail.com
 
    }
}
