package ru.samsung.itschool.dbgame;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultsRVAdapter extends RecyclerView.Adapter<ResultsRVAdapter.ResultsViewHolder> {
    ArrayList<Result> results;
    Context context;

    ResultsRVAdapter(Context context, ArrayList<Result> results){
        //Log.d("Biggg", results.toString());
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ResultsRVAdapter.ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view_element, parent, false);
        ResultsViewHolder viewHolder = new ResultsViewHolder(v);
        Toast.makeText(context, "robit?", Toast.LENGTH_SHORT).show();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsRVAdapter.ResultsViewHolder holder, int position) {
        Result r = results.get(position);
        holder.bind(r.name, String.valueOf(r.score));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ResultsViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView scoreTextView;

        public ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            scoreTextView = itemView.findViewById(R.id.score);
        }
        void bind(String name, String score){
            nameTextView.setText(name);
            scoreTextView.setText(score);
        }


    }
}
