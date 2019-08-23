package testwork.com.testterminal8.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import testwork.com.testterminal8.R;
import testwork.com.testterminal8.manager.Contextor;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText EdUsername,EdPassword;
    CardView Btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        InitInstances();
    }

    private void InitInstances() {

        EdUsername = (EditText)findViewById(R.id.ed_username_login);
        EdPassword = (EditText)findViewById(R.id.ed_passwork_login);
        Btnlogin = (CardView)findViewById(R.id.btnLogin);

        Btnlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == Btnlogin){
            checkUser();
        }
    }

    private void checkUser() {

        String user,pass;
        user = EdUsername.getText().toString();
        pass = EdPassword.getText().toString();

        if(user.equals("fluk")){
            if(pass.equals("1234")){
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                finish();
                startActivity(intent);
            }
            else {
                Toast.makeText(Contextor.getInstance().getmContext(),"รหัสผ่านผิด",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(Contextor.getInstance().getmContext(),"รหัสผ่านผิด",Toast.LENGTH_LONG).show();
        }



    }
}
