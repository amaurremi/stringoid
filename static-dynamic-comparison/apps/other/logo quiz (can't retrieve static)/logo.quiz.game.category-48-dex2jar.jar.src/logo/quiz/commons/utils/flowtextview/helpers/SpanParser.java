package logo.quiz.commons.utils.flowtextview.helpers;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import logo.quiz.commons.utils.flowtextview.FlowTextView;
import logo.quiz.commons.utils.flowtextview.models.HtmlLink;
import logo.quiz.commons.utils.flowtextview.models.HtmlObject;

public class SpanParser
{
  private final FlowTextView mFlowTextView;
  private final ArrayList<HtmlLink> mLinks = new ArrayList();
  private final PaintHelper mPaintHelper;
  private Spannable mSpannable;
  private int mTextLength = 0;
  private final HashMap<Integer, HtmlObject> sorterMap = new HashMap();
  
  public SpanParser(FlowTextView paramFlowTextView, PaintHelper paramPaintHelper)
  {
    this.mFlowTextView = paramFlowTextView;
    this.mPaintHelper = paramPaintHelper;
  }
  
  private String extractText(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > this.mTextLength - 1) {
      paramInt1 = this.mTextLength - 1;
    }
    return this.mSpannable.subSequence(i, paramInt1).toString();
  }
  
  private HtmlLink getHtmlLink(URLSpan paramURLSpan, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    paramURLSpan = new HtmlLink(paramString, paramInt1, paramInt2, paramFloat, this.mFlowTextView.getLinkPaint(), paramURLSpan.getURL());
    this.mLinks.add(paramURLSpan);
    return paramURLSpan;
  }
  
  private HtmlObject getHtmlObject(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    return new HtmlObject(paramString, paramInt1, paramInt2, paramFloat, this.mFlowTextView.getTextPaint());
  }
  
  private HtmlObject getStyledObject(StyleSpan paramStyleSpan, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    TextPaint localTextPaint = this.mPaintHelper.getPaintFromHeap();
    localTextPaint.setTypeface(Typeface.defaultFromStyle(paramStyleSpan.getStyle()));
    localTextPaint.setTextSize(this.mFlowTextView.getTextsize());
    localTextPaint.setColor(this.mFlowTextView.getColor());
    paramStyleSpan.updateDrawState(localTextPaint);
    paramStyleSpan.updateMeasureState(localTextPaint);
    paramStyleSpan = new HtmlObject(paramString, paramInt1, paramInt2, paramFloat, localTextPaint);
    paramStyleSpan.recycle = true;
    return paramStyleSpan;
  }
  
  private static boolean isArrayFull(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private HtmlObject parseSpan(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof URLSpan)) {
      return getHtmlLink((URLSpan)paramObject, paramString, paramInt1, paramInt2, 0.0F);
    }
    if ((paramObject instanceof StyleSpan)) {
      return getStyledObject((StyleSpan)paramObject, paramString, paramInt1, paramInt2, 0.0F);
    }
    return getHtmlObject(paramString, paramInt1, paramInt2, 0.0F);
  }
  
  public void addLink(HtmlLink paramHtmlLink, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramHtmlLink.yOffset = (paramFloat1 - 20.0F);
    paramHtmlLink.width = paramFloat2;
    paramHtmlLink.height = (paramFloat3 + 20.0F);
    this.mLinks.add(paramHtmlLink);
  }
  
  public ArrayList<HtmlLink> getLinks()
  {
    return this.mLinks;
  }
  
  public Spannable getSpannable()
  {
    return this.mSpannable;
  }
  
  public float parseSpans(ArrayList<HtmlObject> paramArrayList, Object[] paramArrayOfObject, int paramInt1, int paramInt2, float paramFloat)
  {
    this.sorterMap.clear();
    int n = paramInt2 - paramInt1;
    Object localObject1 = new boolean[n];
    int i1 = paramArrayOfObject.length;
    int j = 0;
    int i;
    while (j < i1)
    {
      Object localObject2 = paramArrayOfObject[j];
      int k = this.mSpannable.getSpanStart(localObject2);
      int m = this.mSpannable.getSpanEnd(localObject2);
      i = k;
      if (k < paramInt1) {
        i = paramInt1;
      }
      k = m;
      if (m > paramInt2) {
        k = paramInt2;
      }
      m = i;
      while (m < k)
      {
        localObject1[(m - paramInt1)] = 1;
        m += 1;
      }
      String str = extractText(i, k);
      this.sorterMap.put(Integer.valueOf(i), parseSpan(localObject2, str, i, k));
      j += 1;
    }
    paramInt2 = 0;
    if (!isArrayFull((boolean[])localObject1)) {
      for (;;)
      {
        i = paramInt2;
        paramInt2 = i;
        if (i >= n) {
          break;
        }
        if (localObject1[i] == 1)
        {
          paramInt2 = i + 1;
        }
        else
        {
          for (paramInt2 = i;; paramInt2 = j + 1)
          {
            j = paramInt2;
            paramInt2 = j;
            if (j > n) {
              break;
            }
            if ((j >= n) || (localObject1[j] != 0)) {
              break label258;
            }
            localObject1[j] = 1;
          }
          label258:
          paramInt2 = paramInt1 + i;
          i = paramInt1 + j;
          paramArrayOfObject = extractText(paramInt2, i);
          this.sorterMap.put(Integer.valueOf(paramInt2), parseSpan(null, paramArrayOfObject, paramInt2, i));
          paramInt2 = j;
        }
      }
    }
    paramArrayOfObject = this.sorterMap.keySet().toArray();
    Arrays.sort(paramArrayOfObject);
    float f = paramFloat;
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfObject.length)
    {
      localObject1 = (HtmlObject)this.sorterMap.get(paramArrayOfObject[paramInt1]);
      ((HtmlObject)localObject1).xOffset = f;
      f += ((HtmlObject)localObject1).paint.measureText(((HtmlObject)localObject1).content);
      paramArrayList.add(localObject1);
      paramInt1 += 1;
    }
    return f - paramFloat;
  }
  
  public void reset()
  {
    this.mLinks.clear();
  }
  
  public void setSpannable(Spannable paramSpannable)
  {
    this.mSpannable = paramSpannable;
    this.mTextLength = paramSpannable.length();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/helpers/SpanParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */