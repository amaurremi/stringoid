package cmn;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class ar
{
  private static Map a = new HashMap();
  private static Map b = new HashMap();
  private static Map c = new WeakHashMap();
  private static ab d = new ab();
  private static ae e = new ae();
  private static Bitmap f = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
  
  public static void a(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, null);
  }
  
  public static void a(ImageView paramImageView, String paramString, ai paramai)
  {
    if (!f.a()) {
      throw new IllegalStateException("Call imagedownloader on the UI thread only.");
    }
    if (paramImageView != null) {
      c.put(paramImageView, paramString);
    }
    Object localObject1 = (Bitmap)d.a(paramString);
    if (localObject1 != null)
    {
      if (localObject1 != f)
      {
        if (paramImageView != null)
        {
          paramImageView.setVisibility(0);
          paramImageView.setImageBitmap((Bitmap)localObject1);
        }
        if (paramai != null) {
          paramai.a(localObject1);
        }
      }
      for (;;)
      {
        if (paramImageView != null) {
          c.remove(paramImageView);
        }
        return;
        if (paramImageView != null) {
          paramImageView.setVisibility(8);
        }
        if (paramai != null) {
          paramai.a(null);
        }
      }
    }
    localObject1 = a;
    if (paramai != null) {}
    for (;;)
    {
      try
      {
        localObject2 = (List)b.get(paramString);
        if (localObject2 != null)
        {
          ((List)localObject2).add(paramai);
          paramai = (List)a.get(paramString);
          if (paramai == null) {
            break;
          }
          if (paramImageView != null) {
            paramai.add(paramImageView);
          }
          return;
        }
      }
      finally {}
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(paramai);
      b.put(paramString, localObject2);
    }
    paramai = new ArrayList();
    if (paramImageView != null) {
      paramai.add(paramImageView);
    }
    a.put(paramString, paramai);
    e.a(paramString, new b(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */