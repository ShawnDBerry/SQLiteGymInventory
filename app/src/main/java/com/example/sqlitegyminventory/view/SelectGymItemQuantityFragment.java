package com.example.sqlitegyminventory.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqlitegyminventory.GymItemDatabaseHelper;
import com.example.sqlitegyminventory.R;
import com.example.sqlitegyminventory.model.GymItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectGymItemQuantityFragment extends Fragment {
    public static String FRAG_KEY = "frag_key";

    public interface GymItemFragmentListener{
        void makeToast(String quantity);
    }

    private GymItemFragmentListener gymItemFragmentListener;
    private GymItemDatabaseHelper gymItemDatabase;

    @BindView(R.id.gym_item_title_textview)
    TextView gymItemFragmentTitle;

    @BindView(R.id.gym_item_quantity_editview)
    EditText gymItemFragmentQuantity;

    @BindView(R.id.gym_item_amount_button)
    Button gymItemAmountButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_gym_item_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        GymItem gymItem = (GymItem) getArguments().getParcelable(FRAG_KEY);
        if(gymItem != null){
            gymItemFragmentTitle.setText(gymItem.getGymItemName());

        }

        gymItemAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gymItemFragmentQuantity.setText(gymItemFragmentQuantity.getText().toString().trim());
                gymItemFragmentListener.makeToast(gymItem.getGymItemQuantity());
            }
        });

    }

    @OnClick(R.id.close_icon_imageview)
    public void closeFragment(View view){
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TAG_Q", "Attach the Quantity");

        if(context instanceof MainActivity){
            this.gymItemFragmentListener = (MainActivity)context;
        }
    }
}
