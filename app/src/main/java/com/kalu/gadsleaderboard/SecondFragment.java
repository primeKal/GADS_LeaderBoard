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

public class SecondFragment extends Fragment {
    private ProgressBar kProgressBarl;
    private RecyclerView kMyrecycler;
    private UsersRecyclerAdapter kMyuseradapter;
    private LinearLayoutManager kMylinear;
    ArrayList<Users> kMyusers;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kMyrecycler = view.findViewById(R.id.recycler_2);
        kProgressBarl=view.findViewById(R.id.progressBar2);
        getApireques();

    }

    private void getApireques() {


        try {
            URL myhours = ApiUtil.buildUrl("hours");
            new StudentsQuert().execute(myhours);

        } catch (Exception e)
        { e.printStackTrace();}

    }


    public class StudentsQuert extends AsyncTask<URL,Void,String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchurl=urls[0];
            String data=null;
            try {
                data = ApiUtil.getJason(searchurl);
            }catch (Exception e)
            {
                Log.d("error",e.getMessage());}
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
                kMyusers =ApiUtil.getStudentsFromHourJson(s);
                kMyuseradapter = new UsersRecyclerAdapter(getContext(), kMyusers,true);
                kMyrecycler.setAdapter(kMyuseradapter);
                kMyrecycler.setVisibility(View.VISIBLE);
                kProgressBarl.setVisibility(View.INVISIBLE);

            }

        }
    }
}
