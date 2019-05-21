package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsertNote, btnShowList;
    EditText etSong;
    EditText etSingers;
    EditText etYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertNote = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);
        etSong = findViewById(R.id.editTextSong);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RadioGroup rg = findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);

                if(etSong.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Add A Song Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etSingers.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Add A Singer", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etYear.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Add A Year", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rb==null){
                    Toast.makeText(MainActivity.this, "Choose a ratings", Toast.LENGTH_SHORT).show();
                    return;
                }




                DBHelper db = new DBHelper(MainActivity.this);
                int year = Integer.parseInt(etYear.getText().toString());
                int star = Integer.parseInt(rb.getText().toString());
                db.insertSong(etSong.getText().toString(), etSingers.getText().toString(), year, star);
                db.close();


                Toast.makeText(MainActivity.this, "Song Added", Toast.LENGTH_SHORT).show();


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),  ShowActivity.class);

                startActivity(i);
            }
        });
        };

    }

