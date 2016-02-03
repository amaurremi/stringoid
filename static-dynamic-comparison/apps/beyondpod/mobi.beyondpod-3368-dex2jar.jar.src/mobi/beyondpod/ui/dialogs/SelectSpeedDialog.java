package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.text.DecimalFormat;

public class SelectSpeedDialog
  extends PopupWindow
{
  View _Arrow;
  Context _Context;
  TextView _CurrSpeed;
  DecimalFormat _PlaybackSpeedFormat = new DecimalFormat("#.##x");
  PlaybackSpeedSelectedListener _PlaybackSpeedSelectedListener;
  private int _ScreenWidth;
  float _SelectedSpeed;
  SeekBar _SpeedSeeker;
  private final int[] mLocation = new int[2];
  
  public SelectSpeedDialog(Context paramContext, PlaybackSpeedSelectedListener paramPlaybackSpeedSelectedListener, float paramFloat)
  {
    super(paramContext);
    this._SelectedSpeed = paramFloat;
    this._Context = paramContext;
    this._PlaybackSpeedSelectedListener = paramPlaybackSpeedSelectedListener;
    setFocusable(true);
    setTouchable(true);
    setOutsideTouchable(true);
    setAnimationStyle(2131558674);
    setHeight(-2);
    this._ScreenWidth = ((WindowManager)this._Context.getSystemService("window")).getDefaultDisplay().getWidth();
    setContentView(LayoutInflater.from(this._Context).inflate(2130903161, null));
    paramContext = getContentView();
    this._SpeedSeeker = ((SeekBar)paramContext.findViewById(2131231180));
    this._CurrSpeed = ((TextView)paramContext.findViewById(2131231179));
    this._Arrow = paramContext.findViewById(2131231123);
    this._CurrSpeed.setText(this._PlaybackSpeedFormat.format(this._SelectedSpeed));
    this._SpeedSeeker.setMax(27);
    this._SpeedSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {}
        do
        {
          return;
          SelectSpeedDialog.this._SelectedSpeed = (0.3F + paramAnonymousInt / 10.0F);
          SelectSpeedDialog.this._CurrSpeed.setText(SelectSpeedDialog.this._PlaybackSpeedFormat.format(SelectSpeedDialog.this._SelectedSpeed));
        } while (SelectSpeedDialog.this._PlaybackSpeedSelectedListener == null);
        SelectSpeedDialog.this._PlaybackSpeedSelectedListener.onPlaybackSpeedSelected(SelectSpeedDialog.this._SelectedSpeed);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    this._SpeedSeeker.setProgress((int)((paramFloat - 0.3D) * 10.0D));
    this._SpeedSeeker.setSecondaryProgress(27);
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
  }
  
  public static abstract interface PlaybackSpeedSelectedListener
  {
    public abstract void onPlaybackSpeedSelected(float paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/SelectSpeedDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */