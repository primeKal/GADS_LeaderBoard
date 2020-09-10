package com.kalu.gadsleaderboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kalu.gadsleaderboard.Adapters.UsersRecyclerAdapter;
import com.kalu.gadsleaderboard.Models.Users;
import com.kalu.gadsleaderboard.Utility.ApiUtil;

import java.net.URL;
import java.util.ArrayList;

public class FirstFragment extends Fragment {
     ArrayList<Users> myusers;

    private RecyclerView kMyrecycler;
    private ProgressBar kProgressBar;
    private UsersRecyclerAdapter kMyuseradapter;
    private LinearLayoutManager kMylinear;
    // type flag true equals skill, false equals hours
    private boolean typeflag=true;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kMyrecycler = view.findViewById(R.id.recyclerView);
        kProgressBar=view.findViewById(R.id.progressBar);
        getApireques();
    }



    private void getApireques() {


        try {
            URL myhours = ApiUtil.buildUrl("skilliq");
             new StudentsQuert().execute(myhours);

        } catch (Exception e)
        { e.printStackTrace();}

    }


    public class StudentsQuert extends AsyncTask<URL,Void,String>{

        @Override
        protected String doInBackground(URL... urls) {
           URL searchurl=urls[0];
            String data=null;
           try {
                data = ApiUtil.getJason(searchurl);
           }catch (Exception e)
           {Log.d("error",e.getMessage());}
           return data;
        }

        @Override
        protected void onPostExecute(String s) {

            if(s==null){
                kMyrecycler.setAdapter(null);
                Toast.makeText(getContext(),"failed check connection",Toast.LENGTH_SHORT).show();
            }else{
                kMylinear = new LinearLayoutManager(getContext());
                kMyrecycler.setLayoutManager(kMylinear);
                myusers=ApiUtil.getStudentsFromSkillJson(s);
                kMyuseradapter = new UsersRecyclerAdapter(getContext(),myusers,false);
                kMyrecycler.setAdapter(kMyuseradapter);
                kMyrecycler.setVisibility(View.VISIBLE);
                kProgressBar.setVisibility(View.INVISIBLE);


            }


        }
    }
}
