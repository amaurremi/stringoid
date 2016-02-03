package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class PreviewLayout
  extends FrameLayout
{
  private PhotoPreview a;
  private WatermarkPreview b;
  
  public PreviewLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public PhotoPreview a()
  {
    return this.a;
  }
  
  public WatermarkPreview b()
  {
    return this.b;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((PhotoPreview)findViewById(2131231692));
    this.b = ((WatermarkPreview)findViewById(2131231903));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect = this.a.a();
    if (localRect != null)
    {
      WatermarkPreview localWatermarkPreview = this.b;
      paramInt1 = this.a.getLeft();
      paramInt2 = localRect.left;
      paramInt3 = this.a.getTop();
      paramInt4 = localRect.top;
      int i = this.a.getLeft();
      int j = localRect.right;
      int k = this.a.getTop();
      localWatermarkPreview.layout(paramInt1 + paramInt2, paramInt3 + paramInt4, i + j, localRect.bottom + k);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Rect localRect = this.a.a();
    if (localRect != null) {
      this.b.measure(View.MeasureSpec.makeMeasureSpec(localRect.right - localRect.left, 1073741824), View.MeasureSpec.makeMeasureSpec(localRect.bottom - localRect.top, 1073741824));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/PreviewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */