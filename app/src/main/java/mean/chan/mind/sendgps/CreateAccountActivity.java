package mean.chan.mind.sendgps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private EditText namEditText,userEditText,passwordEditText,rePasswordEditText;
    private RadioGroup radioGroup;
    private RadioButton maleRadioButton,femaleRadioButton;
    private Button button;
    private  String nameString, userString,passwordString,rePasswordString,genderString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        initialView();

        buttonController();

    }//main method

    private void buttonController() {

        button.setOnClickListener(CreateAccountActivity.this);

    }

    private void initialView() {
        namEditText = (EditText) findViewById(R.id.edtName);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        rePasswordEditText = (EditText) findViewById(R.id.edtRepassword);
        radioGroup = (RadioGroup) findViewById(R.id.ragGender);
        maleRadioButton = (RadioButton) findViewById(R.id.radMale);
        femaleRadioButton = (RadioButton) findViewById(R.id.radFemale);
        button = (Button) findViewById(R.id.btnContCreateAccount);


    }

    @Override
    public void onClick(View v) {
        //get Value Edit Text
        nameString = namEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        rePasswordString = rePasswordEditText.getText().toString().trim();

        //check space
        if (nameString.equals("") ||
                userString.equals("") ||
                passwordString.equals("") ||
                rePasswordString.equals("")) {
            //Have space

            MyAlert myAlert = new MyAlert(CreateAccountActivity.this);
            myAlert.myDialog("มีช่องว่าง","กรุณากรอกทุกช่อง");
        } else if (!passwordString.equals(rePasswordString)) {
            //Password not match
            MyAlert myAlert = new MyAlert(CreateAccountActivity.this);
            myAlert.myDialog("Password ไม่ตรงกัน","กรุณากรอกให้ตรงกันด้วย");
        } else if (maleRadioButton.isChecked()||femaleRadioButton.isChecked()) {
            //Check Radio button
            upLoadValueToServer();


        } else{
            //Non check
            MyAlert myAlert = new MyAlert(CreateAccountActivity.this);
            myAlert.myDialog("ยังไม่เลือก Gender","กรุณาเลือก Gender");
        }

    }//onClick

    private void upLoadValueToServer() {

    }//upload
} //main
