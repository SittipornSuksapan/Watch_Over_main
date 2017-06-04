package mean.chan.mind.sendgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String urlJSONString = "http://androidthai.in.th/dom/getParent.php";
    private EditText userEditText, passwordEditText;
    private Button button;
    private TextView forgotTextView, createAccountTextView;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initial View
        initialView();

        //Controller
        controller();

    }   // Main Method

    private void controller() {
        button.setOnClickListener(this);
        forgotTextView.setOnClickListener(this);
        createAccountTextView.setOnClickListener(this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnLogin);
        forgotTextView = (TextView) findViewById(R.id.txtForgot);
        createAccountTextView = (TextView) findViewById(R.id.txtCreateAccount);
    }

    @Override
    public void onClick(View view) {

        //Create Account
        if (view == createAccountTextView) {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
        }

        //For Login
        if (view == button) {
            checkUserAndPass();
        }

    }   // onClick

    private void checkUserAndPass() {

        //Get Value from Edit Text
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        MyAlert myAlert = new MyAlert(LoginActivity.this);

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {
            myAlert.myDialog("Have Space", "Please Fill All Every Blank");
        } else {
            synUserAndPass();
        }

    }

    private void synUserAndPass() {

        try {

            MyAlert myAlert = new MyAlert(LoginActivity.this);
            GetAllData getAllData = new GetAllData(LoginActivity.this);
            getAllData.execute(urlJSONString);
            String strJSON = getAllData.get();
            Log.d("4JuneV1", "JSON ==> " + strJSON);

        } catch (Exception e) {
            Log.d("4JuneV1", "e check ==> " + e.toString());
        }
    }

}   // Main Class
