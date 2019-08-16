package retrofit.anew.mycustomview;


import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class DrawBallView extends View {
    Paint circlePaint, linePaint , paint1 , roadPaint;
    public int radius = 320;
    int carX, carY;
    float currrentTouchPosition;
    float lastTouchPosition;
    float carDegree = 0;
    boolean up;
  

    public DrawBallView(Context context) {
        super(context);
       init();

    }

    public DrawBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public void init() {


        ValueAnimator animator = ValueAnimator.ofFloat(360,0);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                carDegree = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centerX = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        int centerY = Resources.getSystem().getDisplayMetrics().heightPixels / 2;
        super.onDraw(canvas);

        circlePaint=new Paint();
        linePaint=new Paint();
        paint1=new Paint();
        roadPaint=new Paint();

        //circle
        circlePaint.setColor(Color.DKGRAY);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(150);
        canvas.drawCircle(centerX, centerY, radius, circlePaint);

        //line
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.GRAY);
        linePaint.setStrokeWidth(20);
        linePaint.setPathEffect(new DashPathEffect(new float[]{100, 45}, (0)));
        canvas.drawCircle(centerX, centerY, radius, linePaint);

              //road
        roadPaint.setColor(Color.DKGRAY);
        roadPaint.setStyle(Paint.Style.STROKE);
        roadPaint.setStrokeWidth(200);
        canvas.drawLine((centerX),(0),
                (centerX),(centerY-radius-20),roadPaint);

        canvas.drawLine((centerX),(canvas.getHeight()),
                (centerX),(centerY+radius+20),roadPaint);

        //road line
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.GRAY);
        linePaint.setStrokeWidth(20);
        linePaint.setPathEffect(new DashPathEffect(new float[]{100, 45}, (0)));
        canvas.drawLine((centerX),(0),
                (centerX),(centerY-radius-10),linePaint);
        canvas.drawLine((centerX),(canvas.getHeight()),
                (centerX),(centerY+radius+20),linePaint);







        //car
        Bitmap source = resizeBitmap(R.mipmap.car, 100, 200);
        Matrix matrix = new Matrix();
        matrix.postRotate(carDegree);
        Bitmap car = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);


        carX = (int) (Math.cos(Math.toRadians(carDegree)) * radius + centerX - car.getWidth() / 2);
        carY = (int) (Math.sin(Math.toRadians(carDegree)) * radius + centerY - car.getHeight() / 2);
        canvas.drawBitmap(car, carX, carY, null);

        //right palm

        Bitmap palm1 = BitmapFactory.decodeResource(getResources(), R.mipmap.grass);
        Bitmap s1 = Bitmap.createScaledBitmap(palm1, 100, 150, true);

        Bitmap palm2 = BitmapFactory.decodeResource(getResources(), R.mipmap.grass);
        Bitmap s2 = Bitmap.createScaledBitmap(palm2, 100, 150, true);

        //road palm right
        canvas.drawBitmap(s1,
                centerX+65 , centerY/4-300 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY/4-200 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY/4-100 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY/4 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY/4 +80, paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY/4 +175, paint1);
        canvas.drawBitmap(s2,
                centerX+65 , centerY-radius-radius/2-radius/4, paint1);





        canvas.drawBitmap(s1,
                centerX+65 , centerY+280 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY+380 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY+480, paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY+580 , paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY+680, paint1);

        canvas.drawBitmap(s1,
                centerX+65 , centerY+radius+radius+radius/2, paint1);




        //road palm left
        canvas.drawBitmap(s2,
                centerX-160 , centerY/4-300 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY/4-200 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY/4-100 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY/4 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY/4 +80, paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY/4 +175, paint1);
        canvas.drawBitmap(s2,
                centerX-160 , centerY-radius-radius/2-radius/4, paint1);





        canvas.drawBitmap(s2,
                centerX-160 , centerY+280 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY+380 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY+480 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY+580 , paint1);

        canvas.drawBitmap(s2,
                centerX-160 , centerY+680, paint1);
        canvas.drawBitmap(s2,
                centerX-160 , centerY+radius+radius+radius/2, paint1);









    }



    public Bitmap resizeBitmap(int resource, int x, int y) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), resource)
                , x, y, false);
    }

    public Paint strokePaint(int strokeWidth, int color, Paint.Style style) {
        Paint paint = new Paint();
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        paint.setStyle(style);
        return paint;
    }
}
