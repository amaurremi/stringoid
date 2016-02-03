package com.appbrain.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.appbrain.b.i;
import com.appbrain.e.j.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class m
{
  private static final String a = m.class.getName();
  private static WeakHashMap b;
  
  static void a(Activity paramActivity, j.i parami)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 11)
    {
      if (b == null) {
        b = new WeakHashMap();
      }
      localObject = (WeakReference)b.get(paramActivity);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject == null) || (!((Dialog)localObject).isShowing()))
        {
          parami = c(paramActivity, parami);
          parami.setOnCancelListener(new n());
          b.put(paramActivity, new WeakReference(parami));
          parami.show();
        }
      }
    }
    do
    {
      return;
      localObject = (Dialog)((WeakReference)localObject).get();
      break;
      paramActivity = paramActivity.getFragmentManager();
      paramActivity.executePendingTransactions();
    } while (paramActivity.findFragmentByTag(b(parami)) != null);
    a.a(paramActivity, parami);
  }
  
  private static String b(j.i parami)
  {
    return a + parami.h();
  }
  
  private static Dialog c(Activity paramActivity, j.i parami)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setMessage(parami.j());
    if (parami.o())
    {
      localBuilder.setNegativeButton(z.c(paramActivity, parami), new o());
      localBuilder.setPositiveButton(z.b(paramActivity, parami), new p(paramActivity, parami));
    }
    for (;;)
    {
      return localBuilder.create();
      localBuilder.setNeutralButton(z.b(paramActivity, parami), new q());
    }
  }
  
  public static final class a
    extends DialogFragment
  {
    private j.i a;
    
    public static void a(FragmentManager paramFragmentManager, j.i parami)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("Alert", parami.b());
      a locala = new a();
      locala.setArguments(localBundle);
      locala.show(paramFragmentManager, m.a(parami));
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      super.onCancel(paramDialogInterface);
      m.a(false);
    }
    
    public final Dialog onCreateDialog(Bundle paramBundle)
    {
      try
      {
        this.a = j.i.a(getArguments().getByteArray("Alert"));
        return m.b(getActivity(), this.a);
      }
      catch (i paramBundle)
      {
        for (;;) {}
      }
    }
    
    public final void onResume()
    {
      super.onResume();
      if (!t.a(this.a)) {
        dismiss();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */