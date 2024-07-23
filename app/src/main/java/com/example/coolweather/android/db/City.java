package com.example.coolweather.android.db;

import org.litepal.crud.LitePalSupport;

public class City extends LitePalSupport {
   private int id;
   private String cityName;
   private String provinceId;
   private int cityId;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getCityName() {
      return cityName;
   }

   public void setCityName(String cityName) {
      this.cityName = cityName;
   }

   public String getProvinceId() {
      return provinceId;
   }

   public void setProvinceId(String provinceId) {
      this.provinceId = provinceId;
   }

   public int getCityId() {
      return cityId;
   }

   public void setCityId(int cityId) {
      this.cityId = cityId;
   }
}
