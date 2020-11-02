package com.example.localdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableActivity extends Activity {

    @BindView(R.id.etFirstName)
    EditText etFirstname;

    @BindView(R.id.etLastname)
    EditText etLastname;

    @BindView(R.id.btnSave)
    Button btnsave;

    public static final String DML_TYPE = "DML_TYPE";
    public static final String UPDATE = "Update";
    public static final String INSERT = "Insert";
    public static final String FIRST_NAME = "Firstname";
    public static final String LAST_NAME = "Lastname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        ButterKnife.bind(this);
        MyApplication.app().appComponent().inject(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFirstname.getText().toString().equals("") || etLastname.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Add Both Fields", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(FIRST_NAME, etFirstname.getText().toString());
                    intent.putExtra(LAST_NAME, etLastname.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        setInsertData();
    }

    public void setInsertData() {
        String request = getIntent().getExtras().get(DML_TYPE).toString();
        if (request.equals(UPDATE)) {
            btnsave.setText(UPDATE);
            etFirstname.setText(getIntent().getExtras().get(FIRST_NAME).toString());
            etLastname.setText(getIntent().getExtras().get(LAST_NAME).toString());
        } else {
            btnsave.setText(INSERT);
        }
    }
}
