package Project.babyfirst;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Info { // 로그인 액티비티
    EditText idText;
    EditText passText;
    String Id;
    String Pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnsecondAct = (Button) findViewById(R.id.btn_login);
        Button btnSignUp = (Button) findViewById(R.id.btn_register);
        idText = (EditText) findViewById(R.id.et_id);
        passText = (EditText) findViewById(R.id.et_pass);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(getApplication(), signUpActivity.class);
                signup.putExtra("splash", "splash");
                startActivity(signup);
            }

        });


        if (database != null) {
            Cursor cursor = database.rawQuery("SELECT name, id, pass FROM " + tableName, null);
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                cursor.moveToNext();
                Cname = cursor.getString(0);
                Cnum = cursor.getString(1);
                Cpass = cursor.getString(2);
            }
            Id = idText.getText().toString();
            Pass = passText.getText().toString();
            btnsecondAct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Id.equals(Cnum) && Pass.equals(Cpass)) {
                        Intent main = new Intent(getApplication(), MainActivity.class);
                        main.putExtra("splash", "splash");
                        startActivity(main);
                        Toast.makeText(getApplicationContext(), Cname + "님 환영합니다.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "정확한 정보를 입력하세요.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            cursor.close();
        }
    }
}