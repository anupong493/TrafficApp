package comscisdu.anupong.trafficapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    //Explicit
    Context context;
    int[] ints; //ตัวแปรรูปicon
    String[] titleStrings, detailStrings;

    public MyAdapter(Context context, int[] ints, String[] strings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.strings = strings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {//นับจำนวนข้อมูลใน DB
        return ints.length;
    }

    @Override
    public Object getItem(int i) {//ไม่ใช้
        return null;
    }

    @Override
    public long getItemId(int i) {//ไม่ใช้
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {//นำข้อมูลที่นับจาก getCount() มาแสดงผล

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, ViewGroup, false); //ดึงค่า Xml มาแสดงผล

        //ผูกตัวแปรบน Java บนกับอิลิเมนต์บน Xml
        ImageView imageView = view1.findViewById(R.id.imvIcon);
        TextView titleTextView = view1.findViewById(R.id.tvTitle);
        TextView detailTextView = view1.findViewById(R.id.tvDetail);

        //นำข้อมูลไปแสดงผลบนหน้าแอป
        imageView.setImageResource(ints[i]);
        titleTextView.setText(titleStrings[i]);
        detailTextView.setText(detailStrings[i]);
        return view1;
    }
}// end class
