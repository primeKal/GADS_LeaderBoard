package com.kalu.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kalu.gadsleaderboard.Models.Project;
import com.kalu.gadsleaderboard.Utility.JsonService;
import com.kalu.gadsleaderboard.Utility.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {
    Button kSubmit,kYsbutton;
    EditText kName,kLastname,kEmail,kGitlink;
    Dialog kDialog;
    Toolbar kToolbar;
    Context kContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        kToolbar=findViewById(R.id.toolbarsubmitactivity);
        setSupportActionBar(kToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        kDialog=new Dialog(this);
        kEmail=findViewById(R.id.email);
        kLastname=findViewById(R.id.lastname);
        kName=findViewById(R.id.firstname);
        kGitlink=findViewById(R.id.gitlink);
        kContext=getApplicationContext();


        kSubmit=findViewById(R.id.submitbutton);
        kSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayareyousure();
            }
        });

    }

    private void displayareyousure() {
        kDialog.setContentView(R.layout.questiondialoge);
        kDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        kDialog.show();
       kYsbutton=kDialog.findViewById(R.id.yesbutton);
        ImageButton close=kDialog.findViewById(R.id.imageView3close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kDialog.dismiss();
            }
        });
       kYsbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Project myproject=new Project(kName.getText().toString(),
                       kLastname.getText().toString(),
                       kGitlink.getText().toString(),
                       kEmail.getText().toString());
               intiateformsubmission(myproject);
           }
       });
    }

    private void intiateformsubmission(Project myproject) {
        //where we call retrofit service builder and enque the call

        JsonService myjsonservice=ServiceBuilder.buildservice(JsonService.class);
        Call<Project> mycall=myjsonservice.setProject(myproject.getFirstname(),
                myproject.getEmailaddress(),
                myproject.getLastname(),
                myproject.getGithublink());
        mycall.enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                Dialog my=new Dialog(kDialog.getContext());
                kDialog.dismiss();
                my.setContentView(R.layout.succes_dialgue);
                my.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                my.show();
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                Dialog my=new Dialog(kDialog.getContext());
                kDialog.dismiss();
                my.setContentView(R.layout.submissionfailure);
                my.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                my.show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,TabLayOut.class));
    }
}
