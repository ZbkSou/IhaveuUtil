package com.ihaveu.bc.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ihaveu.bc.base.BaseApplication;

public class SharedpreferenceUtil {

    private static final String FILE_NAME = "SharedPreference_files";
    private static Context context = BaseApplication.getContext();
    private static SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,
            Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor = sharedPreferences.edit();

    public static void saveData(String key, Object value) {
        String type = value.getClass().getSimpleName();
        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    public static Object getData(String key,Object defValue){
        String type = defValue.getClass().getSimpleName();
        if("Integer".equals(type)){
            return sharedPreferences.getInt(key, (Integer) defValue);
        }else if("Boolean".equals(type)){
            return sharedPreferences.getBoolean(key, (Boolean) defValue);
        }else if("String".equals(type)){
            return sharedPreferences.getString(key, (String) defValue);
        }else if("Float".equals(type)){
            return sharedPreferences.getFloat(key, (Float) defValue);
        }else if("Long".equals(type)){
            return sharedPreferences.getLong(key, (Long) defValue);
        }
        return null;
    }

    public static void clearData(String key){
        editor.remove(key);
        editor.apply();
    }

    public static void clearAllData(){
        editor.clear();
        editor.apply();
    }

}
