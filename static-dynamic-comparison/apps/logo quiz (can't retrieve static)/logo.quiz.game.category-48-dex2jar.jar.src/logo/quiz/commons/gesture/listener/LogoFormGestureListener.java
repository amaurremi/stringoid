package logo.quiz.commons.gesture.listener;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public abstract class LogoFormGestureListener
  extends GestureDetector.SimpleOnGestureListener
  implements OnLogoFormGestureListener
{
  private static final int SWIPE_THRESHOLD = 100;
  private static final int SWIPE_VELOCITY_THRESHOLD = 100;
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      paramFloat2 = paramMotionEvent2.getY();
      float f1 = paramMotionEvent1.getY();
      float f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if ((Math.abs(f2) > Math.abs(paramFloat2 - f1)) && (Math.abs(f2) > 100.0F) && (Math.abs(paramFloat1) > 100.0F))
      {
        if (f2 > 0.0F)
        {
          onSwipeRight();
          return false;
        }
        onSwipeLeft();
        return false;
      }
    }
    catch (Exception paramMotionEvent1)
    {
      paramMotionEvent1.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/gesture/listener/LogoFormGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */