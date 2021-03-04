package com.example.videomeeting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.videomeeting.R;
import com.example.videomeeting.utilities.Constants;

public class IncomingInvitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_invitation);

        ImageView imageMeetingType = findViewById(R.id.imageMeetingType);
        String meetingType = getIntent().getStringExtra(Constants.REMOTE_MSG_MEETING_TYPE);

        if (meetingType != null){
            if (meetingType.equals("video")){
                imageMeetingType.setImageResource(R.drawable.ic_video);
            }
        }

        TextView textFastChar = findViewById(R.id.textFastChar);
        TextView textUsername = findViewById(R.id.textUsername);
        TextView textEmail = findViewById(R.id.textEmail);

        String fastName = getIntent().getStringExtra(Constants.KEY_FIRST_NAME);
        if (fastName != null){
            textFastChar.setText(fastName.substring(0, 1));
        }

        textUsername.setText(String.format(
                "%s %s",
                fastName,
                getIntent().getStringExtra(Constants.KEY_LAST_NAME)
        ));

        textEmail.setText(getIntent().getStringExtra(Constants.KEY_EMAIL));
    }
}