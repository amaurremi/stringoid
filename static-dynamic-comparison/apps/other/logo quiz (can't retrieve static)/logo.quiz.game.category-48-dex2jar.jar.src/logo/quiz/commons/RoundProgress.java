package logo.quiz.commons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RoundProgress
  extends RelativeLayout
{
  private double max = 100.0D;
  private ImageView progressDrawableImageView;
  private ImageView trackDrawableImageView;
  
  public RoundProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.round_progress, this);
    setup(paramContext, paramAttributeSet);
  }
  
  public int getMax()
  {
    return new Double(this.max).intValue();
  }
  
  public double getMaxDouble()
  {
    return this.max;
  }
  
  public void setMax(double paramDouble)
  {
    this.max = paramDouble;
  }
  
  public void setMax(int paramInt)
  {
    new Integer(paramInt).doubleValue();
    this.max = paramInt;
  }
  
  public void setProgress(double paramDouble)
  {
    ((ClipDrawable)this.progressDrawableImageView.getBackground()).setLevel((int)Math.floor(10000.0D * (paramDouble / this.max)));
  }
  
  public void setProgress(Integer paramInteger)
  {
    setProgress(paramInteger.intValue());
  }
  
  protected void setup(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundProgress);
    this.progressDrawableImageView = ((ImageView)findViewById(R.id.progress_drawable_image_view));
    try
    {
      this.progressDrawableImageView.setBackgroundResource(R.drawable.progress_bar_levels_bg);
      this.trackDrawableImageView = ((ImageView)findViewById(R.id.track_image_view));
      try
      {
        this.trackDrawableImageView.setBackgroundResource(R.drawable.progress_bar_levels);
        setProgress(2);
        setMax(10);
        paramAttributeSet.recycle();
        addView(new ProgressBarOutline(paramContext));
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/RoundProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */