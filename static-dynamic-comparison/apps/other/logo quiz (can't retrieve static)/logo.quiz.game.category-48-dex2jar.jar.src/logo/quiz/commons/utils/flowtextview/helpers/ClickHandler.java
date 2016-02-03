package logo.quiz.commons.utils.flowtextview.helpers;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.Iterator;
import logo.quiz.commons.utils.flowtextview.listeners.OnLinkClickListener;
import logo.quiz.commons.utils.flowtextview.models.HtmlLink;

public class ClickHandler
  implements View.OnTouchListener
{
  private double distance = 0.0D;
  private OnLinkClickListener mOnLinkClickListener;
  private final SpanParser mSpanParser;
  private float x1;
  private float x2;
  private float y1;
  private float y2 = 0.0F;
  
  public ClickHandler(SpanParser paramSpanParser)
  {
    this.mSpanParser = paramSpanParser;
  }
  
  private static double getPointDistance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }
  
  private void onClick(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.mSpanParser.getLinks().iterator();
    while (localIterator.hasNext())
    {
      HtmlLink localHtmlLink = (HtmlLink)localIterator.next();
      float f1 = localHtmlLink.xOffset;
      float f2 = localHtmlLink.yOffset;
      float f3 = localHtmlLink.xOffset;
      float f4 = localHtmlLink.width;
      float f5 = localHtmlLink.yOffset;
      float f6 = localHtmlLink.height;
      if ((paramFloat1 > f1) && (paramFloat1 < f3 + f4) && (paramFloat2 > f2) && (paramFloat2 < f5 + f6)) {
        onLinkClick(localHtmlLink.url);
      }
    }
  }
  
  private void onLinkClick(String paramString)
  {
    if (this.mOnLinkClickListener != null) {
      this.mOnLinkClickListener.onLinkClick(paramString);
    }
  }
  
  public OnLinkClickListener getOnLinkClickListener()
  {
    return this.mOnLinkClickListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.distance = 0.0D;
      this.x1 = paramMotionEvent.getX();
      this.y1 = paramMotionEvent.getY();
    }
    if (i == 2)
    {
      this.x2 = paramMotionEvent.getX();
      this.y2 = paramMotionEvent.getY();
      this.distance = getPointDistance(this.x1, this.y1, this.x2, this.y2);
    }
    if (this.distance < 10.0D)
    {
      if (i == 1) {
        onClick(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      return true;
    }
    return false;
  }
  
  public void setOnLinkClickListener(OnLinkClickListener paramOnLinkClickListener)
  {
    this.mOnLinkClickListener = paramOnLinkClickListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/helpers/ClickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */