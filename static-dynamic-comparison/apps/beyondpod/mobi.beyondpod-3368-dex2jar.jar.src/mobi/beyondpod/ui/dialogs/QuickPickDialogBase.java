package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import mobi.beyondpod.R.styleable;

public abstract class QuickPickDialogBase
  extends PopupWindow
{
  protected Context _Context;
  protected ListView _ListView;
  private final int[] _Location = new int[2];
  protected int _ScreenHeight;
  
  public QuickPickDialogBase() {}
  
  public QuickPickDialogBase(Context paramContext)
  {
    super(paramContext);
    this._Context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(R.styleable.TitleButtons);
    setBackgroundDrawable(paramContext.getDrawable(13));
    paramContext.recycle();
    setFocusable(true);
    setTouchable(true);
    setOutsideTouchable(true);
    this._ScreenHeight = ((WindowManager)this._Context.getSystemService("window")).getDefaultDisplay().getHeight();
    setContentView(LayoutInflater.from(this._Context).inflate(2130903090, null));
    this._ListView = ((ListView)getContentView().findViewById(2131230884));
    this._ListView.setCacheColorHint(0);
    this._ListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        QuickPickDialogBase.this.OnItemSelected(paramAnonymousInt);
        QuickPickDialogBase.this.dismiss();
      }
    });
  }
  
  protected abstract void OnItemSelected(int paramInt);
  
  public void show(View paramView)
  {
    Object localObject = this._Location;
    paramView.getLocationOnScreen((int[])localObject);
    int j = (int)Math.max(paramView.getWidth(), paramView.getContext().getResources().getDimension(2131492912));
    int i = (int)((this._ScreenHeight - localObject[1] - paramView.getHeight()) * 0.8D);
    setWidth(j);
    localObject = getContentView();
    ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
    j = ((View)localObject).getMeasuredHeight();
    setHeight(Math.min(i, j));
    setHeight(Math.min(i, j));
    showAsDropDown(paramView, 1, 3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/QuickPickDialogBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */