package sxtlal.allenlucas.yohodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class WaitActivity extends Activity {

    private ImageView waitactivity_image;
    private Button waitactivity_btn;
    private boolean chose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wait);
        waitactivity_image = (ImageView) findViewById(R.id.waitactivity_image);
        waitactivity_btn = (Button) findViewById(R.id.waitactivity_btn);
        waitactivity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chose){
                    stratActivity();
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(WaitActivity.this, R.anim.scale_wait);
                waitactivity_image.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        stratActivity();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        },3*1000);
    }

    private void stratActivity() {
        if(!chose){
            startActivity(new Intent(WaitActivity.this,ChoseActivity.class));
            finish();
            chose=true;
        }
    }
}
