package logo.quiz.commons.utils.flowtextview.helpers;

import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

public class PaintHelper
{
  private ArrayList<TextPaint> mPaintHeap = new ArrayList();
  
  public TextPaint getPaintFromHeap()
  {
    if (this.mPaintHeap.size() > 0) {
      return (TextPaint)this.mPaintHeap.remove(0);
    }
    return new TextPaint(1);
  }
  
  public void recyclePaint(TextPaint paramTextPaint)
  {
    this.mPaintHeap.add(paramTextPaint);
  }
  
  public void setColor(int paramInt)
  {
    Iterator localIterator = this.mPaintHeap.iterator();
    while (localIterator.hasNext()) {
      ((TextPaint)localIterator.next()).setColor(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/helpers/PaintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */