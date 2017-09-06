package com.example.mine.chatapp;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eraky on 8/28/2017.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.MyViewHolder> {
    ArrayList<Employee> employees;
    Context context;
    public CustomRecyclerViewAdapter( Context context,ArrayList<Employee> employees) {
        this.employees = employees;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.one_user_in_list,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final String name=employees.get(position).name;
        holder.section.setText(employees.get(position).sectionName);
        holder.name.setText(name);
        holder.department.setText(employees.get(position).departmentName);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Welcome to Mr "+ name,Toast.LENGTH_SHORT).show();;
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,department,section;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            name =(TextView) itemView.findViewById(R.id.Name);
            department =(TextView) itemView.findViewById(R.id.Department);
            section =(TextView) itemView.findViewById(R.id.Section);
            view=itemView;

        }
    }
}
