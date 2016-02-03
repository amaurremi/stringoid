package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  private boolean cY = false;
  private boolean cZ = false;
  private final Runnable da = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar.a(ContentLoadingProgressBar.this, false);
      ContentLoadingProgressBar.a(ContentLoadingProgressBar.this, -1L);
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable db = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar.b(ContentLoadingProgressBar.this, false);
      if (!ContentLoadingProgressBar.a(ContentLoadingProgressBar.this))
      {
        ContentLoadingProgressBar.a(ContentLoadingProgressBar.this, System.currentTimeMillis());
        ContentLoadingProgressBar.this.setVisibility(0);
      }
    }
  };
  private boolean mDismissed = false;
  private long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void T()
  {
    removeCallbacks(this.da);
    removeCallbacks(this.db);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    T();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    T();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/ContentLoadingProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */