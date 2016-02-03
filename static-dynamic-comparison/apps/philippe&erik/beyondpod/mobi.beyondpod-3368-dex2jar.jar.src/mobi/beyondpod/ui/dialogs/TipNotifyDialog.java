package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class TipNotifyDialog
  extends PopupWindow
{
  View _Arrow;
  CloseListener _CloseListener;
  Context _Context;
  private int _ScreenWidth;
  private final int[] mLocation = new int[2];
  
  public TipNotifyDialog(Context paramContext, final CloseListener paramCloseListener, Spannable paramSpannable)
  {
    super(paramContext);
    this._Context = paramContext;
    this._CloseListener = paramCloseListener;
    setFocusable(true);
    setTouchable(true);
    setOutsideTouchable(false);
    setAnimationStyle(2131558674);
    setHeight(-2);
    this._ScreenWidth = ((WindowManager)this._Context.getSystemService("window")).getDefaultDisplay().getWidth();
    setContentView(LayoutInflater.from(this._Context).inflate(2130903141, null));
    paramContext = getContentView();
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TipNotifyDialog.this.dismiss();
      }
    });
    ((TextView)paramContext.findViewById(2131231121)).setText(paramSpannable);
    this._Arrow = paramContext.findViewById(2131231123);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (paramCloseListener != null) {
          paramCloseListener.onClosed();
        }
      }
    });
  }
  
  public void show(View paramView)
  {
    View localView = getContentView();
    setBackgroundDrawable(new ColorDrawable(0));
    int[] arrayOfInt = this.mLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localView.measure(View.MeasureSpec.makeMeasureSpec(this._ScreenWidth, Integer.MIN_VALUE), -2);
    int i = localView.getMeasuredHeight();
    int j = localView.getMeasuredWidth();
    int k = this._ScreenWidth;
    setWidth(Math.min(k, j));
    j = Math.max(0, k - j - 10);
    i = Math.max(40, arrayOfInt[1] - i + paramView.getHeight() / 2 - 20);
    ((FrameLayout.LayoutParams)this._Arrow.getLayoutParams()).leftMargin = (arrayOfInt[0] + paramView.getWidth() / 2 - j - this._Arrow.getMeasuredWidth() / 2);
    showAtLocation(paramView, 0, j, i);
  }
  
  public static abstract interface CloseListener
  {
    public abstract void onClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/TipNotifyDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */