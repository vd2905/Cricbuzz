package com.example.cricbuzz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import MyAdapter.MyAdapter;

public class ListView_Activity extends AppCompatActivity {

    ListView listView;
    int imgArrMI[]={R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12};
    String NameMI[]={"Rohit Sharma (C)","Ishan Kishan (Wk)","Suryakumar Yadav","Cameron Green","Tilak Verma","Tim David","Nehal Wadhera","Piyush Chawla","Arshad Khan","Jofra Archer","Jason Behrendroff"};
    String PositionMI[]={"Batter","WK-Batter","Batter","Bowling Allrounder","Batter","Batting Allrounder","Batter","Bowler","Bowler","Bowler","Bowler"};
    String CountryMI[]={"India","India","India","Australia","India","Australia","India","India","India","England","Australia"};
    String BornMI[]={"April 30,1987","July 18,1998","September 14,1990","June 03,1999","November 08,2002","March 16,1996","September 04,2000","December 24,1988","December 20,1997","April 01,1995","April 20,1990"};
    String BirthPlaceMI[]={"Maharashtra","Bihar","Maharashtra","Australia","AndhraPradesh","Singapore","Punjab","UttarPradesh","Gopalganj","Barbados","New South Wales"};
    String RoleMI[]={"Batsman","WK-Batsman","Batsman","Bowling Allrounder","Batsman","Batting Allrounder","Batsman","Bowler","Bowler","Bowler","Bowler"};
    String BatStyleMI[]={"Right Handed Bat","Left Handed Bat","Right Handed Bat","Right Handed Bat","Right Handed Bat","Right Handed Bat","Left Handed Bat","Left Handed Bat","Left Handed Bat","Right Handed Bat","Right Handed Bat"};
    String BowStyleMI[]={"Right-arm offbreak","-","Right-arm offbreak","Right-arm medium","Right-arm offbreak","Right-arm medium","Right-arm legbreak","Right-arm legbreak","Left-arm medium","Right-arm fast","Left-arm fast-medium"};

    int imgArrLSG[]={R.drawable.img_13,R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_20,R.drawable.img_21,R.drawable.img_22,R.drawable.img_23};
    String NameLSG[]={"KL Rahul (C)","Kyle Mayers","Deepak Hooda","Krunal Pandya","Marcus Stoinis","Nicholas Pooran (WK)","Krishnappa Gowtham","Avesh Khan","Ravi Bishnoi","Amit Mishra","Naveen-ui-Haq"};
    String PositionLSG[]={"WK-Batter","Batting Allrounder","Batting Allrounder","Batting Allrounder","Batting Allrounder","WK-Batter","Bowling Allrounder","Bowler","Bowler","Bowler","Bowler","Bowler"};
    String CountryLSG[]={"India","West Indies","India","India","Australia","West Indies","India","India","India","India","Afghanistan"};
    String BornLSG[]={"April 18,1992","September 08,1992","April 19,1995","March 24,1991","August 16,1989","October 02,1995","october 20,1988","December 13,1996","September 05,2000","November 24,1982","September 23,1999"};
    String BirthPlaceLSG[]={"Karnataka","Barbados","Rohtak","Gujarat","Perth","Trinidad","Karnataka","MadhyaPradesh","Rajasthan","Delhi","Kabul"};
    String RoleLSG[]={"WK-Batsman","Batting Allrounder","Batting Allrounder","Batting Allrounder","Batting Allrounder","WK-Batsman","Bowling AllRounder","Bowler","Bowler","Bowler","Bowler"};
    String BatStyleLSG[]={"Right Handed Bat","Left Handed Bat","Right Handed Bat","Left Handed Bat","Right Handed Bat","Left Handed Bat","Right Handed Bat","Right Handed Bat","Right Handed Bat","Right Handed Bat","Right Handed Bat"};
    String BowStyleLSG[]={"-","Right-arm medium","Right-arm offbreak","Left-arm orthodox","Right-arm medium","Right-arm offbreak","Right-arm offbreak","Right-arm fast-medium","Right-arm legbreak","Right-arm legbreak","Right-arm fast-medium"};
    MyAdapter adapter;
    String team;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView=findViewById(R.id.listView);
        team=getIntent().getStringExtra("team");

        if(team.equals("MI"))
        {

            adapter = new MyAdapter(ListView_Activity.this,imgArrMI,NameMI,PositionMI);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(ListView_Activity.this);
                    builder.setTitle("Are you confirm go to new page ?");
                    builder.setIcon(R.drawable.img_25);
                    builder.setMessage("Are you confirm go to new page ?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent=new Intent(ListView_Activity.this,DetailsView_Activity.class);
                            intent.putExtra("pos",position);
                            intent.putExtra("Name",NameMI);
                            intent.putExtra("Country",CountryMI);
                            intent.putExtra("Born",BornMI);
                            intent.putExtra("BirthPlace",BirthPlaceMI);
                            intent.putExtra("Role",RoleMI);
                            intent.putExtra("BatStyle",BatStyleMI);
                            intent.putExtra("BowStyle",BowStyleMI);
                            intent.putExtra("imgArr",imgArrMI);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();

                }
            });
        }
        else if(team.equals("LSG"))
        {
            adapter = new MyAdapter(ListView_Activity.this,imgArrLSG,NameLSG,PositionLSG);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(ListView_Activity.this);
                    builder.setTitle("Are you confirm go to new page ?");
                    builder.setIcon(R.drawable.img_25);
                    builder.setMessage("Are you confirm go to new page ?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent=new Intent(ListView_Activity.this,DetailsView_Activity.class);
                            intent.putExtra("pos",position);
                            intent.putExtra("Name",NameLSG);
                            intent.putExtra("Country",CountryLSG);
                            intent.putExtra("Born",BornLSG);
                            intent.putExtra("BirthPlace",BirthPlaceLSG);
                            intent.putExtra("Role",RoleLSG);
                            intent.putExtra("BatStyle",BatStyleLSG);
                            intent.putExtra("BowStyle",BowStyleLSG);
                            intent.putExtra("imgArr",imgArrLSG);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();

                }
            });
        }
    }
}