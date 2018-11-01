package com.example.mozeeb.kantinonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {

    private ProgressBar loading;
    private EditText nama, username, email, kelas, password;
    private Button create_res;
    private static String URL_CREATE_RES = "http://192.168.70.157/kantin/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.progressBar);
        nama = findViewById(R.id.et_nama);
        username = findViewById(R.id.et_user);
        email = findViewById(R.id.et_email);
        kelas = findViewById(R.id.et_kelas);
        password = findViewById(R.id.et_pass);
        create_res = findViewById(R.id.create_res);

        create_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();

            }
        });
    }

    private void Regist() {
        loading.setVisibility(View.VISIBLE);
        create_res.setVisibility(View.GONE);

        final String username = this.username.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String kelas = this.kelas.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CREATE_RES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Intent c = new Intent(Register.this, Login.class);
                                startActivity(c);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(Register.this, "Create Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            create_res.setVisibility(View.VISIBLE);

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, "Create Error!" + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        create_res.setVisibility(View.VISIBLE);

                    }

                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("kelas", kelas);
                params.put("password", password);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
