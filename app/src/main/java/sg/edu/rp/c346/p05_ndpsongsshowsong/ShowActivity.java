package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ListView lvSongs;
    Button btn5Stars;
    Spinner spnYear;
    ArrayList<Song> sl;
    CustomAdapter ca;
    ArrayList<Integer> years;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        Toast.makeText(ShowActivity.this, "Showing Songs", Toast.LENGTH_SHORT).show();

        lvSongs = findViewById(R.id.lvSongs);
        btn5Stars = findViewById(R.id.btn5Stars);
        spnYear = findViewById(R.id.spnYear);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowActivity.this);
                sl.clear();
                sl.addAll(dbh.getAllSong());
                ArrayList<Song> temp = new ArrayList<>();

                for (int i = 0; i < sl.size(); i++) {
                    Song currSong = sl.get(i);
                    if (currSong.getStar() == 5) {
                        temp.add(currSong);
                    }
                }

                sl.clear();
                sl.addAll(temp);
                ca.notifyDataSetChanged();
                dbh.close();

            }
        });

        ArrayList<Integer> getYears = new ArrayList<>();
        years = new ArrayList<>();
        years.add(0);
        DBHelper dbh = new DBHelper(ShowActivity.this);
        getYears = dbh.getYear();
        for (int i = 0; i < getYears.size(); i++) {
            years.add(getYears.get(i));
        }

        ArrayAdapter<Integer> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, years);
        spnYear.setAdapter(aa);


        sl = dbh.getAllSong();
        ca = new CustomAdapter(ShowActivity.this, R.layout.show_row, sl);
        lvSongs.setAdapter(ca);

        dbh.close();


        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(ShowActivity.this,
                        ModifyActivity.class);
                Song data = sl.get(position);
                i.putExtra("data", data);
                startActivityForResult(i, 9);
            }
        });

        spnYear.setOnItemSelectedListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9) {
            Toast.makeText(ShowActivity.this, "Updating list", Toast.LENGTH_SHORT).show();

            sl.clear();
            DBHelper dbh = new DBHelper(ShowActivity.this);
            sl.addAll(dbh.getAllSong());
            ca.notifyDataSetChanged();
            dbh.close();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        DBHelper dbh = new DBHelper(ShowActivity.this);
        int selectedYear = years.get(position);
        if(selectedYear == 0){
            sl.clear();
            sl.addAll(dbh.getAllSong());
            ca.notifyDataSetChanged();
            dbh.close();
            return;
        }
        sl.clear();

        sl.addAll(dbh.getAllYear(selectedYear));
        ca.notifyDataSetChanged();
        dbh.close();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}
