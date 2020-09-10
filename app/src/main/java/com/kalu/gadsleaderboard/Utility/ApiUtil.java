package com.kalu.gadsleaderboard.Utility;

import android.util.Log;

import com.kalu.gadsleaderboard.Models.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiUtil {
    private ApiUtil(){}

    public static final String BASE_API_URL=" https://gadsapi.herokuapp.com";

    public static URL buildUrl(String typeflag){
        String fullUrl=BASE_API_URL+"/api/"+typeflag;
        URL url=null;
        try {
            url = new URL(fullUrl);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
    public static String getJason(URL url) throws IOException {

        HttpURLConnection connection=(HttpURLConnection)url.openConnection();

        try {
            InputStream stream=connection.getInputStream();
            Scanner scanner=new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasData = scanner.hasNext();
            if (hasData) {
                return scanner.next();
            } else return null;}
        catch (Exception e){
            Log.d("error",e.getMessage());
            return null;}
        finally {
            connection.disconnect();
        }
        }
        public static ArrayList<Users> getStudentsFromSkillJson(String jason){
        final String NAME="name";
        final String COUNTRY="country";
        final String SCORE="score";
        final String BADGEURL="badgeUrl";

        ArrayList<Users> allUsers=new ArrayList<Users>();
        try{
            JSONArray arrayusers= new JSONArray(jason);
            int numberofusers=arrayusers.length();
            for(int i=0;i<numberofusers;i++){
                JSONObject userjson=arrayusers.getJSONObject(i);
                Users user=new Users(userjson.getString(NAME),
                        userjson.getString(COUNTRY),
                        0,userjson.getInt(SCORE),
                        userjson.getString(BADGEURL));
                allUsers.add(user);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return allUsers;
        }
    public static ArrayList<Users> getStudentsFromHourJson(String jason){
        final String NAME="name";
        final String COUNTRY="country";
        final String HOUR="hours";
        final String BADGEURL="badgeUrl";

        ArrayList<Users> allUsers=new ArrayList<Users>();
        try{
            JSONArray arrayusers= new JSONArray(jason);
            int numberofusers=arrayusers.length();
            for(int i=0;i<numberofusers;i++){
                JSONObject userjson=arrayusers.getJSONObject(i);
                Users user=new Users(userjson.getString(NAME),
                        userjson.getString(COUNTRY)
                        ,userjson.getInt(HOUR),0,
                        userjson.getString(BADGEURL));
                allUsers.add(user);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return allUsers;

    }

}
