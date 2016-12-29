package com.example.user.hobia;


import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by User on 24/10/2016.
 */
public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context mContext;
    int [] imageId;
    Button submit;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Context context, String[] NameList, int[] Images) {
        result= NameList;
        mContext=context;
        imageId=Images;
        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        TextView txtname;
        ImageView gambar;
        rowView = inflater.inflate(R.layout.activity_shop, null);
        txtname=(TextView) rowView.findViewById(R.id.textviewlist);
        gambar=(ImageView) rowView.findViewById(R.id.gambar);
        txtname.setText(result[position]);
        gambar.setImageResource(imageId[position]);
        submit = (Button) rowView.findViewById(R.id.buttonadd);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Buy"+result[position],Toast.LENGTH_SHORT).show();
                Intent pindahkeShoppingChart = new Intent(mContext, Shoppingcart.class);
                pindahkeShoppingChart.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(pindahkeShoppingChart);
            }
        });
       rowView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Toast.makeText(mContext, "Buy", Toast.LENGTH_LONG).show();

           }});
        return rowView;
    }
}
