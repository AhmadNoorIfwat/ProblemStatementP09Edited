package sg.edu.c346.id21010771.problemstatementp09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvSongID, tvSongTitle, tvSingers, tvYear, tvStars;
    EditText etSongID, etSongTitle, etSingers, etYear;
    RadioGroup rgStars;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnInsert, btnShowList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSongID = findViewById(R.id.tvSongID);
        tvSongTitle = findViewById(R.id.tvSongTitle);
        tvSingers = findViewById(R.id.tvSingerName);
        tvYear = findViewById(R.id.tvYear);
        etSongID = findViewById(R.id.etSongID);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingerName);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String title = etSongTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int rgSelect = rgStars.getCheckedRadioButtonId();
                rb1 = findViewById(rgSelect);
                rb2 = findViewById(rgSelect);
                rb3 = findViewById(rgSelect);
                rb4 = findViewById(rgSelect);
                rb5 = findViewById(rgSelect);
                int stars1 =  Integer.parseInt(rb1.getText().toString());
                int stars2 =  Integer.parseInt(rb2.getText().toString());
                int stars3 =  Integer.parseInt(rb3.getText().toString());
                int stars4 =  Integer.parseInt(rb4.getText().toString());
                int stars5 =  Integer.parseInt(rb5.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title, singers, year, stars5);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(i);
            }
        });
    }
}