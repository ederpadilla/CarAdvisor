package jr.eder.developer.example.com.caradvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
   @BindView(R.id.start)
    ImageView start;
    @BindView(R.id.end)
    ImageView end;
    @BindView(R.id.top)
    ImageView top;
    @BindView(R.id.bottom)
    ImageView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        damageArea(1);
    }
    private void damageArea(int area){
        switch (area){
            case 0:
                startDamadge();
                break;
            case 1:
                endDamadge();
                break;
            case 2:
                topDamadge();
                break;
            case 3:
                bottomDamadge();
                break;
        }
    }
    private void startDamadge(){
       animateObject(start);
    }
    private void bottomDamadge(){
       animateObject(bottom);
    }
    private void endDamadge(){
       animateObject(end);
    }
    private void topDamadge(){
        animateObject(top);
    }
    private void animateObject(ImageView imageView){
        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        imageView.startAnimation(animation);
    }


}
