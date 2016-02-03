package com.skplanet.tad.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;
import java.io.IOException;

public class LogoView
  extends ImageView
{
  final String a = "tad_logo.png";
  Context b;
  String c;
  boolean d = false;
  private final float e = 15.0F;
  private final int f = 5;
  private View.OnClickListener g = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!b.a(LogoView.this.b).h())
      {
        a.a("LogoView error > permission not defined");
        return;
      }
      if ((b.a(LogoView.this.b).e == null) || (TextUtils.isEmpty(b.a(LogoView.this.b).e)))
      {
        a.a("LogoView error > No usim state");
        return;
      }
      paramAnonymousView = new Bundle();
      paramAnonymousView.putString("action", AdActivity.a.f.toString());
      if (LogoView.this.d)
      {
        paramAnonymousView.putInt("dialog.type", 3);
        paramAnonymousView.putString("appIdfor2.0", LogoView.this.c);
      }
      for (;;)
      {
        Intent localIntent = new Intent(LogoView.this.b, AdActivity.class);
        localIntent.putExtras(paramAnonymousView);
        LogoView.this.b.startActivity(localIntent);
        return;
        paramAnonymousView.putInt("dialog.type", 2);
      }
    }
  };
  
  public LogoView(Context paramContext)
  {
    super(paramContext);
    Object localObject2 = getResources().getAssets();
    Object localObject1 = null;
    try
    {
      localObject2 = BitmapFactory.decodeStream(((AssetManager)localObject2).open("tad_logo.png"));
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    setImageBitmap((Bitmap)localObject1);
    this.b = paramContext;
    setOnClickListener(this.g);
    this.d = false;
  }
  
  public LogoView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.b = paramContext;
    this.c = paramString;
    paramString = getResources().getAssets();
    paramContext = null;
    try
    {
      paramString = BitmapFactory.decodeStream(paramString.open("tad_logo.png"));
      paramContext = paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    setImageBitmap(paramContext);
    setOnClickListener(this.g);
    this.d = true;
  }
  
  public int a()
  {
    return (int)TypedValue.applyDimension(1, 15.0F, this.b.getResources().getDisplayMetrics());
  }
  
  public int b()
  {
    return (int)TypedValue.applyDimension(1, 5.0F, this.b.getResources().getDisplayMetrics());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/LogoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */