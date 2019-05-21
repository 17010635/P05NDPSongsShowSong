package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ModifyActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    TextView tvId;
    RadioButton rb0,rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        Intent i = getIntent();
        Song currSong =  (Song) i.getSerializableExtra("data");

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






    }
}
