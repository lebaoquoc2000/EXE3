package tdc.edu.vn.test.GiaoDien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.DataBase.DBPhieuNhap;
import tdc.edu.vn.test.Model.PhieuNhap;

public class MainDetailSV extends AppCompatActivity {
    EditText txtMaKho, txtSoPhieu, txtNgayLap;
    Button btnDefect;
    ArrayList<PhieuNhap> dataPN = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail_sv);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }

    private void setEvent() {
        String makho = getIntent().getExtras().getString("ma");

        DBPhieuNhap dbPhieuNhap  =new DBPhieuNhap(this);
        dataPN =dbPhieuNhap.LayDL(makho);
        txtMaKho.setText(dataPN.get(0).getMaKho());
        txtSoPhieu.setText(dataPN.get(0).getSoPhieu());
        txtNgayLap.setText(dataPN.get(0).getNgayLap());

    }

    private void setControl() {

        txtMaKho = findViewById(R.id.txtMa);
        txtSoPhieu = findViewById(R.id.txtSoPhieu);
        txtNgayLap = findViewById(R.id.txtNgayLap);
        btnDefect = findViewById(R.id.btnDefect);

        btnDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDetailSV.this,MainGridView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
