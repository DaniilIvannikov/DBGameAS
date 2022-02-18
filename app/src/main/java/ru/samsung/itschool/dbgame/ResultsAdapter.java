package ru.samsung.itschool.dbgame;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsAdapter extends BaseAdapter {
    ArrayList<Result> results;
    Context context;

    ResultsAdapter(Context context, ArrayList<Result> results){
        this.results = new ArrayList(results);
        this.context = context;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_element, null);
        TextView textView = view.findViewById(R.id.name);
        textView.setText(results.get(position).name);
        textView = view.findViewById(R.id.score);
        textView.setText(String.valueOf(results.get(position).score));
        if (results.get(position).score <= 500){
            textView.setTextColor(Color.RED);
        }

        return view;
    }
}
