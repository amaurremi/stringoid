package com.pocket.o;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.e.b.a;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import java.util.ArrayList;

public class b
{
  public static void a(Context paramContext, String paramString)
  {
    CharSequence localCharSequence = a.a(paramContext, 2131493080).a("tag_name", paramString).a();
    new AlertDialog.Builder(paramContext).setTitle(2131493081).setMessage(localCharSequence).setPositiveButton(2131492888, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        c.a(b.this, UiContext.a(UiTrigger.e));
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  public static void a(Context paramContext, String paramString1, final String paramString2, final e parame)
  {
    CharSequence localCharSequence = a.a(paramContext, 2131493118).a("new_tag_name", paramString2).a("old_tag_name", paramString1).a();
    new AlertDialog.Builder(paramContext).setTitle(2131493139).setMessage(localCharSequence).setPositiveButton(2131492933, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        c.a(b.this, paramString2, UiContext.a(UiTrigger.e));
        if (parame != null) {
          parame.a(b.this, paramString2);
        }
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  public static void a(Context paramContext, final String paramString, final ArrayList paramArrayList, final e parame)
  {
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903082, null);
    final EditText localEditText = (EditText)localView.findViewById(2131230920);
    localEditText.setText(paramString);
    new AlertDialog.Builder(paramContext).setTitle(2131493139).setView(localView).setPositiveButton(2131492933, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((InputMethodManager)b.this.getSystemService("input_method")).toggleSoftInput(2, 0);
        paramAnonymousDialogInterface = localEditText.getText().toString().trim();
        if (TextUtils.isEmpty(paramAnonymousDialogInterface)) {
          b.a(b.this, paramString);
        }
        do
        {
          do
          {
            return;
            if (paramAnonymousDialogInterface.length() >= 25)
            {
              b.a(b.this, b.this.getString(2131493170), b.this.getString(2131493169));
              return;
            }
            if (paramAnonymousDialogInterface.equals("_untagged_"))
            {
              b.a(b.this, b.this.getString(2131493104), b.this.getString(2131493103, new Object[] { "_untagged_" }));
              return;
            }
          } while (paramAnonymousDialogInterface.equals(paramString));
          if (paramArrayList.contains(paramAnonymousDialogInterface))
          {
            b.a(b.this, paramString, paramAnonymousDialogInterface, parame);
            return;
          }
          c.a(paramString, paramAnonymousDialogInterface, UiContext.a(UiTrigger.e));
        } while (parame == null);
        parame.a(paramString, paramAnonymousDialogInterface);
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInput(2, 0);
    localEditText.requestFocus();
    localEditText.setFocusableInTouchMode(true);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    new AlertDialog.Builder(paramContext).setMessage(paramString2).setTitle(paramString1).setNeutralButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */