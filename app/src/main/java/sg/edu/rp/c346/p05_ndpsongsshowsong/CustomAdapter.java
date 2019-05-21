package sg.edu.rp.c346.p05_ndpsongsshowsong;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songArray;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource,  objects);
        parent_context = context;
        layout_id = resource;
        songArray = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tVYear = rowView.findViewById(R.id.tVYear);
        TextView tVSong = rowView.findViewById(R.id.tVSong);
        TextView tVSinger = rowView.findViewById(R.id.tVSinger);

        Song currentTask = songArray.get(position);

        ArrayList<ImageView> imageViews = new ArrayList<>();

        ImageView imageView0 = rowView.findViewById(R.id.imageViewStar1);
        ImageView imageView1 = rowView.findViewById(R.id.imageViewStar2);
        ImageView imageView2 = rowView.findViewById(R.id.imageViewStar3);
        ImageView imageView3 = rowView.findViewById(R.id.imageViewStar4);
        ImageView imageView4 = rowView.findViewById(R.id.imageViewStar5);

        imageViews.add(imageView0);
        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);


        tVYear.setText(currentTask.getYear()+"");
        tVSinger.setText(currentTask.getSingers()+"");
        tVSong.setText(currentTask.getTitle()+"");

        for(int i  = 0; i < currentTask.getStar() ;i++){
            imageViews.get(i).setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }




}