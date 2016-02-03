package mobi.borken.android.brokenscreen.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class EffectDialog
  extends Dialog
{
  private EffectView effectView;
  private WindowManager.LayoutParams params = new WindowManager.LayoutParams(-1, -1, 2006, 264, -3);
  private ViewGroup view = (ViewGroup)ViewGroup.class.cast(getLayoutInflater().inflate(2130903040, null));
  
  public EffectDialog(Context paramContext)
  {
    super(paramContext);
    getWindow().setAttributes(this.params);
    getWindow().setBackgroundDrawableResource(17170445);
    this.effectView = ((EffectView)EffectView.class.cast(this.view.findViewById(2131296276)));
    this.effectView.setVisibility(4);
  }
  
  public void setBitmapResourceId(int paramInt)
  {
    this.effectView.setBitmapResourceId(paramInt);
  }
  
  public void setOpacity(float paramFloat)
  {
    this.effectView.setOpacity(paramFloat);
  }
  
  public void showEffectView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.effectView.setVisibility(0);
      ((WindowManager)getContext().getSystemService("window")).addView(this.view, this.params);
      show();
      return;
    }
    this.effectView.setVisibility(4);
    ((WindowManager)getContext().getSystemService("window")).removeView(this.view);
    dismiss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/view/EffectDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */