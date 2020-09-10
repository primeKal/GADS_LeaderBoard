package com.kalu.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kalu.gadsleaderboard.Models.Project;

public class SubmitActivity extends AppCompatActivity {
    Button kSubmit,kYsbutton;
    EditText kName,kLastname,kEmail,kGitlink;
    Dialog kDialog;
    Toolbar kToolbar;

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
        kDialog.dismiss();
        Dialog my=new Dialog(this);
        my.setContentView(R.layout.succes_dialgue);
        my.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        my.show();
        TextView s=my.findViewById(R.id.love);
        s.setText(myproject.getEmailaddress());
    }
}
