package sg.edu.c346.id21010771.problemstatementp09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    Button btnStar;
    ListView lvSongs;
    ArrayList<Song> alSongs;
    ArrayAdapter aaSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ndpsongsdisplay);

        btnStar = findViewById(R.id.btnStar);
        lvSongs = findViewById(R.id.lvSongs);
        alSongs = new ArrayList<Song>();
        aaSongs = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, alSongs);
        lvSongs.setAdapter(aaSongs);

        DBHelper dbh = new DBHelper(SongsActivity.this);
        alSongs.clear();
        alSongs.addAll(dbh.getAllSongs());
        aaSongs.notifyDataSetChanged();

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(SongsActivity.this);
                alSongs.clear();
                int filterText = 5;
                alSongs.addAll(dbh.getStarSongs(filterText));
                aaSongs.notifyDataSetChanged();
            }
        });

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Song data = alSongs.get(position);
                Intent i = new Intent(SongsActivity.this, MainActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(SongsActivity.this);
        alSongs.clear();
        alSongs.addAll(dbh.getAllSongs());
        aaSongs.notifyDataSetChanged();
    }
}
