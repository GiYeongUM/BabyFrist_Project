package Project.babyfirst;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUpActivity extends Info {
    EditText ID,PASS,NAME,BIRTH,HOME;
    String TID, Tpass, TNAME,Tbirth,Thome;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ID = (EditText) findViewById(R.id.et_id2);
        PASS = (EditText) findViewById(R.id.et_pass2);
        NAME = (EditText) findViewById(R.id.et_name);
        BIRTH = (EditText) findViewById(R.id.et_birth);
        HOME = (EditText) findViewById(R.id.et_addrass);
        Button join = (Button) findViewById(R.id.signup);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TID = ID.getText().toString();
                Tpass = PASS.getText().toString();
                TNAME = NAME.getText().toString();
                Tbirth = BIRTH.getText().toString();
                Thome = HOME.getText().toString();
                Cursor cursor = database.rawQuery("SELECT name, id, pass FROM " + tableName, null);
                int count = cursor.getCount();

                for(int i=0;i<count;i++) {
                    cursor.moveToNext();
                    Cname = cursor.getString(0);
                    Cnum = cursor.getString(1);
                    Cmajor = cursor.getString(2);
                }
                if (Tpass.length() <6) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 6자리 이상 입력하세요.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    try{
                        if (database != null) {
                            database.execSQL("INSERT INTO " + tableName + "(id, pass, name, birth, home) VALUES" +
                                    "(" + "'" + TID + "'" + "," + "'" + Tpass + "'" + "," + "'" + TNAME + "'" + "," + Tbirth + "," + "'" + Thome + "'" + ")");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent login = new Intent(getApplication(), LoginActivity.class);
                    login.putExtra("splash", "splash");
                    finish();
                    Toast.makeText(getApplication(), TNAME + "님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
                }
            } });

    }




}
