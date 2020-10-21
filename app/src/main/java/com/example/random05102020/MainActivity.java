package com.example.random05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtMax, mEdtMin;
    String chuoiKetQua;
    Button mBtnRandom;
    String mTxtMax, mTxtMin ;
       int      sodem;
    TextView mEdtResult;
    ArrayList<Integer> mangResult= new ArrayList<Integer>() ;
    ArrayList<Integer> mangRandom= new ArrayList<Integer>() ;
    int mSMin, mSMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hàm trong java : Tái sử dụng code
        initView();
        // Task 1 : Valid (Khi click button)
//            + Kiểm tra chuỗi trong edittext khác rỗng
//            + Kiểm tra số max không được bé hoăc bằng hơn min (max = min + 1)
        event();

    }

    private void initView() {
        mEdtResult = findViewById(R.id.textViewResult);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mEdtMax = findViewById(R.id.editTextMax);
        mEdtMin = findViewById(R.id.editTextMin);
        mSMin = mSMax = -1;
    }

    private void event() {
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtMax = mEdtMax.getText().toString();
                mTxtMin = mEdtMin.getText().toString();

                // KIỂM TRA RỖNG
                if (mTxtMax.length() <= 0 || mTxtMin.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                Random random = new Random();
                mSMax = Integer.parseInt(mTxtMax);
                mSMin = Integer.parseInt(mTxtMin);
                int numRandom;
                if (mSMax - mSMin < 2 ) {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập max > min +2", Toast.LENGTH_SHORT).show();
                    return;
                    // mEdtMax.setText(mSMax+"");
                }
                // thiết lập ban đầu cho lần chạy 1
                if( mangResult.size()==0 ){
                    sodem = mSMax -mSMin;
                    for (int i = mSMin; i< mSMax +1 ; i++){
                        mangRandom.add(i);
                    }
                }
                // bắt đầu random

                numRandom = random.nextInt(sodem) ;

                if (mangRandom.size()>0) {
                    if( mangResult.contains( mangRandom.get(sodem))){
                        Toast.makeText(MainActivity.this , "Số Random đã có " +
                                "bấm để chạy tiếp" , Toast.LENGTH_SHORT)
                        .show(); return;
                    } else {
                        mangResult.add(mangRandom.get(sodem));
                        mangRandom.remove(numRandom);
                        mangRandom.trimToSize();
                        sodem= sodem-1;
                    }
                    chuoiKetQua = mangResult.get(0).toString();
                    for ( int i = 1 ; i< mangResult.size();i++){
                        chuoiKetQua = chuoiKetQua + "-"+ mangRandom.get(i);
                    }
                    mEdtResult.setText(chuoiKetQua);

                }else {
                    Toast.makeText(MainActivity.this , "Random Hoàn THành" , Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
    }
}
// 2 : ánh xạ
//        mTv = findViewById(R.id.textView);
//        mBtn = findViewById(R.id.buttonClick);

// Hàm log
// ctrl + p : xem tham số truyền vào
//Log.d("BBB",mTv.getText().toString());

// Hàm Thông báo
//        Toast
//                .makeText(MainActivity.this , "Hello" , Toast.LENGTH_SHORT)
//                .show();
//        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
//        on vs emit
//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "textview", Toast.LENGTH_SHORT).show();
//            }
//        });
// built in function : Log.d() , Math
// Làm tròn
//float num1 =  Math.round(1.5f);
// Làm tròn xuống : floor (Sàn nhà)
//double num2 = Math.floor(1.9999999);
// Làm tròn lên : ceil (trần nhà)
//double num3 = Math.ceil(1.01);
// random
// 0 - 5
//        for (int i = 0; i < 100 ; i++) {
//            double num4 = Math.floor(Math.random() * 6);
//            Log.d("BBB",num4 + "");
//        }
//        Toast.makeText(this, num4 + "", Toast.LENGTH_SHORT).show();

// 3 - 107
//        Random random = new Random();
//        for (int i = 0; i < 20 ; i++) {
//            int numRandom = random.nextInt(107 - 3 + 1) + 3;
//            Log.d("BBB",numRandom + "");
//        }

// 1 : Access modifier (phạm vi truy cập : class , function , interface , ...)
// 2 : Result (Giá trị sau khi thực thi)
// 3 : Name (Tên hàm)
// 4 : Parameter (Tham số truyền vào)

//    1       2   3       4
//    private String setName(String name){
//        return "";
//    }
