package testwork.com.testterminal8.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import testwork.com.testterminal8.R;
import testwork.com.testterminal8.view.WordSetModelClass;

public class WordSetAdapter extends RecyclerView.Adapter<WordSetAdapter.CustomViewWordSet>{

    private Context context;
    private ArrayList<WordSetModelClass> items;

    public WordSetAdapter(Context context, ArrayList item){
        this.context = context;
        this.items = item;
    }


    @NonNull
    @Override
    public CustomViewWordSet onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewWordSet(LayoutInflater.from(context).inflate(R.layout.customview_list2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewWordSet customViewWords, int i) {

        customViewWords.Tv_word.setText(items.get(i).getWoed());
        customViewWords.Tv_numWords.setText(String.valueOf(items.get(i).getNum()));
        int status = items.get(i).getStatus();

        if(status==0){
            customViewWords.Status.setCardBackgroundColor(Color.WHITE);
        }else {
            customViewWords.Status.setCardBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class CustomViewWordSet extends RecyclerView.ViewHolder{

        TextView Tv_word,Tv_numWords;
        CardView Status;

        public CustomViewWordSet(@NonNull View itemView) {
            super(itemView);

            Tv_word = (TextView)itemView.findViewById(R.id.tv_words);
            Tv_numWords = (TextView)itemView.findViewById(R.id.numwords);
            Status = (CardView)itemView.findViewById(R.id.cv_statuswords);
        }
    }
}
