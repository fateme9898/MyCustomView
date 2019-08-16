package retrofit.anew.mycustomview;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {
            ImageView image;
    ObjectAnimator objectanimator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.carr);

        objectanimator1 = ObjectAnimator.ofFloat(image,"Y",400);
        objectanimator1.setDuration(3000);
        objectanimator1.start();
        objectanimator1.setRepeatCount(Animation.INFINITE);


    }
}