package alanfuad.com.loginsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.edName);
        Password = (EditText)findViewById(R.id.edPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Info = (TextView)findViewById(R.id.tvInfo);

        Info.setText("Attempts remaining: 5");

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    validate(Name.getText().toString(), Password.getText().toString());

                }
            });




    }

    private void validate (String username, String userpassword){

        if(username.equals("Admin")&&userpassword.equals("1234")){

            Intent in = new Intent(MainActivity.this,SecAct.class);
            startActivity(in);
        }
        else{
            counter --;
                    Info.setText("Attempts remaining: "+String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }


    }


}
