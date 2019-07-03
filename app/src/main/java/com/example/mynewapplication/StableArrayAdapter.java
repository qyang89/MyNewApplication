package com.example.mynewapplication;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class StableArrayAdapter extends ArrayAdapter<Person> {
    //declare the init map used to keep track of data
    private HashMap<Person, Integer> idMap = new HashMap<>();

    //declare context and data to be available in the class scope
    Context context;
    List<Person> data;

    //create a constructor and pass values from constructor to the super class/parent
     StableArrayAdapter(Context context, List<Person> data) {
        super(context, R.layout.custom_layout, data);

    //init context and data
        this.context = context;
        this.data = data;

        for(int i = 0; i < data.size();i++) {
        idMap.put(data.get(i), i);
    }
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //declare and init LayoutInflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //DECLARE AND INIT THE VIEW WE WANT TO USE
        View itemView = inflater.inflate(R.layout.custom_layout,parent,false);

        //declare and init the children of the view (main view is custom_layout, buttons/texts are children view)
        TextView tvName = itemView.findViewById(R.id.tv_name);
        TextView tvDob = itemView.findViewById(R.id.tv_dob);
        ImageView ivImage = itemView.findViewById(R.id.iv_image);

        //get value/object at current position
        Person person = data.get(position);  //position variable comes from above code in the public view

        //use value/objects with children of the views
        tvName.setText(person.getName());
        tvDob.setText(person.getDob());

        //return the view
        return itemView;
    }

    @Override
    public long getItemId(int position) {
        Person item = getItem(position);
        return idMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
