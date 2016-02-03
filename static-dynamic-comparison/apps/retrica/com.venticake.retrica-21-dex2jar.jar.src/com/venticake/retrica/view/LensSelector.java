package com.venticake.retrica.view;

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
import com.venticake.retrica.MainActivity;
import com.venticake.retrica.c;
import com.venticake.retrica.engine.a.b;
import com.venticake.retrica.engine.a.g;
import com.venticake.retrica.util.UserInterfaceUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LensSelector
  extends FrameLayout
  implements View.OnClickListener
{
  private static final int NOT_SELECTED = -1;
  private final int CLOSEBUTTON_MAXIMUM_HEIGHT_IN_DP = 200;
  private final int CLOSEBUTTON_MINIMUM_HEIGHT_IN_DP = 50;
  private ImageButton closeButton = null;
  private boolean initialDisplay = true;
  public LensIntensityControlView lensIntensityControlView = null;
  private Context mContext = null;
  public LensSelectorButton mCurrentSelectedButton;
  private LensSelector.LensSelectorListner mListner = null;
  private int preferredHeightInPixel = 0;
  private int scrollLayoutHeightInPixel = 0;
  private LinearLayout scrollLinearLayout = null;
  private HorizontalScrollView scrollView = null;
  private int selectedLensIndex = -1;
  private int selectedPackIndex = -1;
  private int selectedPackScrollX = -1;
  
  public LensSelector(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public LensSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public LensSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void closeButtonTouched()
  {
    if (this.mListner != null)
    {
      this.mListner.onCloseButtonTouched();
      return;
    }
    hide();
  }
  
  private LensSelectorButton createBackButton(Context paramContext)
  {
    switch (MainActivity.c)
    {
    default: 
      return new LensSelectorButton(paramContext);
    }
    return new LensSelectorLargeButton(paramContext);
  }
  
  private LensSelectorButton createLensButton(Context paramContext, g paramg, int paramInt1, int paramInt2)
  {
    switch (MainActivity.c)
    {
    default: 
      return new LensSelectorButton(paramContext, paramg, paramInt1, paramInt2);
    }
    return new LensSelectorLargeButton(paramContext, paramg, paramInt1, paramInt2);
  }
  
  private LensSelectorButton createPackButton(Context paramContext, b paramb, int paramInt)
  {
    switch (MainActivity.c)
    {
    default: 
      return new LensSelectorButton(paramContext, paramb, paramInt);
    }
    return new LensSelectorLargeButton(paramContext, paramb, paramInt);
  }
  
  private void initViews()
  {
    if (this.scrollView == null) {
      this.scrollView = ((HorizontalScrollView)findViewById(2131296501));
    }
    if (this.scrollLinearLayout == null) {
      this.scrollLinearLayout = ((LinearLayout)findViewById(2131296502));
    }
    if (this.lensIntensityControlView == null)
    {
      this.lensIntensityControlView = ((LensIntensityControlView)findViewById(2131296500));
      this.lensIntensityControlView.setOnValueChangeListener(new LensIntensityControlView.OnValueChangeListener()
      {
        public void onValueChanged(LensIntensityControlView paramAnonymousLensIntensityControlView, float paramAnonymousFloat)
        {
          if (LensSelector.this.mListner == null) {
            return;
          }
          LensSelector.this.mListner.onIntensityValueChanged(paramAnonymousLensIntensityControlView, paramAnonymousFloat);
        }
      });
      this.lensIntensityControlView.setOnEditModeChangeListener(new LensIntensityControlView.OnEditModeChangeListener()
      {
        public void onEditModeChanged(LensIntensityControlView paramAnonymousLensIntensityControlView, boolean paramAnonymousBoolean)
        {
          if (LensSelector.this.mListner == null) {
            return;
          }
          LensSelector.this.mListner.onIntensityEditModeChanged(paramAnonymousLensIntensityControlView, paramAnonymousBoolean);
        }
      });
    }
    this.closeButton = ((ImageButton)findViewById(2131296503));
    this.closeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LensSelector.this.closeButtonTouched();
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
        com.venticake.retrica.engine.a.a locala = com.venticake.retrica.engine.a.a.b();
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
                LensSelector.this.scrollLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                LensSelector.this.scrollView.scrollTo(i, 0);
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
        LensSelectorButton localLensSelectorButton2 = createPackButton(this.mContext, localb, i);
        if (this.scrollLayoutHeightInPixel < 1) {
          this.scrollLayoutHeightInPixel = UserInterfaceUtil.dp2px(localLensSelectorButton2.getPackHeightInDP() + 24, localLensSelectorButton2);
        }
        localLensSelectorButton2.setOnClickListener(this);
        this.scrollLinearLayout.addView(localLensSelectorButton2);
        if ((this.initialDisplay) && (this.selectedPackScrollX == -1) && (localg != null) && (localb.a(localg)))
        {
          j = i;
          final LensSelectorButton localLensSelectorButton1 = localLensSelectorButton2;
          break label230;
          if (j == -1) {
            break label229;
          }
          this.scrollLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public void onGlobalLayout()
            {
              LensSelector.this.scrollLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
              int i = localLensSelectorButton1.getLeft();
              int j = localLensSelectorButton1.getWidth() / 2;
              int k = LensSelector.this.scrollView.getWidth() / 2;
              LensSelector.this.scrollView.scrollTo(i + j - k, 0);
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
  
  private void updateSelectedIndexes()
  {
    if ((this.mCurrentSelectedButton != null) && (this.mCurrentSelectedButton.getType() == LensSelectorButton.LensSelectorButtonType.Lens))
    {
      this.selectedLensIndex = this.mCurrentSelectedButton.getLensIndex();
      this.selectedPackIndex = this.mCurrentSelectedButton.getPackIndex();
      return;
    }
    try
    {
      this.selectedLensIndex = com.venticake.retrica.engine.a.a.b().b(com.venticake.retrica.setting.a.a().f());
      this.selectedPackIndex = com.venticake.retrica.engine.a.a.b().c(com.venticake.retrica.setting.a.a().f());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void updateSelectedLensButton()
  {
    if ((this.scrollLinearLayout == null) || (this.scrollLinearLayout.getChildCount() < 1)) {
      return;
    }
    Object localObject1;
    label28:
    int i;
    label39:
    Object localObject2;
    if (this.mListner == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label105;
      }
      localObject1 = ((g)localObject1).v();
      i = 0;
      if (i < this.scrollLinearLayout.getChildCount())
      {
        localObject2 = this.scrollLinearLayout.getChildAt(i);
        if ((localObject2 instanceof LensSelectorButton))
        {
          localObject2 = (LensSelectorButton)localObject2;
          if (!((String)localObject1).equals(((LensSelectorButton)localObject2).getLensID())) {
            break label107;
          }
          ((LensSelectorButton)localObject2).setSelected(true);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label39;
      break;
      localObject1 = this.mListner.lensSelectorSelectedLens();
      break label28;
      label105:
      break;
      label107:
      ((LensSelectorButton)localObject2).setSelected(false);
    }
  }
  
  public LensSelector.LensSelectorListner getLensSelectorListner()
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
  
  public void invokeLensSelected(int paramInt1, int paramInt2)
  {
    this.mCurrentSelectedButton.setSelected(true);
    for (;;)
    {
      try
      {
        g localg = com.venticake.retrica.engine.a.a.b().a(paramInt1, paramInt2);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localg.a(com.venticake.retrica.setting.a.a().g());
          this.lensIntensityControlView.setColor(localg.C());
          this.lensIntensityControlView.invalidate();
          if (this.mListner != null) {
            this.mListner.onSelectLens(localg, this);
          }
          updateSelectedLensButton();
          return;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        localg = null;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.selectedPackIndex == -1)
    {
      closeButtonTouched();
      return;
    }
    showPackButtons();
  }
  
  public void onClick(View paramView)
  {
    this.mCurrentSelectedButton = ((LensSelectorButton)paramView);
    switch (this.mCurrentSelectedButton.getType())
    {
    default: 
      return;
    case BackToPack: 
      showLensButton(this.mCurrentSelectedButton.getPackIndex(), 0);
      return;
    case Lens: 
      invokeLensSelected(this.mCurrentSelectedButton.getPackIndex(), this.mCurrentSelectedButton.getLensIndex());
      return;
    }
    showPackButtons();
  }
  
  protected void onFinishInflate()
  {
    initViews();
    super.onFinishInflate();
  }
  
  public boolean selectNextLens()
  {
    int i = 0;
    LensSelectorButton localLensSelectorButton = this.mCurrentSelectedButton;
    if (localLensSelectorButton == null) {
      return false;
    }
    updateSelectedIndexes();
    int k = this.selectedLensIndex;
    int j = this.selectedPackIndex;
    k += 1;
    for (;;)
    {
      try
      {
        if (k > com.venticake.retrica.engine.a.a.b().a(j).size() - 1)
        {
          j += 1;
          k = com.venticake.retrica.engine.a.a.b().c().size();
          if (j >= k - 1)
          {
            j = 0;
            invokeLensSelected(i, j);
            localLensSelectorButton.setLensIndex(j);
            localLensSelectorButton.setPackIndex(i);
            showLensButton(localLensSelectorButton.getPackIndex(), j);
            return true;
          }
          k = 0;
          i = j;
          j = k;
          continue;
        }
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      j = k;
    }
  }
  
  public boolean selectPreviousLens()
  {
    LensSelectorButton localLensSelectorButton = this.mCurrentSelectedButton;
    if (localLensSelectorButton == null) {
      return false;
    }
    updateSelectedIndexes();
    int k = this.selectedLensIndex;
    int m = this.selectedPackIndex;
    int i = m;
    int j = k;
    if (k == 0)
    {
      j = m - 1;
      i = j;
      if (j >= 0) {}
    }
    try
    {
      i = com.venticake.retrica.engine.a.a.b().c().size() - 1;
      j = com.venticake.retrica.engine.a.a.b().a(i).size();
      localLensSelectorButton.setPackIndex(i);
      invokeLensSelected(i, j - 1);
      localLensSelectorButton.setLensIndex(j - 1);
      showLensButton(i, j - 1);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void setLensSelectorListener(LensSelector.LensSelectorListner paramLensSelectorListner)
  {
    this.mListner = paramLensSelectorListner;
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
    if (this.mListner == null) {}
    for (g localg = null;; localg = this.mListner.lensSelectorSelectedLens())
    {
      if (localg != null) {
        this.lensIntensityControlView.setColor(localg.C());
      }
      this.lensIntensityControlView.setIntensity(com.venticake.retrica.setting.a.a().g());
      setVisibility(0);
      if (this.mListner != null) {
        this.mListner.onShown(this);
      }
      return;
    }
  }
  
  public void showLensButton(int paramInt1, int paramInt2)
  {
    this.selectedPackIndex = paramInt1;
    this.selectedPackScrollX = this.scrollView.getScrollX();
    this.scrollLinearLayout.removeAllViews();
    for (;;)
    {
      int i;
      try
      {
        localLensSelectorButton = createBackButton(this.mContext);
        localLensSelectorButton.setAsBackButtonWithPackIndex(paramInt1);
        localLensSelectorButton.setOnClickListener(this);
        this.scrollLinearLayout.addView(localLensSelectorButton);
        localb = com.venticake.retrica.engine.a.a.b().a(paramInt1);
        if (this.mListner != null) {
          continue;
        }
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        LensSelectorButton localLensSelectorButton;
        b localb;
        Object localObject1;
        localException1.printStackTrace();
        continue;
      }
      if (i >= localb.size())
      {
        if (paramInt2 != 0) {
          continue;
        }
        this.scrollView.scrollTo(0, 0);
      }
      try
      {
        localObject1 = com.venticake.retrica.engine.a.a.b().a(paramInt1).c();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("Name", localObject1);
        c.a("Pack Selected", (Map)localObject2);
        return;
      }
      catch (Exception localException2)
      {
        g localg;
        boolean bool;
        localException2.printStackTrace();
        return;
      }
      localObject1 = this.mListner.lensSelectorSelectedLens();
      break label344;
      localg = localb.a(i);
      bool = com.venticake.retrica.engine.a.a.b().b(localg);
      Object localObject2 = createLensButton(this.mContext, localg, i, paramInt1);
      int j = k;
      if (k == 0) {
        j = UserInterfaceUtil.dp2px(((LensSelectorButton)localObject2).getLensWidthInDP(), this.scrollLinearLayout);
      }
      ((LensSelectorButton)localObject2).setLocked(bool);
      ((LensSelectorButton)localObject2).setOnClickListener(this);
      ((LensSelectorButton)localObject2).setLensID(localg.v());
      this.scrollLinearLayout.addView((View)localObject2);
      if ((localObject1 != null) && (localObject1 == localg))
      {
        ((LensSelectorButton)localObject2).setSelected(true);
        break label355;
        if (localObject2 == null) {
          continue;
        }
        if (paramInt2 > 1)
        {
          paramInt2 = UserInterfaceUtil.dp2px(53.0F, this) / 2 + (UserInterfaceUtil.dp2px(58.0F, this) * (paramInt2 - 2) + (localLensSelectorButton.getWidth() + UserInterfaceUtil.dp2px(5.0F, (View)localObject2)));
          this.scrollView.smoothScrollTo(paramInt2, 0);
          continue;
        }
        paramInt2 = 0;
        continue;
        label344:
        k = 0;
        localObject2 = null;
        i = 0;
        continue;
      }
      label355:
      i += 1;
      int k = j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/LensSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */