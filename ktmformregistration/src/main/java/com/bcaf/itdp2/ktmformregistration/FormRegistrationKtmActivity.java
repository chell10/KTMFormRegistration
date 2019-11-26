package com.bcaf.itdp2.ktmformregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bcaf.itdp2.ktmformregistration.utils.FormInput;
import com.bcaf.itdp2.ktmformregistration.utils.KTMModel;

public class FormRegistrationKtmActivity extends AppCompatActivity {

    private Context context = this;
    private EditText inputNamaMahasiswa, inputAlamatMahasiswa, inputUsiaMahasiswa;
    private Button buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_registration_ktm);

        //init
        inputNamaMahasiswa = findViewById(R.id.inputNamaMahasiswa);
        inputAlamatMahasiswa = findViewById(R.id.inputAlamatMahasiswa);
        inputUsiaMahasiswa = findViewById(R.id.inputUsiaMahasiswa);

        buttonDaftar = findViewById(R.id.buttonDaftar);
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiInput();
            }
        });

        KTMModel model = new KTMModel();
        FormInput.setDataModel(model);
    }

    private void validasiInput() {
        String nama = inputNamaMahasiswa.getText().toString().trim();
        String alamat = inputAlamatMahasiswa.getText().toString().trim();
        String usia = inputUsiaMahasiswa.getText().toString().trim();

        if(nama.isEmpty() || alamat.isEmpty() || usia.isEmpty()){
            Toast.makeText(context, "Nama dan Alamat dan Usia harus diisi", Toast.LENGTH_SHORT).show();
        }else {
            KTMModel model = new KTMModel();
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setUsia(Integer.parseInt(usia));

            FormInput.setDataModel(model);

            Toast.makeText(context, "Data Berhasil Di input", Toast.LENGTH_SHORT).show();

            //kembalikan result
            Intent intent =new Intent();
            setResult(RESULT_OK,intent);

            //tutup activity
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        emptyData();
    }

    private void emptyData(){
        KTMModel model = new KTMModel();
        FormInput.setDataModel(model);
    }
}
