package logo.quiz.commons.loading;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.R.attr;
import fr.castorflex.android.smoothprogressbar.R.bool;
import fr.castorflex.android.smoothprogressbar.R.color;
import fr.castorflex.android.smoothprogressbar.R.dimen;
import fr.castorflex.android.smoothprogressbar.R.integer;
import fr.castorflex.android.smoothprogressbar.R.string;
import fr.castorflex.android.smoothprogressbar.R.styleable;

public class SmoothProgressBar
  extends ProgressBar
{
  private static final int INTERPOLATOR_ACCELERATE = 0;
  private static final int INTERPOLATOR_ACCELERATEDECELERATE = 2;
  private static final int INTERPOLATOR_DECELERATE = 3;
  private static final int INTERPOLATOR_LINEAR = 1;
  
  public SmoothProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spbStyle);
  }
  
  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SmoothProgressBar, paramInt, 0);
    paramInt = paramAttributeSet.getColor(R.styleable.SmoothProgressBar_spb_color, localResources.getColor(R.color.spb_default_color));
    int i = paramAttributeSet.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, localResources.getInteger(R.integer.spb_default_sections_count));
    int j = paramAttributeSet.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, localResources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length));
    float f1 = paramAttributeSet.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, localResources.getDimension(R.dimen.spb_default_stroke_width));
    float f2 = paramAttributeSet.getFloat(R.styleable.SmoothProgressBar_spb_speed, Float.parseFloat(localResources.getString(R.string.spb_default_speed)));
    int k = paramAttributeSet.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, localResources.getInteger(R.integer.spb_default_interpolator));
    boolean bool1 = paramAttributeSet.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, localResources.getBoolean(R.bool.spb_default_reversed));
    boolean bool2 = paramAttributeSet.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, localResources.getBoolean(R.bool.spb_default_mirror_mode));
    int m = paramAttributeSet.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0);
    paramAttributeSet.recycle();
    switch (k)
    {
    default: 
      paramAttributeSet = new AccelerateInterpolator();
      int[] arrayOfInt = null;
      if (m != 0) {
        arrayOfInt = localResources.getIntArray(m);
      }
      paramContext = new SmoothProgressDrawable.Builder(paramContext).speed(f2).interpolator(paramAttributeSet).sectionsCount(i).separatorLength(j).strokeWidth(f1).reversed(bool1).mirrorMode(bool2);
      if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
        paramContext.colors(arrayOfInt);
      }
      break;
    }
    for (;;)
    {
      setIndeterminateDrawable(paramContext.build());
      return;
      paramAttributeSet = new AccelerateDecelerateInterpolator();
      break;
      paramAttributeSet = new DecelerateInterpolator();
      break;
      paramAttributeSet = new LinearInterpolator();
      break;
      paramContext.color(paramInt);
    }
  }
  
  private SmoothProgressDrawable checkIndeterminateDrawable()
  {
    Drawable localDrawable = getIndeterminateDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof SmoothProgressDrawable))) {
      throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }
    return (SmoothProgressDrawable)localDrawable;
  }
  
  public void applyStyle(int paramInt)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.SmoothProgressBar, 0, paramInt);
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_color)) {
      setSmoothProgressDrawableColor(localTypedArray.getColor(R.styleable.SmoothProgressBar_spb_color, 0));
    }
    Object localObject;
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_colors))
    {
      paramInt = localTypedArray.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0);
      if (paramInt != 0)
      {
        localObject = getResources().getIntArray(paramInt);
        if ((localObject != null) && (localObject.length > 0)) {
          setSmoothProgressDrawableColors((int[])localObject);
        }
      }
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_sections_count)) {
      setSmoothProgressDrawableSectionsCount(localTypedArray.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, 0));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_stroke_separator_length)) {
      setSmoothProgressDrawableSeparatorLength(localTypedArray.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, 0));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_stroke_width)) {
      setSmoothProgressDrawableStrokeWidth(localTypedArray.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, 0.0F));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_speed)) {
      setSmoothProgressDrawableSpeed(localTypedArray.getFloat(R.styleable.SmoothProgressBar_spb_speed, 0.0F));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_reversed)) {
      setSmoothProgressDrawableReversed(localTypedArray.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, false));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_mirror_mode)) {
      setSmoothProgressDrawableMirrorMode(localTypedArray.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, false));
    }
    if (localTypedArray.hasValue(R.styleable.SmoothProgressBar_spb_interpolator)) {
      switch (localTypedArray.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, -1))
      {
      default: 
        localObject = null;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        setInterpolator((Interpolator)localObject);
      }
      localTypedArray.recycle();
      return;
      localObject = new AccelerateDecelerateInterpolator();
      continue;
      localObject = new DecelerateInterpolator();
      continue;
      localObject = new LinearInterpolator();
      continue;
      localObject = new AccelerateInterpolator();
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    super.setInterpolator(paramInterpolator);
    Drawable localDrawable = getIndeterminateDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof SmoothProgressDrawable))) {
      ((SmoothProgressDrawable)localDrawable).setInterpolator(paramInterpolator);
    }
  }
  
  public void setSmoothProgressDrawableColor(int paramInt)
  {
    checkIndeterminateDrawable().setColor(paramInt);
  }
  
  public void setSmoothProgressDrawableColors(int[] paramArrayOfInt)
  {
    checkIndeterminateDrawable().setColors(paramArrayOfInt);
  }
  
  public void setSmoothProgressDrawableInterpolator(Interpolator paramInterpolator)
  {
    checkIndeterminateDrawable().setInterpolator(paramInterpolator);
  }
  
  public void setSmoothProgressDrawableMirrorMode(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setMirrorMode(paramBoolean);
  }
  
  public void setSmoothProgressDrawableReversed(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setReversed(paramBoolean);
  }
  
  public void setSmoothProgressDrawableSectionsCount(int paramInt)
  {
    checkIndeterminateDrawable().setSectionsCount(paramInt);
  }
  
  public void setSmoothProgressDrawableSeparatorLength(int paramInt)
  {
    checkIndeterminateDrawable().setSeparatorLength(paramInt);
  }
  
  public void setSmoothProgressDrawableSpeed(float paramFloat)
  {
    checkIndeterminateDrawable().setSpeed(paramFloat);
  }
  
  public void setSmoothProgressDrawableStrokeWidth(float paramFloat)
  {
    checkIndeterminateDrawable().setStrokeWidth(paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/loading/SmoothProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */