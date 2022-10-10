package com.example.widyaayunindyapoge_F55121071;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_width, edt_height, edt_length;
    private Button btn_calculator;
    private TextView tv_results;
    private Bundle savedInstanceStates;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        this.savedInstanceStates = savedInstanceStates;
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_main);

        edt_width = findViewById(R.id.edt_width);
        edt_height = findViewById(R.id.edt_height);
        edt_length = findViewById(R.id.edt_length);
        btn_calculator = findViewById(R.id.btn_calculator);
        tv_results = findViewById(R.id.tv_result);

        btn_calculator.setOnClickListener(this);

        if (savedInstanceStates != null) {
            String result =
                    savedInstanceStates.getString(STATE_RESULT);
            tv_results.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculator) {
            String inputLength =
                    edt_length.getText().toString().trim();
            String inputWidth =
                    edt_width.getText().toString().trim();
            String inputHeight =
                    edt_height.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edt_length.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edt_width.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edt_height.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                tv_results.setText(String.valueOf(volume));
            }
        }
    }

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT,
                tv_results.getText().toString());
    }
}