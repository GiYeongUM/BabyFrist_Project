package Project.babyfirst;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class siteActivity extends AppCompatActivity {

    ListView listV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        final String[] siteList = {"해오름", "베베하우스", "임산부닷컴", "베이비센터 코리아", "맘스홀릭 베이비"};
        final String[] siteUri = {"http://www.haeorum.com/container/?pc=", "https://www.bebehouse.com/", "http://www.imsanboo.com/", "www.babycenterkorea.co.kr", "cafe.naver.com/imsanbu.cafe"};
        listV = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, siteList);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse(siteUri[i]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}