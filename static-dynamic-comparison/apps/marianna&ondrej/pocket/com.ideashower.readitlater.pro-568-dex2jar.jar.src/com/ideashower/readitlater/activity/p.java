package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.toolbars.SaveCancelToolbar;
import com.pocket.c.e;
import com.pocket.d.b;
import com.pocket.d.n;
import com.pocket.widget.Header;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class p
  extends f
  implements b
{
  private SaveCancelToolbar Y;
  private LinearLayout Z;
  private AvatarView aa;
  private com.pocket.d.a ab;
  private com.pocket.d.a ac;
  private final HashMap ad = new HashMap();
  
  public static com.pocket.p.l Y()
  {
    if (com.ideashower.readitlater.util.j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  public static p Z()
  {
    return new p();
  }
  
  public static void a(android.support.v4.app.f paramf)
  {
    if (Y() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(Z(), paramf);
      return;
    }
    EditAvatarActivity.d(paramf);
  }
  
  private void aa()
  {
    if (this.ab == null)
    {
      P();
      return;
    }
    final ProgressDialog localProgressDialog = new ProgressDialog(m());
    localProgressDialog.setMessage(a(2131493142));
    localProgressDialog.show();
    e.a(this.ab.n(), new com.ideashower.readitlater.d.f()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        localProgressDialog.dismiss();
        if (paramAnonymousBoolean) {
          p.this.P();
        }
      }
    });
  }
  
  private void ab()
  {
    e(new com.pocket.d.k(m(), this, this));
    e(new n(m(), this));
    e(new com.pocket.d.l(m(), this));
    e(new com.pocket.d.j(m(), this));
  }
  
  private void ac()
  {
    PackageManager localPackageManager = m().getPackageManager();
    ResolveInfo localResolveInfo;
    if (localPackageManager.hasSystemFeature("android.hardware.camera"))
    {
      localObject = localPackageManager.queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), 65536).iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
        e(new com.pocket.d.g(m(), this, localResolveInfo, a(2131492955), this, 1));
        i += 1;
      }
    }
    int j = 0;
    Object localObject = new Intent("android.intent.action.PICK");
    ((Intent)localObject).setType("image/*");
    localObject = localPackageManager.queryIntentActivities((Intent)localObject, 65536).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      e(new com.pocket.d.g(m(), this, localResolveInfo, String.valueOf(localResolveInfo.loadLabel(localPackageManager)), this, 2));
      j += 1;
    }
    if (j == 0) {
      this.Z.removeViewAt(this.Z.getChildCount() - 1);
    }
  }
  
  private void ad()
  {
    if (this.ac != null)
    {
      this.ac.q();
      this.ac = null;
    }
  }
  
  private com.pocket.d.a e(com.pocket.d.a parama)
  {
    this.ad.put(parama.o(), parama);
    this.Z.addView(parama.j());
    parama.f();
    return parama;
  }
  
  public static void e(int paramInt)
  {
    i.b().a(com.ideashower.readitlater.h.a.bi, paramInt).a();
  }
  
  public String K()
  {
    return "edit_avatar";
  }
  
  public void L()
  {
    super.L();
    ad();
  }
  
  public void M()
  {
    super.M();
    ad();
  }
  
  public void a(final com.pocket.d.a parama)
  {
    parama.i();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(m());
    localBuilder.setTitle(2131493090);
    localBuilder.setMessage(String.format(a(2131493059), new Object[] { com.ideashower.readitlater.a.g.a(parama.c()) })).setPositiveButton(2131492932, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        parama.onClick(null);
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    }).show();
  }
  
  public void a(com.pocket.d.a parama, Bitmap paramBitmap)
  {
    this.aa.setImageBitmap(paramBitmap);
    this.ab = parama;
  }
  
  public void b(com.pocket.d.a parama)
  {
    this.ac = parama;
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903043, paramViewGroup, false);
  }
  
  public void c(com.pocket.d.a parama)
  {
    parama.h();
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Y = ((SaveCancelToolbar)c(2131230742));
    this.Z = ((LinearLayout)c(2131230754));
    this.aa = ((AvatarView)c(2131230733));
    this.Y.setIsRainbowified(true);
    this.Y.setOnActionTakenListener(new com.ideashower.readitlater.views.toolbars.a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          p.a(p.this);
          return;
        }
        p.this.P();
      }
    });
    Object localObject = Header.a(m(), 2131493280);
    ((Header)localObject).setMaxLines(1);
    ((Header)localObject).setEllipsize(TextUtils.TruncateAt.END);
    this.Z.addView((View)localObject);
    ac();
    localObject = Header.a(m(), 2131493371);
    ((Header)localObject).setMaxLines(1);
    ((Header)localObject).setEllipsize(TextUtils.TruncateAt.END);
    this.Z.addView((View)localObject);
    ab();
    this.aa.setFriend(o.c().e());
    if (paramBundle != null)
    {
      localObject = this.ad.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.pocket.d.a locala = (com.pocket.d.a)((Iterator)localObject).next();
        Bundle localBundle = paramBundle.getBundle(locala.o());
        if (localBundle != null) {
          locala.a(localBundle);
        }
      }
      localObject = paramBundle.getString("selectedSource");
      if (localObject != null)
      {
        this.ab = ((com.pocket.d.a)this.ad.get(localObject));
        a(this.ab, this.ab.l());
      }
      paramBundle = paramBundle.getString("pendingSource");
      if (paramBundle != null)
      {
        this.ac = ((com.pocket.d.a)this.ad.get(paramBundle));
        this.ac.q();
      }
    }
  }
  
  public void d(com.pocket.d.a parama)
  {
    parama.i();
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.ac != null) {
      paramBundle.putString("pendingSource", this.ac.o());
    }
    if (this.ab != null) {
      paramBundle.putString("selectedSource", this.ab.o());
    }
    Iterator localIterator = this.ad.values().iterator();
    while (localIterator.hasNext())
    {
      com.pocket.d.a locala = (com.pocket.d.a)localIterator.next();
      Bundle localBundle = locala.p();
      if (localBundle != null) {
        paramBundle.putBundle(locala.o(), localBundle);
      }
    }
  }
  
  public void y()
  {
    super.y();
    Iterator localIterator = this.ad.values().iterator();
    while (localIterator.hasNext()) {
      ((com.pocket.d.a)localIterator.next()).a(null);
    }
    this.ad.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */