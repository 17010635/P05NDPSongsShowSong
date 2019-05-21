package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ShowActivity extends AppCompatActivity {

    ListView lvSongs;
    Button btn5Stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lvSongs = findViewById(R.id.lvSongs);
        btn5Stars = findViewById(R.id.btn5Stars);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
