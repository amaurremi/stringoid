package com.skplanet.tad;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.skplanet.tad.controller.h;
import com.skplanet.tad.mraid.controller.MraidController.PlayerProperties;
import com.skplanet.tad.mraid.controller.util.MraidPlayer;
import com.skplanet.tad.mraid.controller.util.MraidPlayerListener;
import com.skplanet.tad.mraid.controller.util.MraidUtils;
import com.skplanet.tad.mraid.view.MraidView;
import com.skplanet.tad.v2.controller.a.a;
import com.skplanet.tad.v2.controller.c;
import com.skplanet.tad.v2.view.PopupWebview;
import com.skplanet.tad.view.LogoView;
import com.skplanet.tad.view.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AdActivity
  extends Activity
{
  private static Message c;
  private static Message d;
  private static Bitmap e;
  public com.skplanet.tad.mraid.view.a a = new com.skplanet.tad.mraid.view.a()
  {
    public void a(MraidView paramAnonymousMraidView)
    {
      if (paramAnonymousMraidView != null) {
        paramAnonymousMraidView.f();
      }
    }
    
    public void b(MraidView paramAnonymousMraidView) {}
    
    public void c(MraidView paramAnonymousMraidView) {}
    
    public void d(MraidView paramAnonymousMraidView)
    {
      paramAnonymousMraidView.c();
      paramAnonymousMraidView.d();
      AdActivity.this.finish();
    }
    
    public void e(MraidView paramAnonymousMraidView) {}
    
    public void f(MraidView paramAnonymousMraidView) {}
    
    public void g(MraidView paramAnonymousMraidView) {}
  };
  public com.skplanet.tad.view.a b = new com.skplanet.tad.view.a()
  {
    public void a()
    {
      AdActivity.this.finish();
    }
  };
  private HashMap f = new HashMap();
  private String g;
  private a h;
  private FrameLayout i;
  private MraidView j;
  private boolean k = false;
  private String l = null;
  
  private MraidPlayer a(Bundle paramBundle, a parama)
  {
    MraidController.PlayerProperties localPlayerProperties = (MraidController.PlayerProperties)paramBundle.getParcelable("player_properties");
    MraidPlayer localMraidPlayer = new MraidPlayer(this);
    localMraidPlayer.setPlayData(localPlayerProperties, paramBundle.getString("player_url"));
    this.f.put(parama, localMraidPlayer);
    a(localMraidPlayer);
    this.i.addView(localMraidPlayer, new FrameLayout.LayoutParams(-1, -1, 17));
    return localMraidPlayer;
  }
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("action");
    this.k = paramBundle.getBoolean("interstitial");
    com.skplanet.tad.common.a.c("AdActivity.doPreAction() > actionData : " + str + ", mIsInterstitialAd : " + this.k);
    if (str == null) {
      return;
    }
    this.h = a.valueOf(str);
    b();
    switch (a()[this.h.ordinal()])
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 2: 
      setRequestedOrientation(paramBundle.getInt("image_orientation"));
      return;
    }
    setRequestedOrientation(0);
  }
  
  public static void a(Message paramMessage)
  {
    c = paramMessage;
  }
  
  private void a(MraidPlayer paramMraidPlayer)
  {
    paramMraidPlayer.setListener(new MraidPlayerListener()
    {
      public void onComplete()
      {
        AdActivity.this.finish();
      }
      
      public void onError()
      {
        AdActivity.this.finish();
      }
      
      public void onPrepared() {}
    });
  }
  
  public static void a(Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap != null) && (paramArrayOfBitmap.length > 0))
    {
      e = paramArrayOfBitmap[0];
      return;
    }
    e = null;
  }
  
  private void b()
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
  
  private void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("action");
    com.skplanet.tad.common.a.c("AdActivity.doPreAction() > actionData : " + str);
    if (str == null) {
      return;
    }
    this.h = a.valueOf(str);
    switch (a()[this.h.ordinal()])
    {
    default: 
      return;
    case 1: 
      c(paramBundle);
      return;
    case 2: 
      d(paramBundle);
      return;
    case 3: 
      e(paramBundle);
      return;
    case 4: 
      a(paramBundle, this.h).playAudio();
      return;
    case 5: 
      a(paramBundle, this.h).playVideo();
      return;
    case 6: 
      g(paramBundle);
      return;
    }
    h(paramBundle);
  }
  
  public static void b(Message paramMessage)
  {
    d = paramMessage;
  }
  
  private void c()
  {
    com.skplanet.tad.common.a.c("AdActivity.notifyClosed,  mActionType : " + this.h);
    try
    {
      switch (a()[this.h.ordinal()])
      {
      case 1: 
      case 2: 
      case 5: 
      case 7: 
        com.skplanet.tad.common.a.c("AdActivity.notifyClosed,  mMessageOnClosed : " + c + ", mIsInterstitialAd : " + this.k);
        if ((c == null) || (!this.k)) {
          return;
        }
        c.sendToTarget();
        c = null;
        return;
      }
    }
    catch (Exception localException)
    {
      com.skplanet.tad.common.a.d("Cannot send the closed message.");
      return;
    }
    com.skplanet.tad.common.a.c("AdActivity.notifyClosed,  mMessageOnDialogClosed : " + d);
    if (d != null)
    {
      d.sendToTarget();
      d = null;
      return;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject2 = (HashMap)paramBundle.getSerializable("mraid_ad.content");
    if (localObject2 == null)
    {
      com.skplanet.tad.common.a.d("AdActivity.loadMraidAd, content == null");
      return;
    }
    Object localObject1 = (String)((HashMap)localObject2).get("mraid_ad.content.base_url");
    localObject2 = (String)((HashMap)localObject2).get("mraid_ad.content.html");
    this.j = new MraidView(this, this.a, true, f(paramBundle));
    this.j.setTracker(new h(this.j, null, this.g));
    this.j.a(-1, -1);
    this.j.loadDataWithBaseURL((String)localObject1, (String)localObject2, "text/html", "utf-8", null);
    this.i.addView(this.j, new FrameLayout.LayoutParams(-1, -1, 17));
    if (!this.j.e())
    {
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AdActivity.a(AdActivity.this).j();
        }
      };
      this.j.a(this.i, paramBundle);
    }
    paramBundle = new LogoView(this);
    localObject1 = new FrameLayout.LayoutParams(paramBundle.a(), paramBundle.a());
    ((FrameLayout.LayoutParams)localObject1).setMargins(paramBundle.b(), paramBundle.b(), paramBundle.b(), paramBundle.b());
    ((FrameLayout.LayoutParams)localObject1).gravity = 83;
    this.i.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
  }
  
  private void d(final Bundle paramBundle)
  {
    final Object localObject = (a.a)paramBundle.getSerializable("image_ad.landing_type");
    final String str1 = paramBundle.getString("image_ad.landing_url");
    final String str2 = paramBundle.getString("image_ad.cookie");
    final String str3 = paramBundle.getString("btb.adsid");
    final String str4 = paramBundle.getString("client_id");
    ImageView localImageView = new ImageView(this);
    localImageView.setImageBitmap(e);
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new com.skplanet.tad.v2.content.a();
        paramAnonymousView.a(paramBundle.getString("image_ad.noti_url"));
        paramAnonymousView.b(paramBundle.getString("image_ad.appstate"));
        paramAnonymousView.e(paramBundle.getString("image_ad.res_id"));
        paramAnonymousView.c(paramBundle.getString("image_ad.cate_id"));
        c localc = new c(AdActivity.this, paramAnonymousView, str4, true, "C");
        switch (a()[localObject.ordinal()])
        {
        }
        for (;;)
        {
          AdActivity.this.finish();
          return;
          com.skplanet.tad.v2.controller.a.a(AdActivity.this, str1);
          paramAnonymousView.a(a.a.a);
          localc.start();
          continue;
          com.skplanet.tad.v2.controller.a.c(AdActivity.this, str1);
          paramAnonymousView.a(a.a.d);
          localc.start();
          continue;
          com.skplanet.tad.v2.controller.a.d(AdActivity.this, str1);
          paramAnonymousView.a(a.a.c);
          localc.start();
          continue;
          com.skplanet.tad.v2.controller.a.a(AdActivity.this, str1, null);
          paramAnonymousView.a(a.a.b);
          localc.start();
          continue;
          com.skplanet.tad.v2.controller.a.a(AdActivity.this, str2, str3, AdActivity.b(AdActivity.this), str1, null, null);
        }
      }
    });
    this.i.addView(localImageView, new FrameLayout.LayoutParams(-1, -1, 17));
    paramBundle = new LogoView(this, str4);
    localObject = new FrameLayout.LayoutParams(paramBundle.a(), paramBundle.a());
    ((FrameLayout.LayoutParams)localObject).gravity = 83;
    ((FrameLayout.LayoutParams)localObject).setMargins(paramBundle.b(), paramBundle.b(), paramBundle.b(), paramBundle.b());
    this.i.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
    this.i.bringChildToFront(paramBundle);
    paramBundle = new DisplayMetrics();
    ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    float f1 = paramBundle.density;
    paramBundle = new ImageView(this);
    paramBundle.setImageBitmap(MraidUtils.bitmapFromJar("/assets/tad_close.png"));
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdActivity.this.finish();
      }
    });
    int n = (int)(50.0F * f1);
    int i1 = (int)(f1 * 50.0F);
    this.i.addView(paramBundle, new FrameLayout.LayoutParams(n, i1, 5));
  }
  
  private void e(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("popup_ad.url");
    PopupWebview localPopupWebview = new PopupWebview(this, this.b);
    localPopupWebview.loadUrl(paramBundle);
    this.i.addView(localPopupWebview, new FrameLayout.LayoutParams(-1, -1, 17));
    paramBundle = new DisplayMetrics();
    ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    float f1 = paramBundle.density;
    paramBundle = new ImageView(this);
    paramBundle.setImageBitmap(MraidUtils.bitmapFromJar("/assets/tad_close.png"));
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AdActivity.this.finish();
      }
    });
    int n = (int)(50.0F * f1);
    int i1 = (int)(f1 * 50.0F);
    this.i.addView(paramBundle, new FrameLayout.LayoutParams(n, i1, 5));
  }
  
  private com.skplanet.tad.controller.b f(Bundle paramBundle)
  {
    paramBundle = (HashMap)paramBundle.getSerializable("ad.event_params");
    if (paramBundle != null)
    {
      com.skplanet.tad.controller.b localb = new com.skplanet.tad.controller.b();
      localb.a = ((String)paramBundle.get("client_id"));
      localb.c = ((String)paramBundle.get("ad_bypass"));
      localb.b = ((String)paramBundle.get("slot_num"));
      localb.d = Boolean.parseBoolean((String)paramBundle.get("test_mode"));
      return localb;
    }
    return null;
  }
  
  private void g(Bundle paramBundle)
  {
    com.skplanet.tad.common.a.c("AdActivity.showCustomDialog");
    int n = paramBundle.getInt("dialog.type");
    if (n == 3) {
      this.l = paramBundle.getString("appIdfor2.0");
    }
    showDialog(n);
  }
  
  private void h(final Bundle paramBundle)
  {
    final String str1 = paramBundle.getString("client_id");
    final String str2 = paramBundle.getString("btb.url");
    String str3 = paramBundle.getString("slot_num");
    if ((str3 != null) && (!TextUtils.isEmpty(str3))) {}
    for (paramBundle = paramBundle.getString("btb.bypass") + "&m_slot=" + str3;; paramBundle = paramBundle.getString("btb.bypass"))
    {
      com.skplanet.tad.common.a.c("AdActivity.loadBTBPlayer adstart, bypassData : " + paramBundle + "clientId : " + str1 + "contentUrl : " + str2);
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            new com.skplanet.tad.videoplayer.a().a(AdActivity.this, com.skplanet.tad.common.b.a(AdActivity.this).f, paramBundle, str1, str2, "Video");
            return;
          }
          catch (Exception localException) {}
        }
      }).start();
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    a(paramBundle);
    this.i = new FrameLayout(this);
    this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.i.setBackgroundColor(Integer.MIN_VALUE);
    this.i.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    setContentView(this.i);
    b(paramBundle);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    com.skplanet.tad.common.a.c("AdActivity.onCreateDialog");
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      localObject = PreferenceManager.getDefaultSharedPreferences(this);
      long l1 = System.currentTimeMillis();
      long l2 = ((SharedPreferences)localObject).getLong("TAD_DIALOG_SHOWED", l1);
      if (com.skplanet.tad.common.b.a(this).b(15))
      {
        com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), already agree");
        finish();
        return null;
      }
      com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), nowDate:" + l1);
      com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), lastShowDate:" + l2);
      com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), fifteenDays:1296000000");
      com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), AdSdkContext.getInstance(this).hasTermsFlag(AdSdkContext.TERMS_AGREE_MMC):" + com.skplanet.tad.common.b.a(this).b(15));
      if ((l1 - l2 == 0L) || (l1 - l2 > 1296000000L))
      {
        localObject = PreferenceManager.getDefaultSharedPreferences(this).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putLong("TAD_DIALOG_SHOWED", l1);
          ((SharedPreferences.Editor)localObject).commit();
        }
        com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), TermsDialogBuilder(this).create()");
        localObject = new e(this).create();
        ((AlertDialog)localObject).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AdActivity.this.finish();
          }
        });
        return (Dialog)localObject;
      }
      com.skplanet.tad.common.a.c("AdActivity.onCreateDialog(), finish()");
      finish();
      return null;
    case 3: 
      localObject = new e(this, this.l).create();
      ((AlertDialog)localObject).setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AdActivity.this.finish();
        }
      });
      return (Dialog)localObject;
    }
    Object localObject = new e(this, false).create();
    ((AlertDialog)localObject).setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AdActivity.this.finish();
      }
    });
    return (Dialog)localObject;
  }
  
  protected void onDestroy()
  {
    if (isFinishing()) {
      c();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    Object localObject;
    if (isFinishing()) {
      localObject = this.f.entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        if (this.j != null)
        {
          localObject = this.j.a();
          if (localObject != null) {
            new Thread((Runnable)localObject).start();
          }
        }
        c();
        super.onPause();
        return;
      }
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      switch (a()[((a)localEntry.getKey()).ordinal()])
      {
      default: 
        break;
      case 4: 
      case 5: 
        ((MraidPlayer)localEntry.getValue()).releasePlayer();
      }
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    AlertDialog localAlertDialog = (AlertDialog)paramDialog;
    if ((localAlertDialog != null) && (localAlertDialog.getButton(-1) != null) && (!com.skplanet.tad.common.b.a(getApplicationContext()).b())) {
      localAlertDialog.getButton(-1).setEnabled(false);
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */