package no.uninett.agora.AgoraMobile;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.MotionEvent;

import org.apache.cordova.CordovaWebView;

public class CorrectWebView extends CordovaWebView {
    public static final String TAG = "CorrectWebView";

    public CorrectWebView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Warning! This will cause the WebView to continuously be redrawn
        // and will drain the devices battery while the view is displayed!
        invalidate();
    }

    Handler handler = new Handler();
    public boolean onTouchEvent (MotionEvent event){
        super.onTouchEvent(event);
        handler.postDelayed(triggerInvalidate, 60);
        handler.postDelayed(triggerInvalidate, 300);
        return true;
    }

    private Runnable triggerInvalidate=new Runnable(){
        public void run(){
            invalidate();
        }
    };

}
