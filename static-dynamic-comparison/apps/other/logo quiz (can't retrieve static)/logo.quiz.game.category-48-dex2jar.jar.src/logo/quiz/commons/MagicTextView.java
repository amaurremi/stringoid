package logo.quiz.commons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MagicTextView
  extends TextView
{
  private WeakHashMap<String, Pair<Canvas, Bitmap>> canvasStore;
  private Drawable foregroundDrawable;
  private boolean frozen = false;
  private ArrayList<Shadow> innerShadows;
  private int[] lockedCompoundPadding;
  private ArrayList<Shadow> outerShadows;
  private Integer strokeColor;
  private Paint.Join strokeJoin;
  private float strokeMiter;
  private float strokeWidth;
  private Bitmap tempBitmap;
  private Canvas tempCanvas;
  
  public MagicTextView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public MagicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public MagicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void generateTempCanvas()
  {
    String str = String.format("%dx%d", new Object[] { Integer.valueOf(getWidth()), Integer.valueOf(getHeight()) });
    Pair localPair = (Pair)this.canvasStore.get(str);
    if (localPair != null)
    {
      this.tempCanvas = ((Canvas)localPair.first);
      this.tempBitmap = ((Bitmap)localPair.second);
      return;
    }
    this.tempCanvas = new Canvas();
    this.tempBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    this.tempCanvas.setBitmap(this.tempBitmap);
    this.canvasStore.put(str, new Pair(this.tempCanvas, this.tempBitmap));
  }
  
  public void addInnerShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    float f = paramFloat1;
    if (paramFloat1 == 0.0F) {
      f = 1.0E-4F;
    }
    this.innerShadows.add(new Shadow(f, paramFloat2, paramFloat3, paramInt));
  }
  
  public void addOuterShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    float f = paramFloat1;
    if (paramFloat1 == 0.0F) {
      f = 1.0E-4F;
    }
    this.outerShadows.add(new Shadow(f, paramFloat2, paramFloat3, paramInt));
  }
  
  public void clearInnerShadows()
  {
    this.innerShadows.clear();
  }
  
  public void clearOuterShadows()
  {
    this.outerShadows.clear();
  }
  
  public void freeze()
  {
    this.lockedCompoundPadding = new int[] { getCompoundPaddingLeft(), getCompoundPaddingRight(), getCompoundPaddingTop(), getCompoundPaddingBottom() };
    this.frozen = true;
  }
  
  public int getCompoundPaddingBottom()
  {
    if (!this.frozen) {
      return super.getCompoundPaddingBottom();
    }
    return this.lockedCompoundPadding[3];
  }
  
  public int getCompoundPaddingLeft()
  {
    if (!this.frozen) {
      return super.getCompoundPaddingLeft();
    }
    return this.lockedCompoundPadding[0];
  }
  
  public int getCompoundPaddingRight()
  {
    if (!this.frozen) {
      return super.getCompoundPaddingRight();
    }
    return this.lockedCompoundPadding[1];
  }
  
  public int getCompoundPaddingTop()
  {
    if (!this.frozen) {
      return super.getCompoundPaddingTop();
    }
    return this.lockedCompoundPadding[2];
  }
  
  public Drawable getForeground()
  {
    if (this.foregroundDrawable == null) {
      return this.foregroundDrawable;
    }
    return new ColorDrawable(getCurrentTextColor());
  }
  
  public void init(AttributeSet paramAttributeSet)
  {
    this.outerShadows = new ArrayList();
    this.innerShadows = new ArrayList();
    if (this.canvasStore == null) {
      this.canvasStore = new WeakHashMap();
    }
    TypedArray localTypedArray;
    label150:
    float f1;
    int i;
    float f2;
    if (paramAttributeSet != null)
    {
      localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MagicTextView);
      paramAttributeSet = localTypedArray.getString(8);
      if (paramAttributeSet != null) {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), String.format("fonts/%s.ttf", new Object[] { paramAttributeSet })));
      }
      if (localTypedArray.hasValue(10))
      {
        paramAttributeSet = localTypedArray.getDrawable(10);
        if (paramAttributeSet == null) {
          break label322;
        }
        setForegroundDrawable(paramAttributeSet);
      }
      if (localTypedArray.hasValue(11))
      {
        paramAttributeSet = localTypedArray.getDrawable(11);
        if (paramAttributeSet == null) {
          break label338;
        }
        setBackgroundDrawable(paramAttributeSet);
      }
      if (localTypedArray.hasValue(0)) {
        addInnerShadow(localTypedArray.getFloat(1, 0.0F), localTypedArray.getFloat(2, 0.0F), localTypedArray.getFloat(3, 0.0F), localTypedArray.getColor(0, -16777216));
      }
      if (localTypedArray.hasValue(4)) {
        addOuterShadow(localTypedArray.getFloat(5, 0.0F), localTypedArray.getFloat(6, 0.0F), localTypedArray.getFloat(7, 0.0F), localTypedArray.getColor(4, -16777216));
      }
      if (localTypedArray.hasValue(14))
      {
        f1 = localTypedArray.getFloat(12, 1.0F);
        i = localTypedArray.getColor(14, -16777216);
        f2 = localTypedArray.getFloat(13, 10.0F);
        paramAttributeSet = null;
        switch (localTypedArray.getInt(15, 0))
        {
        }
      }
    }
    for (;;)
    {
      setStroke(f1, i, paramAttributeSet, f2);
      return;
      label322:
      setTextColor(localTypedArray.getColor(10, -16777216));
      break;
      label338:
      setBackgroundColor(localTypedArray.getColor(11, -16777216));
      break label150;
      paramAttributeSet = Paint.Join.MITER;
      continue;
      paramAttributeSet = Paint.Join.BEVEL;
      continue;
      paramAttributeSet = Paint.Join.ROUND;
    }
  }
  
  public void invalidate()
  {
    if (!this.frozen) {
      super.invalidate();
    }
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.frozen) {
      super.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void invalidate(Rect paramRect)
  {
    if (!this.frozen) {
      super.invalidate(paramRect);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    freeze();
    Drawable localDrawable = getBackground();
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i = getCurrentTextColor();
    setCompoundDrawables(null, null, null, null);
    Object localObject1 = this.outerShadows.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Shadow)((Iterator)localObject1).next();
      setShadowLayer(((Shadow)localObject2).r, ((Shadow)localObject2).dx, ((Shadow)localObject2).dy, ((Shadow)localObject2).color);
      super.onDraw(paramCanvas);
    }
    setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    setTextColor(i);
    if ((this.foregroundDrawable != null) && ((this.foregroundDrawable instanceof BitmapDrawable)))
    {
      generateTempCanvas();
      super.onDraw(this.tempCanvas);
      ((BitmapDrawable)this.foregroundDrawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
      this.foregroundDrawable.setBounds(paramCanvas.getClipBounds());
      this.foregroundDrawable.draw(this.tempCanvas);
      paramCanvas.drawBitmap(this.tempBitmap, 0.0F, 0.0F, null);
      this.tempCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    if (this.strokeColor != null)
    {
      localObject1 = getPaint();
      ((TextPaint)localObject1).setStyle(Paint.Style.STROKE);
      ((TextPaint)localObject1).setStrokeJoin(this.strokeJoin);
      ((TextPaint)localObject1).setStrokeMiter(this.strokeMiter);
      setTextColor(this.strokeColor.intValue());
      ((TextPaint)localObject1).setStrokeWidth(this.strokeWidth);
      super.onDraw(paramCanvas);
      ((TextPaint)localObject1).setStyle(Paint.Style.FILL);
      setTextColor(i);
    }
    if (this.innerShadows.size() > 0)
    {
      generateTempCanvas();
      localObject1 = getPaint();
      localObject2 = this.innerShadows.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Shadow localShadow = (Shadow)((Iterator)localObject2).next();
        setTextColor(localShadow.color);
        super.onDraw(this.tempCanvas);
        setTextColor(-16777216);
        ((TextPaint)localObject1).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        ((TextPaint)localObject1).setMaskFilter(new BlurMaskFilter(localShadow.r, BlurMaskFilter.Blur.NORMAL));
        this.tempCanvas.save();
        this.tempCanvas.translate(localShadow.dx, localShadow.dy);
        super.onDraw(this.tempCanvas);
        this.tempCanvas.restore();
        paramCanvas.drawBitmap(this.tempBitmap, 0.0F, 0.0F, null);
        this.tempCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        ((TextPaint)localObject1).setXfermode(null);
        ((TextPaint)localObject1).setMaskFilter(null);
        setTextColor(i);
        setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
    }
    if (arrayOfDrawable != null) {
      setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
    setBackgroundDrawable(localDrawable);
    setTextColor(i);
    unfreeze();
  }
  
  public void postInvalidate()
  {
    if (!this.frozen) {
      super.postInvalidate();
    }
  }
  
  public void postInvalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.frozen) {
      super.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void requestLayout()
  {
    if (!this.frozen) {
      super.requestLayout();
    }
  }
  
  public void setForegroundDrawable(Drawable paramDrawable)
  {
    this.foregroundDrawable = paramDrawable;
  }
  
  public void setStroke(float paramFloat, int paramInt)
  {
    setStroke(paramFloat, paramInt, Paint.Join.MITER, 10.0F);
  }
  
  public void setStroke(float paramFloat1, int paramInt, Paint.Join paramJoin, float paramFloat2)
  {
    this.strokeWidth = paramFloat1;
    this.strokeColor = Integer.valueOf(paramInt);
    this.strokeJoin = paramJoin;
    this.strokeMiter = paramFloat2;
  }
  
  public void unfreeze()
  {
    this.frozen = false;
  }
  
  public static class Shadow
  {
    int color;
    float dx;
    float dy;
    float r;
    
    public Shadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
    {
      this.r = paramFloat1;
      this.dx = paramFloat2;
      this.dy = paramFloat3;
      this.color = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/MagicTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */