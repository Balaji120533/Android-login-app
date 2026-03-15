package com.example.myapplication2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText username,password;
    Button login,cancel;
    TextView info;
    int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);
        cancel = findViewById(R.id.button2);
        info = findViewById(R.id.textView3);
        info.setText("No of remaining attemps:3");
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }
    private void validate(String username,String password){
        if(username.equals(("balaji")) && (password.equals("1234567")))
        {
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logined",Toast.LENGTH_SHORT).show();
        }
        else{
            counter--;
            info.setText("no of remaining attemps:"+String.valueOf(counter));
            Toast.makeText(this, "check username or password",Toast.LENGTH_SHORT).show();
            if(counter==0)
            {
                login.setEnabled(false);
            }
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    finish();
                }
            });
        }
    }
}
