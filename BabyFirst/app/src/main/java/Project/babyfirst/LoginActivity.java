package Project.babyfirst;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Info {
    EditText idText;
    EditText passText;
    String Id;
    String Pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idText = (EditText) findViewById(R.id.et_id);
        passText = (EditText) findViewById(R.id.et_pass);
    }
    public void login(View v) {
        if (database != null) {
            Cursor cursor = database.rawQuery("SELECT id, pass, name FROM " + tableName, null);
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                cursor.moveToNext();
                Cid = cursor.getString(0);
                Cpass = cursor.getString(1);
                Cname = cursor.getString(2);
            }
            Id = idText.getText().toString();
            Pass = passText.getText().toString();
            if (Id.equals(Cid) && Pass.equals(Cpass)) {
                Intent main = new Intent(getApplication(), MainActivity.class);
                main.putExtra("splash", "splash");
                startActivity(main);
                Toast.makeText(getApplicationContext(), Cname + "님 환영합니다.",
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "정확한 정보를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
    }
    public void sign(View view) {
        Intent member = new Intent(getApplication(), signUpActivity.class);
        member.putExtra("splash", "splash");
        startActivity(member);
    }
}
