package comscisdu.anupong.trafficapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void connectMap(View view){
        Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:13.776663444675814,100.5103879390422('มหาวิทยาลัยสวนดุสิต')");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }
    public void dialMobile(View view){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:0984494293"));
        startActivity(dialIntent);
    }
    public void connectFB(View view){
        Intent FBIntent = new Intent(Intent.ACTION_VIEW);
        FBIntent.setData(Uri.parse("https://www.facebook.com/anupong.wingnak/"));
        startActivity(FBIntent);
    }
    public  void back(View view){
        finish();
    }
}