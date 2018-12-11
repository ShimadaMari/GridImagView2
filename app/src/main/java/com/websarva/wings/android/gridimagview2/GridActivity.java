package com.websarva.wings.android.gridimagview2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private GridAdapter gridAdapter;
    //private static final int REQUEST_CODE_PERMISSION = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){

         if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission
                 .READ_EXTERNAL_STORAGE)){

          }else {

          ActivityCompat.requestPermissions(this,new String[]{Manifest.permission
                  .READ_EXTERNAL_STORAGE},200);


         }
        }else {
            gridView = findViewById(R.id.gridView);

            List<String> imgFilePaths = new ArrayList<String>();
            File[] imgFiles = new File("/storage/emulated/0/Nikon_WU/Card/D20170722_001/101NIKON").listFiles();
            for(File imgFile : imgFiles){
                imgFilePaths.add(imgFile.getAbsolutePath());
            }

         gridAdapter = new GridAdapter(this,R.layout.grid_item,imgFilePaths);
         gridView.setAdapter(gridAdapter);


        }


    }
}
