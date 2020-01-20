package com.biwash.notificationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biwash.notificationproject.createChannel.CreateChannel;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NotificationManagerCompat notificationManagerCompat;
    Button btnFirst,btnSecond;
    Button btnBasicInlineReply;
    TextView txtReplied;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       notificationManagerCompat=NotificationManagerCompat.from(this);
        btnFirst=findViewById(R.id.btnFirst);
        btnSecond=findViewById(R.id.btnSecond);
        btnBasicInlineReply = (Button) findViewById(R.id.btn_inline_replies_with_history);
        txtReplied = (TextView) findViewById(R.id.txt_inline_reply);
        btnBasicInlineReply.setOnClickListener(this);

        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNoti();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNoti1();
            }
        });
    }

    private void DisplayNoti(){
        Notification notification=new NotificationCompat.Builder(this
        ,CreateChannel.channel_1)
                .setSmallIcon(R.drawable.ic_directions_car_black_24dp)
                .setContentTitle("First Message")
                .setContentText("Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
       notificationManagerCompat.notify(null,1,notification);
    }

    private void DisplayNoti1(){
        Notification notification=new NotificationCompat.Builder(this
                ,CreateChannel.channel_2)
                .setSmallIcon(R.drawable.ic_directions_car_black_24dp)
                .setContentTitle("First Message")
                .setContentText("Message Body 1")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(null,2,notification);
    }

    @Override
    public void onClick(View v) {

    }
}
