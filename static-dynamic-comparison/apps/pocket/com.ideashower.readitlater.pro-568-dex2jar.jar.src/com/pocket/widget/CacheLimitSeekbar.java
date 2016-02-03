package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.pocket.m.a.e;

public class CacheLimitSeekbar
  extends PocketSeekBar
{
  private static final int b = (int)(e.n() / 1048576.0D);
  private static final int c = (int)(e.m() / 1048576.0D);
  private static final c d = new c(0.7F);
  protected boolean a;
  private b e;
  private int f = -1;
  
  public CacheLimitSeekbar(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public CacheLimitSeekbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public CacheLimitSeekbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private int a(int paramInt)
  {
    float f1 = d.getInterpolation(paramInt / getMax());
    if (f1 >= 0.95F) {
      return 0;
    }
    f1 /= 0.95F;
    float f2 = b - c;
    f1 = c + f1 * f2;
    if (f1 >= 500.0F) {}
    for (paramInt = 100;; paramInt = 50) {
      return paramInt * Math.round(f1 / paramInt);
    }
  }
  
  private int a(long paramLong)
  {
    if (paramLong <= 0L) {
      return getMax();
    }
    int j = (int)(paramLong / 1048576.0D);
    int i = j;
    if (j < c) {
      i = c;
    }
    float f1 = (i - c) / (b - c);
    return (int)(d.a(f1 * 0.95F) * getMax());
  }
  
  private long b(int paramInt)
  {
    return com.pocket.p.c.b(a(paramInt));
  }
  
  private void e()
  {
    setMax(1000);
    setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        paramAnonymousInt = CacheLimitSeekbar.a(CacheLimitSeekbar.this, paramAnonymousInt);
        if (CacheLimitSeekbar.b(CacheLimitSeekbar.this) != paramAnonymousInt)
        {
          CacheLimitSeekbar.b(CacheLimitSeekbar.this, paramAnonymousInt);
          if (CacheLimitSeekbar.a(CacheLimitSeekbar.this) != null) {
            CacheLimitSeekbar.a(CacheLimitSeekbar.this).a(paramAnonymousInt, CacheLimitSeekbar.this.getProgressInBytes(), CacheLimitSeekbar.this.a);
          }
        }
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        CacheLimitSeekbar.this.a = true;
      }
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        CacheLimitSeekbar.this.a = false;
        int i = CacheLimitSeekbar.this.getProgressInSnappedMb();
        if ((i <= 0) && (CacheLimitSeekbar.this.getProgress() < CacheLimitSeekbar.this.getMax())) {
          CacheLimitSeekbar.this.setProgress(CacheLimitSeekbar.this.getMax());
        }
        while (CacheLimitSeekbar.a(CacheLimitSeekbar.this) == null) {
          return;
        }
        CacheLimitSeekbar.a(CacheLimitSeekbar.this).a(i, CacheLimitSeekbar.this.getProgressInBytes(), CacheLimitSeekbar.this.a);
      }
    });
  }
  
  public long getProgressInBytes()
  {
    return b(getProgress());
  }
  
  public int getProgressInSnappedMb()
  {
    return a(getProgress());
  }
  
  public void setOnIncrementedMbProgressChangedListener(b paramb)
  {
    this.f = -1;
    this.e = paramb;
    if (this.e != null) {
      this.e.a(getProgressInSnappedMb(), getProgressInBytes(), this.a);
    }
  }
  
  public void setProgressInBytes(long paramLong)
  {
    setProgress(a(paramLong));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/CacheLimitSeekbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */