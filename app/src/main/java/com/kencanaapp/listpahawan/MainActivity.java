package com.kencanaapp.listpahawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  ListView listView;

  String[] pahlawanNames = {"Ayam Penyet","Pecel Lele","Soto","Mie Ayam","Ayam Bakar","Ayam Geprek"};
  int[] pahlawanImage = {R.drawable.ayampenyet, R.drawable.pecellele, R.drawable.soto, R.drawable.mieayam, R.drawable.ayambakar, R.drawable.ayamgeprek                };
  String[] pahlawanDeskripsi = {
      "Ayam Penyet \n" +
        "DADA + Sambal Terasi \n" +
              "Harga :      25.000 \n",

      "Pecel Lele \n" +
              "1 Porsi + Sambal Terasi \n" +
                "Harga :      20.000 \n",


      "Soto Ayam \n" +
          "1 Porsi \n" +
            "Harga :      12.000 \n",

      "Mie Ayam \n" +
              "1 Porsi + Bakso \n" +
                "Harga :    22.000 \n",

      "  Ayam Bakar\n" +
              "DADA + Sambal Terasi\n" +
              "Harga :             30.000\n",

       "Ayam Geprek \n"   +
               "DADA + Sambal Bawang/Sambah Matah \n" +
                 "Harga :      19.500 \n",
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      //finding listview
    listView = findViewById(R.id.listview);

    CustomAdapter customAdapter = new CustomAdapter();
    listView.setAdapter(customAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getApplicationContext(),pahlawanNames[i],Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),Listdata.class);
        intent.putExtra("name",pahlawanNames[i]);
        intent.putExtra("image",pahlawanImage[i]);
        intent.putExtra("deskripsi",pahlawanDeskripsi[i]);
        startActivity(intent);

      }
    });


  }


  private class CustomAdapter extends BaseAdapter{
    @Override
    public int getCount() {
      return pahlawanImage.length;
    }

    @Override
    public Object getItem(int i) {
      return null;
    }

    @Override
    public long getItemId(int i) {
      return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
      //getting view in row_data
      TextView name = view1.findViewById(R.id.pahlawan);
      ImageView image = view1.findViewById(R.id.images);

      name.setText(pahlawanNames[i]);
      image.setImageResource(pahlawanImage[i]);
      return view1;
    }



  }
}
