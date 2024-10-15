package com.thariq.loginform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    private EditText etRadius, etHeight;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inisialisasi view
        etRadius = findViewById(R.id.etRadius);
        etHeight = findViewById(R.id.etHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Set listener untuk tombol hitung
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCylinderVolume();
            }
        });
    }

    private void calculateCylinderVolume() {
        String radiusStr = etRadius.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();

        // Cek apakah input tidak kosong
        if (radiusStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Jari-jari dan tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        // Konversi input menjadi angka
        try {
            double radius = Double.parseDouble(radiusStr);
            double height = Double.parseDouble(heightStr);

            // Hitung volume tabung
            double volume = Math.PI * Math.pow(radius, 2) * height;

            // Ubah hasil volume menjadi bilangan bulat (dibulatkan)
            int volumeInt = (int) Math.round(volume);

            // Tampilkan hasil sebagai bilangan bulat
            tvResult.setText("Volume Tabung: " + volumeInt + " cm³");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
        }
    }
}
