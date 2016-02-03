package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import mobi.beyondpod.rsscore.Configuration;

public class SetSleepTimerDialog
  extends PopupWindow
{
  View _Arrow;
  ListView _CategoriesList;
  Context _Context;
  Animation _OpenEffect;
  HorizontalScrollView _OptionScroller;
  private int _ScreenWidth;
  View.OnClickListener _SleepButtonClicked = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (SetSleepTimerDialog.this._SleepTimeSelectedListener == null) {
        return;
      }
      switch (paramAnonymousView.getId())
      {
      }
      for (;;)
      {
        SetSleepTimerDialog.this.dismiss();
        return;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(0);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[0]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[1]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[2]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[3]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[4]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(SetSleepTimerDialog.this._SleepTimes[5]);
        continue;
        SetSleepTimerDialog.this._SleepTimeSelectedListener.onCategorySelected(Integer.MIN_VALUE);
      }
    }
  };
  ViewGroup _SleepOptions;
  SleepTimeSelectedListener _SleepTimeSelectedListener;
  int[] _SleepTimes = new int[6];
  private final int[] mLocation = new int[2];
  
  public SetSleepTimerDialog(Context paramContext, SleepTimeSelectedListener paramSleepTimeSelectedListener)
  {
    super(paramContext);
    this._Context = paramContext;
    this._SleepTimeSelectedListener = paramSleepTimeSelectedListener;
    setFocusable(true);
    setTouchable(true);
    setOutsideTouchable(true);
    setAnimationStyle(2131558674);
    setHeight(-2);
    this._ScreenWidth = ((WindowManager)this._Context.getSystemService("window")).getDefaultDisplay().getWidth();
    this._OpenEffect = AnimationUtils.loadAnimation(paramContext, 2130968597);
    this._OpenEffect.setInterpolator(new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat = 1.55F * paramAnonymousFloat - 1.1F;
        return 1.2F - paramAnonymousFloat * paramAnonymousFloat;
      }
    });
    paramContext = Configuration.PlayerSleepTimeouts();
    setContentView(LayoutInflater.from(this._Context).inflate(2130903162, null));
    WireButton(2131231190, 9999);
    WireButton(2131231189, 9999);
    this._SleepTimes[0] = 15;
    this._SleepTimes[1] = 30;
    this._SleepTimes[2] = 45;
    this._SleepTimes[3] = 60;
    this._SleepTimes[4] = 75;
    this._SleepTimes[5] = 90;
    if (paramContext.length > 1)
    {
      this._SleepTimes[0] = paramContext[1];
      paramSleepTimeSelectedListener = this._SleepTimes;
      if (paramContext.length <= 2) {
        break label431;
      }
      i = paramContext[2];
      paramSleepTimeSelectedListener[1] = i;
      paramSleepTimeSelectedListener = this._SleepTimes;
      if (paramContext.length <= 3) {
        break label436;
      }
      i = paramContext[3];
      label254:
      paramSleepTimeSelectedListener[2] = i;
      paramSleepTimeSelectedListener = this._SleepTimes;
      if (paramContext.length <= 4) {
        break label441;
      }
      i = paramContext[4];
      label273:
      paramSleepTimeSelectedListener[3] = i;
      paramSleepTimeSelectedListener = this._SleepTimes;
      if (paramContext.length <= 5) {
        break label446;
      }
      i = paramContext[5];
      label292:
      paramSleepTimeSelectedListener[4] = i;
      paramSleepTimeSelectedListener = this._SleepTimes;
      if (paramContext.length <= 6) {
        break label451;
      }
    }
    label431:
    label436:
    label441:
    label446:
    label451:
    for (int i = paramContext[6];; i = 0)
    {
      paramSleepTimeSelectedListener[5] = i;
      WireButton(2131231183, this._SleepTimes[0]);
      WireButton(2131231184, this._SleepTimes[1]);
      WireButton(2131231185, this._SleepTimes[2]);
      WireButton(2131231186, this._SleepTimes[3]);
      WireButton(2131231187, this._SleepTimes[4]);
      WireButton(2131231188, this._SleepTimes[5]);
      paramContext = getContentView();
      this._SleepOptions = ((ViewGroup)paramContext.findViewById(2131231182));
      this._OptionScroller = ((HorizontalScrollView)paramContext.findViewById(2131231181));
      this._Arrow = paramContext.findViewById(2131231123);
      return;
      i = 0;
      break;
      i = 0;
      break label254;
      i = 0;
      break label273;
      i = 0;
      break label292;
    }
  }
  
  private void WireButton(int paramInt1, int paramInt2)
  {
    TextView localTextView = (TextView)getContentView().findViewById(paramInt1);
    if (localTextView != null)
    {
      if (paramInt2 <= 0) {
        break label44;
      }
      localTextView.setOnClickListener(this._SleepButtonClicked);
      if (paramInt2 != 9999) {
        localTextView.setText(String.valueOf(paramInt2));
      }
    }
    return;
    label44:
    localTextView.setVisibility(8);
  }
  
  public void show(View paramView)
  {
    View localView = getContentView();
    if (localView == null) {
      throw new IllegalStateException("You need to set the content view using the setContentView method");
    }
    setBackgroundDrawable(new ColorDrawable(0));
    int[] arrayOfInt = this.mLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localView.measure(View.MeasureSpec.makeMeasureSpec(this._ScreenWidth, Integer.MIN_VALUE), -2);
    int i = localView.getMeasuredHeight();
    int j = localView.getMeasuredWidth();
    int k = this._ScreenWidth;
    setWidth(Math.min(k, j));
    j = Math.max(0, k - j);
    k = arrayOfInt[1];
    int m = paramView.getHeight() / 2;
    ((FrameLayout.LayoutParams)this._Arrow.getLayoutParams()).leftMargin = (arrayOfInt[0] + paramView.getWidth() / 2 - j - this._Arrow.getMeasuredWidth() / 2);
    showAtLocation(paramView, 0, j, k - i + m - 10);
    this._OptionScroller.scrollTo(0, 0);
    this._SleepOptions.startAnimation(this._OpenEffect);
  }
  
  public static abstract interface SleepTimeSelectedListener
  {
    public abstract void onCategorySelected(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/SetSleepTimerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */