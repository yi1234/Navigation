package com.hhe.navigation.manager;

import com.tencent.mmkv.MMKV;

public class UserManager {
    MMKV mmkv = MMKV.defaultMMKV();

    public static UserManager userManager;

    public static UserManager getInstance(){
        if(userManager == null){
            synchronized (UserManager.class){
                if(userManager == null){
                    userManager = new UserManager();
                }
            }
        }
        return userManager;
    }

    public boolean isLogin(){
        return mmkv.getBoolean("isLogin",false);
    }

    public boolean isFrist(){
        return mmkv.getBoolean("isFrist",true);
    }
}
