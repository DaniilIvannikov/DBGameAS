package ru.samsung.itschool.dbgame;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HoFActivity extends Activity {

	private DBManager dbManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT);
		setContentView(R.layout.activity_ho_f);
		dbManager = DBManager.getInstance(this);
		
		ListView listView = this.findViewById(R.id.listView);
		ArrayList<Result> results = dbManager.getAllResults();
		ArrayList resStrings = new ArrayList();
		for (int i = 0; i < results.size(); i++) {
			resStrings.add(results.get(i).name + ": " + results.get(i).score + "\n");
		}
		listView.setAdapter(new ResultsAdapter(getApplicationContext(), results));

	}
}
