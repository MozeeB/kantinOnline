package com.example.mozeeb.kantinonline.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mozeeb.kantinonline.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransaksiActivity extends AppCompatActivity {

    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.pembayaran1)
    TextView pembayaran1;
    @BindView(R.id.pembayaran2)
    TextView pembayaran2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        ButterKnife.bind(this);

        this.setTitle("Transaksi");
    }

    @OnClick(R.id.pembayaran1)
    public void onViewClicked() {
        startActivity(new Intent(TransaksiActivity.this, AlamatActivity.class));
    }

}
