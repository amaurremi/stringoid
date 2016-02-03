package com.mocoplex.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class AdlibRewardLink
{
  private static AdlibRewardLink d = null;
  Hashtable<String, AdlibRewardIcon> a = new Hashtable();
  ArrayList<b> b = new ArrayList();
  private Context c = null;
  
  private static int a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  public static AdlibRewardLink getInstance()
  {
    try
    {
      if (d == null) {
        d = new AdlibRewardLink();
      }
      AdlibRewardLink localAdlibRewardLink = d;
      return localAdlibRewardLink;
    }
    finally {}
  }
  
  public final void a(final Context paramContext, final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramContext == null) {}
    AdlibRewardIcon localAdlibRewardIcon;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.a.containsKey(paramString));
        localAdlibRewardIcon = (AdlibRewardIcon)this.a.get(paramString);
      } while (!localAdlibRewardIcon.bShowIcon);
      AdlibConfig.getInstance();
    } while (!AdlibConfig.a(paramContext, localAdlibRewardIcon.iconId));
    localAdlibRewardIcon.iconX = paramInt1;
    localAdlibRewardIcon.iconY = paramInt2;
    localAdlibRewardIcon.iconAlign = paramInt3;
    if (localAdlibRewardIcon.iconFrame != null) {}
    try
    {
      ((ViewGroup)localAdlibRewardIcon.iconFrame.getParent()).removeView(localAdlibRewardIcon.iconFrame);
      localAdlibRewardIcon.iconFrame = null;
      Object localObject1;
      if (localAdlibRewardIcon.animation == null)
      {
        localAdlibRewardIcon.animation = new AnimationDrawable();
        AdlibConfig.getInstance();
        localObject1 = AdlibConfig.a(paramContext) + "icon/" + localAdlibRewardIcon.iconId + "/";
      }
      for (;;)
      {
        try
        {
          Object localObject2 = new File((String)localObject1);
          if (((File)localObject2).listFiles().length > 0)
          {
            localObject2 = ((File)localObject2).listFiles();
            Arrays.sort((Object[])localObject2, new a());
            paramInt3 = localObject2.length;
            paramInt1 = 0;
            if (paramInt1 >= paramInt3) {
              localAdlibRewardIcon.animation.setOneShot(false);
            }
          }
          else
          {
            localObject1 = new AdlibViewGroup(paramContext);
            ((AdlibViewGroup)localObject1).setPosition(localAdlibRewardIcon.iconAlign, localAdlibRewardIcon.iconX, localAdlibRewardIcon.iconY);
            localObject2 = new ImageView(paramContext);
            ((ImageView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(a(paramContext, localAdlibRewardIcon.getWidth()), a(paramContext, localAdlibRewardIcon.getHeight())));
            ((ImageView)localObject2).setBackgroundDrawable(localAdlibRewardIcon.animation);
            ((ImageView)localObject2).setScaleType(ImageView.ScaleType.MATRIX);
            ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AdlibRewardLink.this.showRewardLink(paramContext, paramString);
              }
            });
            ((ImageView)localObject2).post(new c(localAdlibRewardIcon.animation));
            ((AdlibViewGroup)localObject1).addView((View)localObject2);
            ((Activity)paramContext).getWindow().addContentView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
            paramContext = new b((ImageView)localObject2, paramString);
            if (!this.b.contains(paramContext)) {
              this.b.add(paramContext);
            }
            localAdlibRewardIcon.iconFrame = ((View)localObject1);
            return;
          }
          String[] arrayOfString = localObject2[paramInt1];
          localObject3 = localObject1 + arrayOfString.getName();
          if (!arrayOfString.getName().equals("ok"))
          {
            arrayOfString = arrayOfString.getName().split("_");
            try
            {
              paramInt2 = Integer.parseInt(arrayOfString[1]);
            }
            catch (Exception localException2)
            {
              try
              {
                localObject3 = Drawable.createFromPath((String)localObject3);
                localAdlibRewardIcon.animation.addFrame((Drawable)localObject3, paramInt2);
                paramInt1 += 1;
              }
              catch (OutOfMemoryError paramContext)
              {
                throw new Exception();
              }
              localException2 = localException2;
              paramInt2 = 100;
              continue;
            }
          }
          arrayOfByte = new byte[(int)new File((String)localObject3).length()];
        }
        catch (Exception paramContext)
        {
          localAdlibRewardIcon.animation = null;
          return;
        }
        byte[] arrayOfByte;
        new FileInputStream((String)localObject3).read(arrayOfByte);
        Object localObject3 = new String(arrayOfByte).split(",");
        localAdlibRewardIcon.setIconSize(Integer.parseInt(localObject3[0]), Integer.parseInt(localObject3[1]));
      }
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  public void pauseRewardLink(Context paramContext)
  {
    int i;
    if (((Activity)paramContext).isFinishing())
    {
      if (this.b.size() <= 0) {
        return;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= this.b.size())
      {
        this.b.clear();
        this.b.clear();
        if ((this.c != paramContext) || (!((Activity)paramContext).isFinishing())) {
          break;
        }
        this.c = null;
        d = null;
        return;
      }
      Object localObject2 = (b)this.b.get(i);
      Object localObject1 = ((b)localObject2).a;
      localObject2 = ((b)localObject2).b;
      try
      {
        localObject2 = (AdlibRewardIcon)this.a.get(localObject2);
        ((ImageView)localObject1).setBackgroundDrawable(null);
        int j = 0;
        for (;;)
        {
          if (j >= ((AdlibRewardIcon)localObject2).animation.getNumberOfFrames())
          {
            ((AdlibRewardIcon)localObject2).animation = null;
            break;
          }
          localObject1 = ((AdlibRewardIcon)localObject2).animation.getFrame(i);
          if ((localObject1 instanceof Drawable)) {
            ((BitmapDrawable)localObject1).getBitmap().recycle();
          }
          ((Drawable)localObject1).setCallback(null);
          j += 1;
        }
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public void rewardLink(final Context paramContext, final String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    if (paramContext == null) {
      return;
    }
    if (this.c == null) {
      this.c = paramContext;
    }
    if (!this.a.containsKey(paramString))
    {
      Handler local1 = new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          Object localObject1 = (JSONObject)paramAnonymousMessage.obj;
          try
          {
            paramAnonymousMessage = ((JSONObject)localObject1).getString("on");
          }
          catch (JSONException paramAnonymousMessage)
          {
            try
            {
              for (;;)
              {
                localObject1 = ((JSONObject)localObject1).getString("icon");
                boolean bool = false;
                if (paramAnonymousMessage.equals("Y")) {
                  bool = true;
                }
                if (localObject1 != null)
                {
                  paramAnonymousMessage = new AdlibRewardIcon();
                  paramAnonymousMessage.iconId = ((String)localObject1);
                  paramAnonymousMessage.bShowIcon = bool;
                  AdlibRewardLink.this.a.put(paramString, paramAnonymousMessage);
                }
                AdlibRewardLink.this.a(paramContext, paramString, paramInt1, paramInt2, paramInt3);
                return;
                paramAnonymousMessage = paramAnonymousMessage;
                paramAnonymousMessage = "N";
              }
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Object localObject2 = null;
              }
            }
          }
        }
      };
      AdlibConfig.getInstance().a(paramContext, paramString, local1);
      return;
    }
    a(paramContext, paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void showRewardLink(final Context paramContext, final String paramString)
  {
    if (paramContext == null) {}
    while (paramString == null) {
      return;
    }
    Handler local3 = new Handler()
    {
      /* Error */
      public final void handleMessage(Message paramAnonymousMessage)
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 37	android/os/Message:what	I
        //   4: istore_2
        //   5: iload_2
        //   6: tableswitch	default:+18->24, 10:+19->25
        //   24: return
        //   25: aload_1
        //   26: getfield 41	android/os/Message:obj	Ljava/lang/Object;
        //   29: checkcast 43	java/lang/String
        //   32: astore_3
        //   33: new 45	android/os/Bundle
        //   36: dup
        //   37: invokespecial 46	android/os/Bundle:<init>	()V
        //   40: astore_1
        //   41: aload_1
        //   42: ldc 48
        //   44: aload_0
        //   45: getfield 21	com/mocoplex/adlib/AdlibRewardLink$3:b	Ljava/lang/String;
        //   48: invokevirtual 52	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: aload_1
        //   52: ldc 54
        //   54: iconst_2
        //   55: invokevirtual 58	android/os/Bundle:putInt	(Ljava/lang/String;I)V
        //   58: aload_1
        //   59: ldc 60
        //   61: aload_3
        //   62: invokevirtual 52	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   65: new 62	android/content/Intent
        //   68: dup
        //   69: aload_0
        //   70: getfield 23	com/mocoplex/adlib/AdlibRewardLink$3:c	Landroid/content/Context;
        //   73: ldc 64
        //   75: invokespecial 67	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   78: astore_3
        //   79: aload_3
        //   80: aload_1
        //   81: invokevirtual 71	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
        //   84: pop
        //   85: aload_0
        //   86: getfield 23	com/mocoplex/adlib/AdlibRewardLink$3:c	Landroid/content/Context;
        //   89: aload_3
        //   90: invokevirtual 77	android/content/Context:startActivity	(Landroid/content/Intent;)V
        //   93: return
        //   94: astore_1
        //   95: return
        //   96: astore_1
        //   97: return
        //   98: astore_1
        //   99: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	3
        //   0	100	1	paramAnonymousMessage	Message
        //   4	2	2	i	int
        //   32	58	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   85	93	94	java/lang/Exception
        //   0	5	96	java/lang/Exception
        //   25	85	98	java/lang/Exception
      }
    };
    AdlibConfig.getInstance().b(paramContext, paramString, local3);
  }
  
  final class a
    implements Comparator<File>
  {
    a() {}
  }
  
  public final class b
  {
    public ImageView a;
    public String b;
    
    b(ImageView paramImageView, String paramString)
    {
      this.a = paramImageView;
      this.b = paramString;
    }
  }
  
  public final class c
    implements Runnable
  {
    AnimationDrawable a;
    
    c(AnimationDrawable paramAnimationDrawable)
    {
      this.a = paramAnimationDrawable;
    }
    
    public final void run()
    {
      this.a.start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibRewardLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */