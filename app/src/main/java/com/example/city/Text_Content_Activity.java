package com.example.city;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {

private ActionBar actionBar;
    private TextView text_content;
    //private TextView text_content1;//
    private ImageView iContent;
    private int category=0;
    private int position=0;
    private int [] array_places={R.string.places1,R.string.places2,R.string.places3, R.string.places4,  R.string.places5, R.string.places6,R.string.places7,R.string.places8,R.string.places9,R.string.places10};
    private int [] array_image={R.drawable.eiffel,R.drawable.louvre,R.drawable.notredame,R.drawable.arch,R.drawable.moulin,R.drawable.sacrecoeur2,R.drawable.panteon,R.drawable.garden2,R.drawable.garden,R.drawable.opera};
    private String [] array_title_places={"Эйфелева башня","Лувр","Нотр-Дам-де-Пари","Триумфальная арка","Мулен Руж","Сакре-Кер","Пантеон","Люксембургский сад","Люксембургский дворец","Опера Гарнье"};
    private int [] array_about={R.string.about1,R.string.about2,R.string.about3,R.string.about4,R.string.about5,R.string.about6};
    private int [] array_image1={R.drawable.population,R.drawable.geo,R.drawable.climat,R.drawable.arrondissement,R.drawable.shema_metro_parizha,R.drawable.food};
    private String [] array_title_about={"Население", "Географическое положение", "Климат", "Административное деление", "Общественный транспорт","Еда"};

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        //text_content1 = findViewById(R.id.text_main_content1);//
        actionBar=getSupportActionBar();
        reciveIntent();
    }
    private void reciveIntent()
    {
        Intent i=getIntent();
        if(i!=null)
        {
         category=i.getIntExtra("category",0);
         position=i.getIntExtra("position",0);
        }
        switch (category)
        {
            case 0:
                iContent.setImageResource(array_image[position]);
text_content.setText(array_places[position]);
actionBar.setTitle(array_title_places[position]);
                break;
            case 1:
                iContent.setImageResource(array_image1[position]);
 text_content.setText(array_about[position]);
 actionBar.setTitle(array_title_about[position]);
                break;
            //case 2:
//text_content1.setImageResource(array_image[position]);//
                //break;
        }
    }


}
