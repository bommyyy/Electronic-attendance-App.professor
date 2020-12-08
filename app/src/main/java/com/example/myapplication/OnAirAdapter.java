//package com.example.myapplication;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//
//public class OnAirAdapter
//        extends ArrayAdapter<String>
//
//{
//    Context context;
//    String[] stuNo;
//    String[] stuName;
//    int[] btnO;
//    int[] btnA;
//    int[] btnX;
//
//    public OnAirAdapter(Context context, String[] stuNo, String[] stuName, int[] btnO, int[] btnA, int[] btnX){
//        super(context,R.layout.onairlist,R.id.txt_name2,stuName);
//        this.context=context;
//        this.stuNo=stuNo;
//        this.stuName=stuName;
//        this.btnO=btnO;
//        this.btnA=btnA;
//        this.btnX=btnX;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View view = convertView;
//        OnAirData holder = null;
//        if(view ==null){
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = layoutInflater.inflate(R.layout.onairlist,parent,false);
//            holder = new OnAirData(view);
//            view.setTag(holder);
//        }
//        else{
//            holder= (OnAirData) view.getTag();
//        }
//
//        holder.stu_no.setText(stuNo[position]);
//        holder.stu_name.setText(stuName[position]);
//        holder.btn_o.setImageResource(btnO[position]);
//        holder.btn_a.setImageResource(btnA[position]);
//        holder.btn_x.setImageResource(btnX[position]);
//
//
//        return view;
//
//
//    }
//}
