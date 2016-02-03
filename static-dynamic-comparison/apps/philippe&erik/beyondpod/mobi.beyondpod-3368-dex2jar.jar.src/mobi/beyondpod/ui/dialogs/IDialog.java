package mobi.beyondpod.ui.dialogs;

import android.app.Dialog;

public abstract interface IDialog
{
  public abstract Dialog CreateDialog();
  
  public abstract int DialogID();
  
  public abstract void PrepareDialog(Dialog paramDialog);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/IDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */