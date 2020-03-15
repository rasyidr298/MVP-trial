package com.example.latihanmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.latihanmvp.presenter.MainPresenterImp;
import com.example.latihanmvp.presenter.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText edtAlas,edtTinggi,edtPanjang,edtLebar;
    private Button btnHitungLuas,btnHitungKeliling;
    private TextView tvHasilLuas,tvHasilKeliling;
    private MainPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlas = findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar= findViewById(R.id.edt_lebar);
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling);
        btnHitungLuas = findViewById(R.id.btn_hitung_luas);
        tvHasilKeliling = findViewById(R.id.btn_hitung_keliling);
        tvHasilLuas = findViewById(R.id.tv_hasil_luas);
        tvHasilKeliling = findViewById(R.id.tv_hasil_keliling);

        initPresenter();

        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double alas = Double.valueOf(edtAlas.getText().toString());
                Double tinggi = Double.valueOf(edtTinggi.getText().toString());
                //Double luas = alas*tinggi;
                //tvHasil.setText(luas.toString());
                presenterImp.hitungLuas(alas,tinggi);
            }
        });

        btnHitungKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double panjang = Double.valueOf(edtPanjang.getText().toString());
                Double lebar = Double.valueOf(edtLebar.getText().toString());

                presenterImp.hitungKeliling(panjang,lebar);
            }
        });
    }

    private void initPresenter(){
        presenterImp = new MainPresenterImp(this);
    }

    @Override
    public void updateTextHasilLuas(Double luas) {
        tvHasilLuas.setText(luas.toString());
    }

    @Override
    public void updateTextHasilKeliling(Double keliling) {
        tvHasilKeliling.setText(keliling.toString());
    }
}
