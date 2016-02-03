package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.gau.go.launcherex.gowidget.weather.globalview.f;
import com.gtp.a.a.b.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class k
  extends f
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b;
  private LinearLayout c;
  private int d = -100;
  private LinearLayout e;
  private int f = -100;
  private final PackageManager g;
  private final File h;
  
  public k(Activity paramActivity)
  {
    super(paramActivity);
    setCanceledOnTouchOutside(true);
    setContentView(2130903281);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.b = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    this.g = this.a.getPackageManager();
    this.h = ab.a(this.a);
    if (this.h.exists()) {
      this.h.delete();
    }
    this.c = ((LinearLayout)findViewById(2131231900));
    this.e = ((LinearLayout)findViewById(2131231901));
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(this);
    b();
    c();
  }
  
  private void b()
  {
    Object localObject = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    localObject = this.g.queryIntentActivities((Intent)localObject, 1).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      c.a("PhotoAppsDialog", "initGalleryList: " + localResolveInfo.activityInfo.packageName);
      l locall = new l(this, this.a);
      locall.d = 2;
      locall.a(localResolveInfo);
      this.c.addView(locall.e());
    }
  }
  
  private void c()
  {
    Object localObject = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject).putExtra("output", Uri.fromFile(this.h));
    localObject = this.g.queryIntentActivities((Intent)localObject, 1).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      c.a("PhotoAppsDialog", "initCameraList: " + localResolveInfo.activityInfo.packageName);
      l locall = new l(this, this.a);
      locall.d = 1;
      locall.a(localResolveInfo);
      this.e.addView(locall.e());
    }
  }
  
  public void a()
  {
    a(17, 0, 0, this.b, -2);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    if ((this.c.getWidth() > 0) && (this.d != this.c.getWidth()) && (this.c.getWidth() < this.b))
    {
      this.d = this.c.getWidth();
      ((FrameLayout.LayoutParams)this.c.getLayoutParams()).gravity = 1;
      this.c.requestLayout();
    }
    if ((this.e.getWidth() > 0) && (this.f != this.e.getWidth()) && (this.e.getWidth() < this.b))
    {
      this.f = this.e.getWidth();
      ((FrameLayout.LayoutParams)this.e.getLayoutParams()).gravity = 1;
      this.e.requestLayout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */