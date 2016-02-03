package logo.quiz.commons.utils.flowtextview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import logo.quiz.commons.utils.flowtextview.helpers.ClickHandler;
import logo.quiz.commons.utils.flowtextview.helpers.CollisionHelper;
import logo.quiz.commons.utils.flowtextview.helpers.PaintHelper;
import logo.quiz.commons.utils.flowtextview.helpers.SpanParser;
import logo.quiz.commons.utils.flowtextview.listeners.OnLinkClickListener;
import logo.quiz.commons.utils.flowtextview.models.HtmlLink;
import logo.quiz.commons.utils.flowtextview.models.HtmlObject;
import logo.quiz.commons.utils.flowtextview.models.Line;
import logo.quiz.commons.utils.flowtextview.models.Obstacle;

public class FlowTextView
  extends RelativeLayout
{
  private final ClickHandler mClickHandler = new ClickHandler(this.mSpanParser);
  private int mColor = -16777216;
  private int mDesiredHeight = 100;
  private boolean mIsHtml = false;
  private TextPaint mLinkPaint;
  private final PaintHelper mPaintHelper = new PaintHelper();
  private final SpanParser mSpanParser = new SpanParser(this, this.mPaintHelper);
  private CharSequence mText = "";
  private TextPaint mTextPaint;
  private float mTextsize = 20.0F;
  private boolean needsMeasure = true;
  private final ArrayList<Obstacle> obstacles = new ArrayList();
  private int pageHeight = 0;
  private Typeface typeFace;
  
  public FlowTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public FlowTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FlowTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private int findBoxesAndReturnLowestObstacleYCoord()
  {
    int j = 0;
    int m = getChildCount();
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView.getVisibility() != 8)
      {
        Obstacle localObstacle = new Obstacle();
        localObstacle.topLeftx = localView.getLeft();
        localObstacle.topLefty = localView.getTop();
        localObstacle.bottomRightx = (localObstacle.topLeftx + localView.getWidth());
        localObstacle.bottomRighty = (localObstacle.topLefty + localView.getHeight());
        this.obstacles.add(localObstacle);
        k = j;
        if (localObstacle.bottomRighty > j) {
          k = localObstacle.bottomRighty;
        }
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getChunk(String paramString, float paramFloat)
  {
    int k = this.mTextPaint.breakText(paramString, true, paramFloat, null);
    if (k <= 0) {}
    while ((k >= paramString.length()) || (paramString.charAt(k - 1) == ' ')) {
      return k;
    }
    if ((paramString.length() > k) && (paramString.charAt(k) == ' ')) {
      return k + 1;
    }
    int i = k - 1;
    while (paramString.charAt(i) != ' ')
    {
      int j = i - 1;
      i = j;
      if (j <= 0) {
        return k;
      }
    }
    return i + 1;
  }
  
  private void init(Context paramContext)
  {
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.density = getResources().getDisplayMetrics().density;
    this.mTextPaint.setTextSize(this.mTextsize);
    this.mTextPaint.setColor(-16777216);
    this.mLinkPaint = new TextPaint(1);
    this.mLinkPaint.density = getResources().getDisplayMetrics().density;
    this.mLinkPaint.setTextSize(this.mTextsize);
    this.mLinkPaint.setColor(-16776961);
    this.mLinkPaint.setUnderlineText(true);
    setBackgroundColor(0);
    setOnTouchListener(this.mClickHandler);
  }
  
  private void paintObject(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public int getLineHeight()
  {
    return Math.round(this.mTextPaint.getFontMetricsInt(null) * 1.0F + 0.0F);
  }
  
  public TextPaint getLinkPaint()
  {
    return this.mLinkPaint;
  }
  
  public OnLinkClickListener getOnLinkClickListener()
  {
    return this.mClickHandler.getOnLinkClickListener();
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public TextPaint getTextPaint()
  {
    return this.mTextPaint;
  }
  
  public float getTextsize()
  {
    return this.mTextsize;
  }
  
  public Typeface getTypeFace()
  {
    return this.typeFace;
  }
  
  public void invalidate()
  {
    this.needsMeasure = true;
    super.invalidate();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f5 = getWidth();
    this.obstacles.clear();
    int i3 = findBoxesAndReturnLowestObstacleYCoord();
    String[] arrayOfString = this.mText.toString().split("\n");
    int k = 0;
    int m = 0;
    int j = 0;
    float f1 = 0.0F;
    int i4 = getLineHeight();
    ArrayList localArrayList = new ArrayList();
    this.mSpanParser.reset();
    int i2 = 0;
    if (i2 <= arrayOfString.length - 1)
    {
      Object localObject3 = arrayOfString[i2];
      float f2 = f1;
      int i = m;
      int n = j;
      Object localObject2 = localObject3;
      int i1;
      if (((String)localObject3).length() <= 0)
      {
        j += 1;
        m += 2;
        i1 = m;
      }
      do
      {
        i2 += 1;
        k = i1;
        break;
        localObject3 = localObject2;
        if (j >= 1) {
          localObject3 = ((String)localObject2).substring(j, ((String)localObject2).length());
        }
        k = i;
        localObject2 = localObject3;
        Object localObject1;
        f2 = localObject1;
        i1 = k;
        f1 = f2;
        m = i;
        j = n;
      } while (((String)localObject2).length() <= 0);
      n += 1;
      float f4 = n * i4;
      localObject3 = CollisionHelper.calculateLineSpaceForGivenYOffset(f4, i4, f5, this.obstacles);
      float f6 = ((Line)localObject3).leftBound;
      f1 = ((Line)localObject3).rightBound - ((Line)localObject3).leftBound;
      label248:
      j = getChunk((String)localObject2, f1);
      m = i + j;
      label280:
      Object localObject4;
      if (j > 1)
      {
        localObject3 = ((String)localObject2).substring(0, j);
        localArrayList.clear();
        if (!this.mIsHtml) {
          break label530;
        }
        localObject4 = ((Spanned)this.mText).getSpans(k, m, Object.class);
        if (localObject4.length <= 0) {
          break label525;
        }
        f2 = this.mSpanParser.parseSpans(localArrayList, (Object[])localObject4, k, m, f6);
      }
      for (;;)
      {
        float f3 = f1;
        if (f2 > f1) {
          f3 = f1 - 5.0F;
        }
        f1 = f3;
        if (f2 > f3) {
          break label248;
        }
        i += j;
        if (localArrayList.size() <= 0) {
          localArrayList.add(new HtmlObject((String)localObject3, 0, 0, f6, this.mTextPaint));
        }
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (HtmlObject)((Iterator)localObject3).next();
          if ((localObject4 instanceof HtmlLink))
          {
            HtmlLink localHtmlLink = (HtmlLink)localObject4;
            f1 = localHtmlLink.paint.measureText(((HtmlObject)localObject4).content);
            this.mSpanParser.addLink(localHtmlLink, f4, f1, i4);
          }
          paintObject(paramCanvas, ((HtmlObject)localObject4).content, ((HtmlObject)localObject4).xOffset, f4, ((HtmlObject)localObject4).paint);
          if (((HtmlObject)localObject4).recycle) {
            this.mPaintHelper.recyclePaint(((HtmlObject)localObject4).paint);
          }
        }
        break;
        localObject3 = "";
        break label280;
        label525:
        f2 = f1;
        continue;
        label530:
        f2 = f1;
      }
    }
    f1 += i4 / 2;
    paramCanvas = getChildAt(getChildCount() - 1);
    if ((paramCanvas.getTag() != null) && (paramCanvas.getTag().toString().equalsIgnoreCase("hideable")))
    {
      if (f1 <= this.pageHeight) {
        break label662;
      }
      if (f1 >= ((Obstacle)this.obstacles.get(this.obstacles.size() - 1)).topLefty - getLineHeight()) {
        break label654;
      }
      paramCanvas.setVisibility(8);
    }
    for (;;)
    {
      this.mDesiredHeight = Math.max(i3, (int)f1);
      if (this.needsMeasure)
      {
        this.needsMeasure = false;
        requestLayout();
      }
      return;
      label654:
      paramCanvas.setVisibility(0);
      continue;
      label662:
      paramCanvas.setVisibility(8);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      if (i != 1073741824) {
        break label62;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, getLineHeight() + paramInt2);
      return;
      paramInt1 = getWidth();
      break;
      label62:
      paramInt2 = this.mDesiredHeight;
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    if (this.mTextPaint != null) {
      this.mTextPaint.setColor(this.mColor);
    }
    this.mPaintHelper.setColor(this.mColor);
    invalidate();
  }
  
  public void setLinkPaint(TextPaint paramTextPaint)
  {
    this.mLinkPaint = paramTextPaint;
    invalidate();
  }
  
  public void setOnLinkClickListener(OnLinkClickListener paramOnLinkClickListener)
  {
    this.mClickHandler.setOnLinkClickListener(paramOnLinkClickListener);
  }
  
  public void setPageHeight(int paramInt)
  {
    this.pageHeight = paramInt;
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if ((paramCharSequence instanceof Spannable))
    {
      this.mIsHtml = true;
      this.mSpanParser.setSpannable((Spannable)paramCharSequence);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mIsHtml = false;
    }
  }
  
  public void setTextPaint(TextPaint paramTextPaint)
  {
    this.mTextPaint = paramTextPaint;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.mTextsize = paramFloat;
    this.mTextPaint.setTextSize(this.mTextsize);
    this.mLinkPaint.setTextSize(this.mTextsize);
    invalidate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.typeFace = paramTypeface;
    this.mTextPaint.setTypeface(this.typeFace);
    this.mLinkPaint.setTypeface(this.typeFace);
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/FlowTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */