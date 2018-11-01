package com.example.mozeeb.kantinonline.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mozeeb.kantinonline.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {


    @BindView(R.id.gambar_details)
    ImageView gambarDetails;
    @BindView(R.id.judul_details)
    TextView judulDetails;
    @BindView(R.id.deskripsi_details)
    TextView deskripsiDetails;
    @BindView(R.id.deskripsi_text)
    TextView deskripsiText;
    @BindView(R.id.beli_sekarang)
    Button beliSekarang;
    @BindView(R.id.harga_details)
    TextView hargaDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        this.setTitle("Details");

        Glide.with(this).load(getIntent().getIntExtra("gambar",0)).into(gambarDetails);
        judulDetails.setText(getIntent().getStringExtra("judul"));
        hargaDetails.setText(getIntent().getStringExtra("harga"));

    }

    @OnClick(R.id.beli_sekarang)
    public void onViewClicked() {
        startActivity(new Intent(DetailsActivity.this, TransaksiActivity.class));

    }
}
