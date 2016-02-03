package mobi.beyondpod.rsscore;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import java.text.DecimalFormat;
import mobi.beyondpod.ui.views.base.RepeatingImageButton;
import mobi.beyondpod.ui.views.base.RepeatingImageButton.RepeatListener;

public class PlaybackSpeedControl
{
  private static final int DELTA_AUTO = -1;
  private static final int DELTA_FF = 25;
  private static final int MAX_SPEED = 300;
  private static final int MIN_SPEED = 30;
  Animation _InMin;
  Animation _InPlus;
  private RepeatingImageButton _MinusButton;
  private RepeatingImageButton.RepeatListener _MinusLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      PlaybackSpeedControl.this.decreaseSpeed(25);
    }
  };
  private View.OnClickListener _OnMinusListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      PlaybackSpeedControl.this.decreaseSpeed(-1);
    }
  };
  private View.OnClickListener _OnPlusListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      PlaybackSpeedControl.this.increaseSpeed(-1);
    }
  };
  Animation _OutMin;
  Animation _OutPlus;
  DecimalFormat _PlaybackSpeedFormat = new DecimalFormat("#.##x");
  private TextSwitcher _PlaybackSpeedInfo;
  private RepeatingImageButton _PlusButton;
  private RepeatingImageButton.RepeatListener _PlusLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      PlaybackSpeedControl.this.increaseSpeed(25);
    }
  };
  protected int _Speed;
  
  public PlaybackSpeedControl(final View paramView)
  {
    this._PlaybackSpeedInfo = ((TextSwitcher)paramView.findViewById(2131231009));
    this._PlaybackSpeedInfo.setFactory(new ViewSwitcher.ViewFactory()
    {
      public View makeView()
      {
        TextView localTextView = new TextView(paramView.getContext());
        localTextView.setGravity(1);
        localTextView.setTextSize(28.0F);
        return localTextView;
      }
    });
    this._PlusButton = ((RepeatingImageButton)paramView.findViewById(2131230897));
    this._PlusButton.setOnClickListener(this._OnPlusListener);
    this._PlusButton.setRepeatListener(this._PlusLongClickListener, 500L);
    this._MinusButton = ((RepeatingImageButton)paramView.findViewById(2131230899));
    this._MinusButton.setOnClickListener(this._OnMinusListener);
    this._MinusButton.setRepeatListener(this._MinusLongClickListener, 500L);
    this._InPlus = AnimationUtils.loadAnimation(paramView.getContext(), 2130968599);
    this._OutPlus = AnimationUtils.loadAnimation(paramView.getContext(), 2130968601);
    this._InMin = AnimationUtils.loadAnimation(paramView.getContext(), 2130968598);
    this._OutMin = AnimationUtils.loadAnimation(paramView.getContext(), 2130968600);
  }
  
  private void decreaseSpeed(int paramInt)
  {
    if (this._Speed <= 30) {
      return;
    }
    this._PlaybackSpeedInfo.setInAnimation(this._InMin);
    this._PlaybackSpeedInfo.setOutAnimation(this._OutMin);
    int i;
    int j;
    if (paramInt > 0)
    {
      i = this._Speed % paramInt;
      j = this._Speed;
      if (i != 0) {}
    }
    for (this._Speed = Math.max(30, j - paramInt);; this._Speed -= 5)
    {
      updateSpeed();
      return;
      paramInt = i;
      break;
    }
  }
  
  private void increaseSpeed(int paramInt)
  {
    if (this._Speed >= 300) {
      return;
    }
    this._PlaybackSpeedInfo.setInAnimation(this._InPlus);
    this._PlaybackSpeedInfo.setOutAnimation(this._OutPlus);
    int i;
    if (paramInt > 0) {
      i = this._Speed;
    }
    for (this._Speed = Math.min(300, this._Speed + paramInt - i % paramInt);; this._Speed += 5)
    {
      updateSpeed();
      return;
    }
  }
  
  public int getSelectedSpeed()
  {
    return this._Speed;
  }
  
  public void initialize(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 30) {
      i = 0;
    }
    this._Speed = i;
    updateSpeed();
  }
  
  protected void updateSpeed()
  {
    float f = this._Speed / 100.0F;
    this._PlaybackSpeedInfo.setText(this._PlaybackSpeedFormat.format(f));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/PlaybackSpeedControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */