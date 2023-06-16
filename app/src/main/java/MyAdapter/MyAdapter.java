package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cricbuzz.ListView_Activity;
import com.example.cricbuzz.R;

public class MyAdapter extends BaseAdapter {
    ListView_Activity listView_activity;
    int[] imgArr;
    String[] Name;
    String[] Position;
    public MyAdapter(ListView_Activity listView_activity, int[] imgArr, String[] Name, String[] Position)
    {
        this.listView_activity=listView_activity;
        this.imgArr=imgArr;
        this.Name=Name;
        this.Position=Position;
    }

    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(listView_activity).inflate(R.layout.activity_listview_item,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.activity_main2_imgView);
        TextView txt1 = view.findViewById(R.id.activity_main2_txt1);
        TextView txt2 = view.findViewById(R.id.activity_main2_txt2);

        imageView.setImageResource(imgArr[position]);
        txt1.setText(Name[position]);
        txt2.setText(Position[position]);

        return view;

    }
}
