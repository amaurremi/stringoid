package cmn;

import android.app.Dialog;
import android.content.DialogInterface;

public final class al
{
  public static void a(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == null) {}
    boolean bool;
    do
    {
      return;
      bool = true;
      if ((paramDialogInterface instanceof Dialog)) {
        bool = ((Dialog)paramDialogInterface).isShowing();
      }
    } while (!bool);
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */