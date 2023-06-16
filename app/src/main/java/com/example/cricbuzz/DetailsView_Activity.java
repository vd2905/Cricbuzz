package com.example.cricbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsView_Activity extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    ImageView imageView;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);


        txt1=findViewById(R.id.details_txtName);
        txt2=findViewById(R.id.details_txtCountry);
        txt3=findViewById(R.id.details_txtBorn);
        txt4=findViewById(R.id.details_txtBirthPlace);
        txt5=findViewById(R.id.details_txtRole);
        txt6=findViewById(R.id.details_txtBatstyle);
        txt7=findViewById(R.id.details_txtBowstyle);
        imageView=findViewById(R.id.details_imgView);

        int position=getIntent().getIntExtra("pos",0);
        String Name[]=getIntent().getStringArrayExtra("Name");
        String Country[]=getIntent().getStringArrayExtra("Country");
        String Born[]=getIntent().getStringArrayExtra("Born");
        String BirthPlace[]=getIntent().getStringArrayExtra("BirthPlace");
        String Role[]=getIntent().getStringArrayExtra("Role");
        String BatStyle[]=getIntent().getStringArrayExtra("BatStyle");
        String BowStyle[]=getIntent().getStringArrayExtra("BowStyle");
        int imgArr[]=getIntent().getIntArrayExtra("imgArr");

        txt1.setText(""+Name[position]);
        txt2.setText(""+Country[position]);
        txt3.setText(""+Born[position]);
        txt4.setText(""+BirthPlace[position]);
        txt5.setText(""+Role[position]);
        txt6.setText(""+BatStyle[position]);
        txt7.setText(""+BowStyle[position]);
        imageView.setImageResource(imgArr[position]);
    }
}