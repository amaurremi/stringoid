package com.atomic.apps.ringtone.cutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;

public class SplashActivity
  extends Activity
{
  private e a;
  
  public final void a()
  {
    super.onBackPressed();
  }
  
  public void onBackPressed()
  {
    Object localObject = getSharedPreferences("mp3cutterapp", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    if (((SharedPreferences)localObject).getBoolean("shownever", false))
    {
      super.onBackPressed();
      return;
    }
    localObject = new AlertDialog.Builder(this);
    View localView = LayoutInflater.from(this).inflate(2130903041, null);
    CheckBox localCheckBox = (CheckBox)localView.findViewById(2131099670);
    ((AlertDialog.Builder)localObject).setView(localView);
    ((AlertDialog.Builder)localObject).setTitle("Rate us!");
    ((AlertDialog.Builder)localObject).setMessage(Html.fromHtml("If you like our app, support us by rating us."));
    ((AlertDialog.Builder)localObject).setPositiveButton("Rate Later", new af(this, localEditor, localCheckBox));
    ((AlertDialog.Builder)localObject).setNegativeButton("Rate Now", new ag(this, localEditor));
    ((AlertDialog.Builder)localObject).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903048);
    if (Build.VERSION.SDK_INT > 8)
    {
      paramBundle = (LinearLayout)findViewById(2131099675);
      paramBundle.setVisibility(8);
      this.a = new e(this);
      this.a.a("ca-app-pub-8029630852891329/2482807096");
      this.a.a(d.g);
      b localb = new c().b(b.a).a();
      this.a.a(new ab(this, paramBundle));
      this.a.a(localb);
      paramBundle.addView(this.a);
    }
    paramBundle = new ac(this);
    findViewById(2131099722).setOnClickListener(paramBundle);
    findViewById(2131099723).setOnClickListener(paramBundle);
    findViewById(2131099724).setOnClickListener(paramBundle);
    paramBundle = new ad(this);
    findViewById(2131099725).setOnClickListener(paramBundle);
    findViewById(2131099726).setOnClickListener(paramBundle);
    findViewById(2131099727).setOnClickListener(paramBundle);
    paramBundle = new ae(this);
    findViewById(2131099728).setOnClickListener(paramBundle);
    findViewById(2131099729).setOnClickListener(paramBundle);
    findViewById(2131099730).setOnClickListener(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.a();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.b();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */