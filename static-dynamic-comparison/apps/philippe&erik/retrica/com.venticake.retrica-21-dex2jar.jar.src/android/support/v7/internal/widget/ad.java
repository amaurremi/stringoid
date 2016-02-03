package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

class ad
  implements DialogInterface.OnClickListener, ag
{
  private AlertDialog b;
  private ListAdapter c;
  private CharSequence d;
  
  private ad(ac paramac) {}
  
  public void a(ListAdapter paramListAdapter)
  {
    this.c = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public void c()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a.getContext());
    if (this.d != null) {
      localBuilder.setTitle(this.d);
    }
    this.b = localBuilder.setSingleChoiceItems(this.c, this.a.f(), this).show();
  }
  
  public void d()
  {
    this.b.dismiss();
    this.b = null;
  }
  
  public boolean f()
  {
    if (this.b != null) {
      return this.b.isShowing();
    }
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(paramInt);
    if (this.a.t != null) {
      this.a.a(null, paramInt, this.c.getItemId(paramInt));
    }
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */