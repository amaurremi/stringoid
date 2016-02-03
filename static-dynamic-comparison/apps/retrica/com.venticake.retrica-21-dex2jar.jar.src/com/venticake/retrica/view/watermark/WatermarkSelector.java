package com.venticake.retrica.view.watermark;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.venticake.retrica.MainActivity;
import com.venticake.retrica.engine.a.a;
import com.venticake.retrica.engine.a.b;
import com.venticake.retrica.engine.a.g;
import com.venticake.retrica.util.UserInterfaceUtil;

public class WatermarkSelector
  extends FrameLayout
  implements View.OnClickListener
{
  private static final int NOT_SELECTED = -1;
  private final int CLOSEBUTTON_MAXIMUM_HEIGHT_IN_DP = 200;
  private final int CLOSEBUTTON_MINIMUM_HEIGHT_IN_DP = 50;
  private ImageButton closeButton = null;
  private boolean initialDisplay = true;
  private Context mContext = null;
  public WatermarkSelectorButton mCurrentSelectedButton;
  private WatermarkSelector.WaterMarkSelectorListner mListner = null;
  private int preferredHeightInPixel = 0;
  private int scrollLayoutHeightInPixel = 0;
  private LinearLayout scrollLinearLayout = null;
  private HorizontalScrollView scrollView = null;
  private int selectedPackIndex = -1;
  private int selectedPackScrollX = -1;
  
  public WatermarkSelector(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public WatermarkSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public WatermarkSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void adjustCloseButtonHeight()
  {
    if (this.preferredHeightInPixel < 1) {
      return;
    }
    int j = this.scrollLayoutHeightInPixel;
    int i = this.preferredHeightInPixel - j;
    Log.d("retrica", "adj_CBH buttonScrollHeight: " + j);
    Log.d("retrica", "adj_CBH preferredHeightInPixel: " + this.preferredHeightInPixel);
    Log.d("retrica", "adj_CBH adjustedHeight: " + i);
    float f = UserInterfaceUtil.densityOfView(this.closeButton);
    j = UserInterfaceUtil.dp2px(200, f);
    int k = UserInterfaceUtil.dp2px(50, f);
    Log.d("retrica", "adj_CBH height range: " + k + " ~ " + j);
    i = Math.min(j, Math.max(k, i));
    Log.d("retrica", "adj_CBH rangedAdjustedHeight: " + i);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.closeButton.getLayoutParams();
    localLayoutParams.height = i;
    this.closeButton.setLayoutParams(localLayoutParams);
  }
  
  private WatermarkSelectorButton createPackButton(Context paramContext, b paramb, int paramInt)
  {
    switch (MainActivity.c)
    {
    default: 
      return new WatermarkSelectorButton(paramContext, paramb, paramInt);
    }
    return new WatermarkSelectorLargeButton(paramContext, paramb, paramInt);
  }
  
  private void initViews()
  {
    if (this.scrollView == null) {
      this.scrollView = ((HorizontalScrollView)findViewById(2131296504));
    }
    if (this.scrollLinearLayout == null) {
      this.scrollLinearLayout = ((LinearLayout)findViewById(2131296505));
    }
    this.closeButton = ((ImageButton)findViewById(2131296506));
    this.closeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WatermarkSelector.this.hide();
      }
    });
  }
  
  private void showPackButtons()
  {
    this.scrollLinearLayout.removeAllViews();
    this.selectedPackIndex = -1;
    for (;;)
    {
      try
      {
        a locala = a.b();
        g localg;
        if (this.mListner == null)
        {
          localg = null;
          break label220;
          if (i >= locala.d())
          {
            if (this.selectedPackScrollX == -1) {
              continue;
            }
            i = this.selectedPackScrollX;
            this.scrollLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public void onGlobalLayout()
              {
                WatermarkSelector.this.scrollLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                WatermarkSelector.this.scrollView.scrollTo(i, 0);
              }
            });
          }
        }
        else
        {
          localg = this.mListner.lensSelectorSelectedLens();
          break label220;
        }
        b localb = locala.a(i);
        WatermarkSelectorButton localWatermarkSelectorButton2 = createPackButton(this.mContext, localb, i);
        if (this.scrollLayoutHeightInPixel < 1) {
          this.scrollLayoutHeightInPixel = UserInterfaceUtil.dp2px(localWatermarkSelectorButton2.getPackHeightInDP() + 24, localWatermarkSelectorButton2);
        }
        localWatermarkSelectorButton2.setOnClickListener(this);
        this.scrollLinearLayout.addView(localWatermarkSelectorButton2);
        if ((this.initialDisplay) && (this.selectedPackScrollX == -1) && (localg != null) && (localb.a(localg)))
        {
          j = i;
          final WatermarkSelectorButton localWatermarkSelectorButton1 = localWatermarkSelectorButton2;
          break label230;
          if (j == -1) {
            break label229;
          }
          this.scrollLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public void onGlobalLayout()
            {
              WatermarkSelector.this.scrollLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
              int i = localWatermarkSelectorButton1.getLeft();
              int j = localWatermarkSelectorButton1.getWidth() / 2;
              int k = WatermarkSelector.this.scrollView.getWidth() / 2;
              WatermarkSelector.this.scrollView.scrollTo(i + j - k, 0);
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      break label230;
      label220:
      final int i = 0;
      Object localObject = null;
      int j = -1;
      continue;
      label229:
      return;
      label230:
      i += 1;
    }
  }
  
  public WatermarkSelector.WaterMarkSelectorListner getLensSelectorListner()
  {
    return this.mListner;
  }
  
  public int getPreferredHeightInPixel()
  {
    return this.preferredHeightInPixel;
  }
  
  public void hide()
  {
    setVisibility(4);
    if (this.mListner != null) {
      this.mListner.onHidden(this);
    }
  }
  
  public void onClick(View paramView)
  {
    this.mCurrentSelectedButton = ((WatermarkSelectorButton)paramView);
    Toast.makeText(this.mContext, "adfasdfsadf", 1).show();
  }
  
  protected void onFinishInflate()
  {
    initViews();
    super.onFinishInflate();
  }
  
  public void setLensSelectorListener(WatermarkSelector.WaterMarkSelectorListner paramWaterMarkSelectorListner)
  {
    this.mListner = paramWaterMarkSelectorListner;
  }
  
  public void setPreferredHeightInPixel(int paramInt)
  {
    this.preferredHeightInPixel = paramInt;
  }
  
  public void show()
  {
    if (this.initialDisplay)
    {
      showPackButtons();
      adjustCloseButtonHeight();
      this.initialDisplay = false;
    }
    setVisibility(0);
    if (this.mListner != null) {
      this.mListner.onShown(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/watermark/WatermarkSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */