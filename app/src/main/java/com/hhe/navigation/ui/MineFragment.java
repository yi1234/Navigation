package com.hhe.navigation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hhe.navigation.R;
import com.hhe.navigation.databinding.FragmentMineBinding;


public class MineFragment extends Fragment {


    private FragmentMineBinding dataBinding;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        dataBinding.setLifecycleOwner(getViewLifecycleOwner());
        dataBinding.setVariable(BR.onClick,new MyClick());
        return dataBinding.getRoot();
    }

    public class MyClick {
        public void toSetting() {
            Navigation.findNavController(getView()).navigate(R.id.action_mine_to_setting);
        }

        public void toCard(View view) {
            Navigation.findNavController(getView()).navigate(R.id.action_mine_to_card);
        }

        public void toMoney(View view) {
            Navigation.findNavController(getView()).navigate(R.id.action_mine_to_money);
        }

    }
}