package tdc.edu.vn.test.GiaoDien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.Adapter.MyRecyclerViewAdapter;
import tdc.edu.vn.test.Model.CardViewModel;

public class MainRecyclerView extends AppCompatActivity {
    private Vector<CardViewModel> data;
    RecyclerView recyclerView;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Initiation of data
        data = new Vector<CardViewModel>();
        data.add(new CardViewModel("phieu 1", R.layout.listview_item));
        data.add(new CardViewModel("phieu 2", R.layout.listview_item));


        //Setup Recycler View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.card_view_layout, data);
        recyclerView.setAdapter(adapter);
    }
}
