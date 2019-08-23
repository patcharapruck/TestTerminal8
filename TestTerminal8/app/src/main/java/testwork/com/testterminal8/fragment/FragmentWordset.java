package testwork.com.testterminal8.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import testwork.com.testterminal8.R;
import testwork.com.testterminal8.adapter.WordSetAdapter;
import testwork.com.testterminal8.adapter.WordsAdapter;
import testwork.com.testterminal8.view.WordSetModelClass;
import testwork.com.testterminal8.view.WordsModelClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWordset extends Fragment {


    ArrayList<WordSetModelClass> items;
    WordSetAdapter adapter;
    RecyclerView recyclerView;

    public FragmentWordset() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_wordset, container, false);
        InitInstances(rootView);
        return rootView;
    }

    private void InitInstances(View rootView) {

        recyclerView = rootView.findViewById(R.id.recycler_view_wordset);
        setRecyclerView();
    }

    private void setRecyclerView() {

        items = new ArrayList<>();
        adapter = new WordSetAdapter(getContext(), items);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        String text[]= {"ห้องครัว","ห้องนอน","ห้องนั่งเล่น","ห้องน้ำ","สวนสัตว์","ที่ทำงาน"};
        int num[]={10,20,30,5,6,7};
        int status[]={0,0,1,0,1,1};

        for (int i=0;i<6;i++){
            items.add(new WordSetModelClass(text[i],num[i],status[i]));
            adapter.notifyDataSetChanged();
        }
    }

}
