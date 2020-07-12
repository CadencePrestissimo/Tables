package com.example.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView ls;

    public  void tables(int t)
      {
          ArrayList<String> tableland=new ArrayList<>();
          for(int i=1;i<=20;i++)
          {
          String s=Integer.toString(i*t);
          tableland.add(Integer.toString(t)+"*"+Integer.toString(i)+" = "+s);
          }
          ArrayAdapter <String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tableland){
              @Override
              public View getView(int position, View convertView, ViewGroup parent){
                  // Cast the list view each item as text view
                  TextView item = (TextView) super.getView(position,convertView,parent);
                  // Set the item text style to bold
                  item.setTypeface(item.getTypeface(), Typeface.BOLD);

                  // Change the item text size
                  item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
                  // return the view
                  return item;
              }
          };

          ls.setAdapter(arrayAdapter);
      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar sk=(SeekBar)findViewById(R.id.seekBar);
       ls=(ListView)findViewById(R.id.list);

        sk.setMax(40);
        sk.setProgress(20);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int tt;
                if(progress<min)
                {
                    tt=min;
                    sk.setProgress(min);
                }
                else
                {
                    tt=progress;
                }
                tables(tt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        tables(20);
    }
}