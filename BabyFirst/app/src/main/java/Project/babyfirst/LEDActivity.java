package Project.babyfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class LEDActivity extends Activity {
    BluetoothSPP bt2 = ((MainActivity)MainActivity.context_main).bt;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        ImageButton btnledon = findViewById(R.id.LEDON); //데이터 전송 초록색 LED
        btnledon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bt2.send("G", true);
            }
        });
        ImageButton btnledoff = findViewById(R.id.LEDOFF); //데이터 전송 LED 소등
        btnledoff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bt2.send("P", true);
            }
        });
        Button btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}