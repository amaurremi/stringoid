package logo.quiz.commons.gesture.listener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class LogoFormOnGestureDetector
  extends GestureDetector
{
  LogoFormGestureListener logoFormGestureListener;
  
  public LogoFormOnGestureDetector(Context paramContext, LogoFormGestureListener paramLogoFormGestureListener)
  {
    super(paramContext, paramLogoFormGestureListener);
    this.logoFormGestureListener = paramLogoFormGestureListener;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/gesture/listener/LogoFormOnGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */