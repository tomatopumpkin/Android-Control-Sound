package com.wimonsiri.controlsound;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        OnClickListener {
    private MediaPlayer mPlayer;
    private Button btn[] = new Button[3];
    private int btn_Res[] = { R.id.playBtn, R.id.stopBtn, R.id.loopBtn };
    private boolean loop = false;
    private int mySong = R.raw.music;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// create object button
        for(int n = 0; n < 3 ; n++) {
            btn[n] = (Button) findViewById(btn_Res[n]);
            btn[n].setOnClickListener( this);
        }
        mPlayer = MediaPlayer.create( this, mySong);
        mPlayer.setLooping(loop);
    }
    // when click button
    public void onClick(View v)
    {
        switch( v.getId() )
        {
            case R.id.playBtn: playSound(); break;
            case R.id.stopBtn: stopSound(); break;
            case R.id.loopBtn: setLoop(); break;
        }
    }
    private void playSound()
    {
        if ( !mPlayer.isPlaying() ) {
            mPlayer.start();
            Toast.makeText(this,"Play sound : " +

                    mPlayer.getCurrentPosition(), Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this,"Sound now playing.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void stopSound() {
        if ( mPlayer.isPlaying() ) {
            int curPos = mPlayer.getCurrentPosition();
            Toast.makeText(this,"Pause sound , current position : " +
                    curPos,Toast.LENGTH_SHORT).show();
            mPlayer.pause();
        }
        else {
            Toast.makeText(this,"Sound is not play.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void setLoop() {
        loop = !loop;
        mPlayer.setLooping( loop );
        if (loop) btn[2].setText("Loop");
        else btn[2].setText("No Loop");
        Toast.makeText(this, "Set Loop : " + loop ,
                Toast.LENGTH_SHORT).show();

    }
}