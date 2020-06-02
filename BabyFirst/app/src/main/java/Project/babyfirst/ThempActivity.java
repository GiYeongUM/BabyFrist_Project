package Project.babyfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThempActivity extends Activity { // 온도조절 액티비티
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
