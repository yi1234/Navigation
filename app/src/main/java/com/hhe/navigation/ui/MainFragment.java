package com.hhe.navigation.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hhe.navigation.BR;
import com.hhe.navigation.R;
import com.hhe.navigation.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {


    private FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("onAttach","onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setLifecycleOwner(this);
        binding.setVariable(BR.event, new MyOnClick());
        Log.d("onCreateView","onCreateView");
        return binding.getRoot();
    }


    private List<TextView> textViewList = new ArrayList<>();
    private List<ImageView> imageViewList = new ArrayList<>();
    private FragmentManager mFragmentManager;

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onStart","onStart");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("onViewCreated","onViewCreated");
        textViewList.clear();
        imageViewList.clear();
        textViewList.add(binding.tvVideo);
        textViewList.add(binding.tvRelease);
        textViewList.add(binding.tvMine);
        imageViewList.add(binding.ivVideo);
        imageViewList.add(binding.ivRelease);
        imageViewList.add(binding.ivMine);
        mFragmentManager = getChildFragmentManager();
        showFragment(preTab);
    }

    HomeFragment homeFragment;
    ThemeFragment themeFragment;
    MineFragment mineFragment;
    int preTab = 0;//记录当前选中position位置

    public void showFragment(int i) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        hideFragments(ft);
        updateTab();
        preTab = i;
        switch (i) {
            case 0:
                if (homeFragment != null)
                    ft.show(homeFragment);
                    // 否则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
                else {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.framelayout, homeFragment);
                }
                selectedPosition(0);
                break;
            case 1:
                if (themeFragment != null)
                    ft.show(themeFragment);
                    // 否则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
                else {
                    themeFragment = new ThemeFragment();
                    ft.add(R.id.framelayout, themeFragment);
                }
                selectedPosition(1);
                break;
            case 2:
                if (mineFragment != null)
                    ft.show(mineFragment);
                    // 否则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
                else {
                    mineFragment = new MineFragment();
                    ft.add(R.id.framelayout, mineFragment);
                }
                selectedPosition(2);
                break;
        }
        ft.commit();
    }

    //隐藏fragment;
    private void hideFragments(FragmentTransaction ft) {
        if (ft != null) {
            if (homeFragment != null) {
                ft.hide(homeFragment);
            }
            if (themeFragment != null) {
                ft.hide(themeFragment);
            }
            if (mineFragment != null) {
                ft.hide(mineFragment);
            }
        }
    }

    //切换tab时更新ui；
    private void updateTab() {
        for (int i = 0; i < textViewList.size(); i++) {
            textViewList.get(i).setSelected(false);
            imageViewList.get(i).setSelected(false);
        }
    }

    private void selectedPosition(int position) {
        for (int i = 0; i < textViewList.size(); i++) {
            if (i == position) {
                textViewList.get(i).setSelected(true);
                imageViewList.get(i).setSelected(true);
            }
        }
    }

    public class MyOnClick {

        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ll_video:
                    showFragment(0);
                    break;
                case R.id.ll_release:
                    showFragment(1);
                    break;
                case R.id.ll_mine:
                    showFragment(2);
                    break;
            }
        }
    }


}