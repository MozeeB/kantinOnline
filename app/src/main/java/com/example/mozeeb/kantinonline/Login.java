package com.example.mozeeb.kantinonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mozeeb.kantinonline.user.SplashScreen;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    ProgressBar loading;
    Button login_log;
    TextView create_log;
    EditText username_log, passsword_log;
    private static String URL_LOGIN = "http://192.168.70.157/kantin/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loading = findViewById(R.id.progressBar2);
        login_log = findViewById(R.id.login_log);
        create_log = findViewById(R.id.create_log);
        username_log = findViewById(R.id.username_log);
        passsword_log = findViewById(R.id.pass_log);

        login_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });

        create_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });


    }
    public void Login(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            startActivity(new Intent(Login.this, SplashScreen.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "Wrong Username or Password",Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username_log.getText().toString());
                params.put("password", passsword_log.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);

    }


}