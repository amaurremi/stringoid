package com.atomic.apps.ringtone.cutter;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public final class d
  extends Dialog
{
  private Spinner a;
  private EditText b;
  private Message c;
  private String d;
  private ArrayList e;
  private int f;
  private View.OnClickListener g = new e(this);
  private View.OnClickListener h = new f(this);
  
  public d(Context paramContext, Resources paramResources, String paramString, Message paramMessage)
  {
    super(paramContext);
    setContentView(2130903044);
    setTitle(paramResources.getString(2130968644));
    this.e = new ArrayList();
    this.e.add(paramResources.getString(2130968648));
    this.e.add(paramResources.getString(2130968649));
    this.e.add(paramResources.getString(2130968650));
    this.e.add(paramResources.getString(2130968651));
    this.b = ((EditText)findViewById(2131099701));
    this.d = paramString;
    paramContext = new ArrayAdapter(paramContext, 17367048, this.e);
    paramContext.setDropDownViewResource(17367049);
    this.a = ((Spinner)findViewById(2131099700));
    this.a.setAdapter(paramContext);
    this.a.setSelection(3);
    this.f = 3;
    a(false);
    this.a.setOnItemSelectedListener(new g(this));
    ((Button)findViewById(2131099681)).setOnClickListener(this.g);
    ((Button)findViewById(2131099702)).setOnClickListener(this.h);
    this.c = paramMessage;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.b.getText();
      if (!(this.d + " " + (String)this.e.get(this.f)).contentEquals((CharSequence)localObject)) {
        return;
      }
    }
    int i = this.a.getSelectedItemPosition();
    Object localObject = (String)this.e.get(i);
    this.b.setText(this.d + " " + (String)localObject);
    this.f = this.a.getSelectedItemPosition();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */