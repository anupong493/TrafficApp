package comscisdu.anupong.trafficapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    ListView listView;
    String[] titleStrings, detailStrings, shortdetailStrings;
    int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
            R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06,
            R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
            R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12,
            R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
            R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18,
            R.drawable.traffic_19, R.drawable.traffic_20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ผูกอิลิเมนต์บน Xml ให้รู้จักกับตัวแปร JAVA
        listView = findViewById(R.id.livTraffic);

        //Get Value ดึงค่าจาก DB ที่ไฟล์ my_context.xml มาแสดงผล
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);
        //Substrings ตัดคำ detail ให้เหลือ 20 char
        shortdetailStrings = new String[detailStrings.length];
        for (int i = 0; i < detailStrings.length; i++) {
            shortdetailStrings[i] = detailStrings[i].substring(0, 20) + "...";
        }
        //แสดงผลบน ListView
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, shortdetailStrings);
        listView.setAdapter(myAdapter);

        //คลิกเลือกรายการบน ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("Title", titleStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Icon", ints[i]);
                startActivity(intent);
            }
        });
    }
    public void  clickweb(View view) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://www.dlt.go.th"));
        startActivity(webIntent);
    }
    public void linkAboutMe(View view){
        Intent aboutmeintent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(aboutmeintent);
    }
}