package com.example.sqlitegyminventory.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlitegyminventory.GymItemDatabaseHelper;
import com.example.sqlitegyminventory.R;
import com.example.sqlitegyminventory.adapters.GymItemAdapter;
import com.example.sqlitegyminventory.adapters.GymItemSelectedAdapter;
import com.example.sqlitegyminventory.model.GymItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GymItemAdapter.GymItemDelegate,
        GymItemSelectedAdapter.GymItemSelectedDelgate, SelectGymItemQuantityFragment.GymItemFragmentListener {

    private static String MAIN_KEY = "main_key";
    private GymItemDatabaseHelper gymItemDatabase;
    private List<String> gymItemList = new ArrayList<>();
    private List<GymItem> gymItemSelected = new ArrayList<>();

    private SelectGymItemQuantityFragment gymItemFragment = new SelectGymItemQuantityFragment();

    @BindView(R.id.gym_item_menu_recycleview)
    public RecyclerView gymItemRecyclerView;

    @BindView(R.id.gym_item_selected_recycleview)
    public RecyclerView gymItemSelectedRecyclerView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        gymItemList.add("Bar Bell");
        gymItemList.add("Weight Ball");
        gymItemList.add("Jump Rope");
        gymItemList.add("Weight Bench");
        gymItemList.add("Squat Rack");
        gymItemList.add("Bench Press");

        RecyclerView.ItemDecoration  decorater = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        gymItemRecyclerView.addItemDecoration(decorater);
        gymItemRecyclerView.setAdapter(new GymItemAdapter(gymItemList, this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        gymItemRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void viewGymItemSelected(GymItem gymItem) {

    }

    @Override
    public void deleteGymItem(GymItem gymItem) {

    }

    @Override
    public void viewGymItem(String gymItem) {
        Bundle bundle = new Bundle();
        bundle.putString(MAIN_KEY, gymItem);

        getSupportFragmentManager().
                beginTransaction().
                add(R.id.main_frame_layout,gymItemFragment).
                addToBackStack(gymItemFragment.getTag()).
                commit();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void makeToast(String quantity) {

    }
}
