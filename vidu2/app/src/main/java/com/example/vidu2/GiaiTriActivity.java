package com.example.vidu2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class GiaiTriActivity extends AppCompatActivity {
    Button btnPhatVideo,btnStopVideo,btnPhatMusic,btnStopMusic, btnTroVe;
    VideoView vvMP4;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_tri);
        this.setTitle("Giai tri");
        btnPhatVideo=findViewById(R.id.btnPhatVideo);
        btnStopVideo=findViewById(R.id.btnStopVideo);
        btnPhatMusic=findViewById(R.id.btnPhatMusic);
        btnStopMusic=findViewById(R.id.btnStopMusic);
        btnTroVe=findViewById(R.id.btnTroVe_Giaitri);
        vvMP4=findViewById(R.id.vvMP4);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnPhatVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvMP4.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dat_nuoc_tinh_yeu));
                vvMP4.start();
            }
        });
        btnStopVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvMP4.stopPlayback();
            }
        });
        btnPhatMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer=MediaPlayer.create(GiaiTriActivity.this,R.raw.duyenphan);
                mediaPlayer.start();
            }
        });
        btnStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
    }
}