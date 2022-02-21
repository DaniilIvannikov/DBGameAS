package ru.samsung.itschool.dbgame;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HoFActivity extends Activity {

	private DBManager dbManager;
	RecyclerView recyclerView;
	ResultsRVAdapter rvAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT);
		setContentView(R.layout.activity_ho_f);
		dbManager = DBManager.getInstance(this);
		
		recyclerView = this.findViewById(R.id.recyclerView);
		ArrayList<Result> results = dbManager.getAllResults();
		ArrayList resStrings = new ArrayList();
		for (int i = 0; i < results.size(); i++) {
			resStrings.add(results.get(i).name + ": " + results.get(i).score + "\n");
		}
		rvAdapter = new ResultsRVAdapter(getApplicationContext(), results);
		recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		recyclerView.setAdapter(rvAdapter);

	}
}
