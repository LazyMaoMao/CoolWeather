package com.example.coolweather.android.util;

import android.text.TextUtils;

import com.example.coolweather.android.db.City;
import com.example.coolweather.android.db.County;
import com.example.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = new getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }
        return false;
    }

    public static boolean handCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities=new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityId(cityObject.getInt("id"));
                    city.setProvinceId("provinceId");
                    city.save();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
    public boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for (int i = 0; i <allCounties.length() ; i++) {
                JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                        return true;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    private static class getJSONObject extends JSONObject {
        public getJSONObject(int i) {
        }
    }
}
