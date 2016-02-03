package mobi.beyondpod.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class ColorPickerDialog
  extends Dialog
{
  private static final String PICK_A_CATEGORY_COLOR = CoreHelper.LoadResourceString(2131297006);
  private int mInitialColor;
  private OnColorChangedListener mListener;
  
  public ColorPickerDialog(Context paramContext, OnColorChangedListener paramOnColorChangedListener, int paramInt)
  {
    super(paramContext);
    this.mListener = paramOnColorChangedListener;
    this.mInitialColor = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2130903095, null);
    ColorPickerView localColorPickerView = (ColorPickerView)paramBundle.findViewById(2131230906);
    localColorPickerView.setOnColorChangedListener(new OnColorChangedListener()
    {
      public void colorChanged(int paramAnonymousInt)
      {
        ColorPickerDialog.this.mListener.colorChanged(paramAnonymousInt);
        ColorPickerDialog.this.dismiss();
      }
    });
    localColorPickerView.setInitialColor(this.mInitialColor);
    ((Button)paramBundle.findViewById(2131230907)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ColorPickerDialog.this.mListener.colorChanged(0);
        ColorPickerDialog.this.dismiss();
      }
    });
    setContentView(paramBundle);
    setTitle(PICK_A_CATEGORY_COLOR);
  }
  
  public static abstract interface OnColorChangedListener
  {
    public abstract void colorChanged(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/ColorPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */