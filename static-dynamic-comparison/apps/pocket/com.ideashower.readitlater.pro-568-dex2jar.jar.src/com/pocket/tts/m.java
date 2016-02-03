package com.pocket.tts;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.pocket.p.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.apache.a.c.k;

public abstract class m
{
  public static ArrayList a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    ArrayList localArrayList;
    label44:
    String str;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("availableVoices");
      if ((paramInt == 0) || (paramIntent == null) || (paramIntent.size() <= 0)) {
        break label158;
      }
      localArrayList = new ArrayList(paramIntent.size());
      Iterator localIterator = paramIntent.iterator();
      if (!localIterator.hasNext()) {
        break label145;
      }
      paramIntent = ((String)localIterator.next()).split("-");
      str = paramIntent[0];
      if (paramIntent.length <= 1) {
        break label135;
      }
      paramActivity = paramIntent[1];
      label85:
      if (paramIntent.length <= 2) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramIntent = paramIntent[2];; paramIntent = null)
    {
      localArrayList.add(new Locale(str, (String)k.e(paramActivity, ""), (String)k.e(paramIntent, "")));
      break label44;
      paramIntent = null;
      break;
      paramActivity = null;
      break label85;
    }
    label145:
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(Locale paramAnonymousLocale1, Locale paramAnonymousLocale2)
      {
        return paramAnonymousLocale1.getDisplayName().compareTo(paramAnonymousLocale2.getDisplayName());
      }
    });
    return localArrayList;
    label158:
    a(paramActivity);
    return null;
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent("com.android.settings.TTS_SETTINGS");
    if (o.a(paramActivity, localIntent))
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    new AlertDialog.Builder(paramActivity).setTitle(2131493788).setMessage(2131493781).setNeutralButton(2131492924, null).show();
  }
  
  public static void a(Context paramContext)
  {
    new AlertDialog.Builder(paramContext).setTitle(2131493780).setMessage(2131493779).setNegativeButton(2131492871, null).setPositiveButton(2131492907, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
        if (o.a(m.this, paramAnonymousDialogInterface))
        {
          m.this.startActivity(paramAnonymousDialogInterface);
          return;
        }
        new AlertDialog.Builder(m.this).setTitle(2131493780).setMessage(2131493784).setNeutralButton(2131492924, null).show();
      }
    }).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */