package com.example.sunhacks_patch1;

import android.graphics.Camera;
import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FetchData extends AsyncTask<Object,String,String> {
    String googleNearByPlaces;
    GoogleMap gMap;
    String url;




    @Override
    protected void onPostExecute(String s) {
//        try{
//            JSONObject jsonObject = new JSONObject(s);
//            JSONArray jsonArray = jsonObject.getJSONArray("results");


//            for(int i=0;i<list.size();i++)
//            {
////                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
////                JSONObject getLocation = jsonObject1.getJSONObject("geometry").getJSONObject("location");
////
////                String lat = getLocation.getString("lat");
////                String lng = getLocation.getString("lng");
////
////                JSONObject getName = jsonArray.getJSONObject(i);
////                String name = getName.getString("name");
////
////
////                LatLng latLng =  new LatLng(Double.parseDouble(lat),Double.parseDouble(lng));
//                MarkerOptions markerOptions =  new MarkerOptions();
////                markerOptions.title(name);
//                markerOptions.position(list.get(i));
//                gMap.addMarker(markerOptions);
//
//            }
//        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected String doInBackground(Object... objects) {

        try
        {
            gMap = (GoogleMap) objects[0];
            url  = (String) objects[1];
            DownloadUrl downloadUrl =  new DownloadUrl();
            googleNearByPlaces =  downloadUrl.retrieveUrl(url);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return googleNearByPlaces;
    }
}
