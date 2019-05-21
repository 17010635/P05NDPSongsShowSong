package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifyActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    TextView tvId;
    RadioButton rb0,rb1,rb2,rb3,rb4;
    Button btnUpdate, btnDelete,btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        Toast.makeText(ModifyActivity.this, "Updating Song", Toast.LENGTH_SHORT).show();

        final Intent i = getIntent();
        final Song currSong =  (Song) i.getSerializableExtra("data");

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        tvId = findViewById(R.id.tvID);

        etYear.setText(currSong.getYear()+"");
        etSinger.setText(currSong.getSingers());
        etTitle.setText(currSong.getTitle());
        tvId.setText(currSong.getId()+"");

        rb0 = findViewById(R.id.rb1Star);
        rb1 = findViewById(R.id.rb2Star);
        rb2 = findViewById(R.id.rb3Star);
        rb3 = findViewById(R.id.rb4Star);
        rb4 = findViewById(R.id.rb5Star);

        ArrayList<RadioButton> radioButtons = new ArrayList<>();

        radioButtons.add(rb0);
        radioButtons.add(rb1);
        radioButtons.add(rb2);
        radioButtons.add(rb3);
        radioButtons.add(rb4);

        radioButtons.get(currSong.getStar()-1).setChecked(true);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.rgStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);




                if(etTitle.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ModifyActivity.this, "Song Title Can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etSinger.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ModifyActivity.this, "Singer Field Can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etYear.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ModifyActivity.this, "Year is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBHelper dbh = new DBHelper(ModifyActivity.this);

                int year = Integer.parseInt(etYear.getText().toString());
                int star = Integer.parseInt(rb.getText().toString());
                Song song = new Song(currSong.getId(),etTitle.getText().toString(),etSinger.getText().toString(),year,star);
                dbh.updateSong(song);
                dbh.close();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                Toast.makeText(ModifyActivity.this, "Updating Song Record", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                dbh.deleteSong(currSong.getId());
                dbh.close();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                Toast.makeText(ModifyActivity.this, "Deleting Song Record", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}
