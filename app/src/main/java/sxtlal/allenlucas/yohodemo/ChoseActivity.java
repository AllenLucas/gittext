package sxtlal.allenlucas.yohodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ChoseActivity extends Activity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private boolean choseto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chose);
        initView();
        initListener();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!choseto){
                    startActivityForResult(new Intent(ChoseActivity.this,MainActivity.class),1);
                    overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                    choseto =true;
                }
            }
        },3*1000);
    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.choseActivity_btn1);
        btn2 = (Button) findViewById(R.id.choseActivity_btn2);
        btn3 = (Button) findViewById(R.id.choseActivity_btn3);
        btn4 = (Button) findViewById(R.id.choseActivity_btn4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.choseActivity_btn1:
                chosestrat(v);
                break;
            case R.id.choseActivity_btn2:
                chosestrat(v);
                break;
            case R.id.choseActivity_btn3:
                chosestrat(v);
                break;
            case R.id.choseActivity_btn4:
                chosestrat(v);
                break;
        }
    }

    private void chosestrat(View v) {
        if(!choseto){
            Intent intent = new Intent(ChoseActivity.this,MainActivity.class);
            intent.putExtra("_id",v.getId());
            startActivityForResult(intent,1);
            overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
            choseto=true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            choseto =false;
        }
    }
}
