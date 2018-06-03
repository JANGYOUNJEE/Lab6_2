package com.example.sksmswndlsdlek.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String number, name;
    EditText sNumber, sName;
    Button open, save, reset;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sNumber=(EditText)findViewById(R.id.sNumber);
        sName=(EditText)findViewById(R.id.sName);
        open=(Button)findViewById(R.id.open);
        save=(Button)findViewById(R.id.save);
        reset=(Button)findViewById(R.id.reset);

        open.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                applySharedPreference();
                Toast.makeText(getApplicationContext(),"Details are opened",Toast.LENGTH_SHORT).show();
            }
        });
        save.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                number=sNumber.getText().toString();
                name=sName.getText().toString();
                sharedPreference();
                Toast.makeText(getApplicationContext(),"Details are saved",Toast.LENGTH_SHORT).show();
            }
        });
        reset.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                sNumber.setText("");
                sName.setText("");
                Toast.makeText(getApplicationContext(),"Reset",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sharedPreference(){
        sh_Pref=getSharedPreferences("Student Information",MODE_PRIVATE);
        toEdit=sh_Pref.edit();
        toEdit.putString("student_number",number);
        toEdit.putString("student_name",name);
        toEdit.commit();
    }

    public void applySharedPreference(){
        sh_Pref=getSharedPreferences("Student Information",MODE_PRIVATE);
        if(sh_Pref!=null&&sh_Pref.contains("student_name")){
            String sname=sh_Pref.getString("student_name","noname");
            sName.setText(sname);
        }

        if(sh_Pref!=null&&sh_Pref.contains("student_number")){
            String snumber=sh_Pref.getString("student_number","nonumber");
            sNumber.setText(snumber);
        }
    }
}
