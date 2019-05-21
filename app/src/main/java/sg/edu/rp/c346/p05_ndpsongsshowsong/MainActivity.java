package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

                DBHelper db = new DBHelper(MainActivity.this);
                int year = Integer.parseInt(etYear.getText().toString());
                int star = Integer.parseInt(etYear.getText().toString());
                db.insertSong(etSong.getText().toString(), etSingers.getText().toString(), year, star);
            }
        });



    }
}
