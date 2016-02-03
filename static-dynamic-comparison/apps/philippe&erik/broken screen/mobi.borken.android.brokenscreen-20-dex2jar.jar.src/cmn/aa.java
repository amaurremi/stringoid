package cmn;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class aa
{
  private static final Map a = new HashMap();
  private static final Map b = new HashMap();
  private static final Map c = new WeakHashMap();
  private static final l d = new l();
  private static final Bitmap e = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
  private static n.a f = new n.b();
  private static int g;
  
  public static void a(ImageView paramImageView, String paramString)
  {
    try
    {
      b(paramImageView, paramString, null);
      return;
    }
    finally
    {
      paramImageView = finally;
      throw paramImageView;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, p paramp)
  {
    try
    {
      b(paramImageView, paramString, paramp);
      return;
    }
    finally
    {
      paramImageView = finally;
      throw paramImageView;
    }
  }
  
  private static void b(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    if (paramBitmap == null)
    {
      Object localObject1;
      try
      {
        f.a(paramString, e);
        paramBitmap = (List)a.get(paramString);
        if (paramBitmap != null)
        {
          paramBitmap = paramBitmap.iterator();
          while (paramBitmap.hasNext())
          {
            localObject1 = (ImageView)paramBitmap.next();
            if ((localObject1 != null) && (paramString.equals(c.get(localObject1))))
            {
              if (paramBoolean) {
                ((ImageView)localObject1).setVisibility(8);
              }
              c.remove(localObject1);
            }
          }
        }
        paramBitmap = (List)b.get(paramString);
      }
      finally {}
      if (paramBitmap != null)
      {
        paramBitmap = paramBitmap.iterator();
        while (paramBitmap.hasNext())
        {
          localObject1 = (p)paramBitmap.next();
          try
          {
            ((p)localObject1).a(null);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
      }
      a.remove(paramString);
      b.remove(paramString);
    }
    for (;;)
    {
      return;
      if (g == 0) {
        g = q.b(160.0F) * q.b(160.0F);
      }
      if ((paramBitmap != null) && (paramBitmap.getWidth() * paramBitmap.getHeight() <= g)) {
        f.a(paramString, paramBitmap);
      }
      Object localObject2 = (List)a.get(paramString);
      Object localObject3;
      if ((paramBitmap != null) && (localObject2 != null))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ImageView)((Iterator)localObject2).next();
          if ((localObject3 != null) && (paramString.equals(c.get(localObject3))))
          {
            c.remove(localObject3);
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageBitmap(paramBitmap);
          }
        }
      }
      localObject2 = (List)b.get(paramString);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (p)((Iterator)localObject2).next();
          try
          {
            ((p)localObject3).a(paramBitmap);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      a.remove(paramString);
      b.remove(paramString);
    }
  }
  
  private static void b(ImageView paramImageView, String paramString, p paramp)
  {
    try
    {
      if (!af.a()) {
        throw new IllegalStateException("Call imagedownloader on the UI thread only.");
      }
    }
    finally {}
    if (paramString == null) {}
    for (;;)
    {
      return;
      if (paramImageView != null) {
        c.put(paramImageView, paramString);
      }
      Object localObject = (Bitmap)f.a(paramString);
      if (localObject != null)
      {
        if (localObject != e)
        {
          if (paramImageView != null)
          {
            paramImageView.setVisibility(0);
            paramImageView.setImageBitmap((Bitmap)localObject);
          }
          if (paramp != null) {
            paramp.a(localObject);
          }
        }
        for (;;)
        {
          if (paramImageView == null) {
            break label136;
          }
          c.remove(paramImageView);
          break;
          if (paramImageView != null) {
            paramImageView.setVisibility(8);
          }
          if (paramp != null) {
            paramp.a(null);
          }
        }
      }
      else
      {
        label136:
        if (paramp != null)
        {
          List localList = (List)b.get(paramString);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList();
            b.put(paramString, localObject);
          }
          ((List)localObject).add(paramp);
        }
        paramp = (List)a.get(paramString);
        if (paramp != null)
        {
          if (paramImageView != null) {
            paramp.add(paramImageView);
          }
        }
        else
        {
          paramp = new ArrayList();
          if (paramImageView != null) {
            paramp.add(paramImageView);
          }
          a.put(paramString, paramp);
          d.a(paramString, new ab(paramString));
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */