package com.ideashower.readitlater.views.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class ImageViewer
  extends FrameLayout
  implements e
{
  private HashMap a;
  private HashMap b = new HashMap();
  private ExecutorService c = Executors.newSingleThreadExecutor();
  private int d;
  private c e;
  private c f;
  private c g;
  private i h;
  private View.OnClickListener i;
  
  public ImageViewer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ImageViewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(c paramc, int paramInt)
  {
    if ((com.ideashower.readitlater.e.a)this.a.get(Integer.valueOf(paramInt)) != null)
    {
      paramc.setVisibility(0);
      paramc.setImage(c(paramInt));
      return;
    }
    paramc.setImage(null);
    paramc.setVisibility(8);
  }
  
  private Bitmap c(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    a locala = (a)this.b.get(Integer.valueOf(paramInt));
    if (locala == null) {
      return null;
    }
    return locala.a();
  }
  
  private void setSideImage(c paramc)
  {
    paramc.a(false, null);
    paramc.setOnClickListener(null);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (!b(paramInt)) {
      return;
    }
    a(paramInt, false);
  }
  
  public void a(Context paramContext)
  {
    this.i = new h(this, null);
    setCenterImage(new c(paramContext));
    setLeftImage(new c(paramContext));
    setRightImage(new c(paramContext));
    addView(this.f);
    addView(this.g);
    addView(this.e);
  }
  
  public void a(f paramf)
  {
    paramf = paramf.a();
    float f1 = 10.0F + paramf.a(getWidth());
    this.f.a(paramf.a - f1, true);
    c localc = this.g;
    float f2 = paramf.a;
    localc.a(paramf.d + f2 + f1, false);
  }
  
  public void a(ObjectNode paramObjectNode, int paramInt)
  {
    this.a = new HashMap();
    Iterator localIterator = paramObjectNode.getElements();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.ideashower.readitlater.e.a locala = com.ideashower.readitlater.e.a.a((JsonNode)localIterator.next());
        this.a.put(Integer.valueOf(locala.b()), locala);
        try
        {
          paramObjectNode = new a(locala, this.c);
          if (paramObjectNode != null) {
            this.b.put(Integer.valueOf(locala.b()), paramObjectNode);
          }
        }
        catch (IllegalArgumentException paramObjectNode)
        {
          for (;;)
          {
            com.ideashower.readitlater.util.e.a(paramObjectNode);
            paramObjectNode = null;
          }
        }
      }
    }
    this.d = paramInt;
    this.e.setImage(c(this.d));
    a(this.f, paramInt - 1);
    a(this.g, paramInt + 1);
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.a == null) {
      return false;
    }
    c localc1 = this.f;
    c localc2 = this.e;
    c localc3 = this.g;
    int j = this.d;
    if (paramInt == -1)
    {
      paramInt = j - 1;
      if ((com.ideashower.readitlater.e.a)this.a.get(Integer.valueOf(paramInt)) == null) {
        return false;
      }
      a(localc3, paramInt - 1);
      setLeftImage(localc3);
      localc2.a();
      setRightImage(localc2);
      setCenterImage(localc1);
    }
    for (;;)
    {
      this.e.a(paramBoolean);
      this.d = paramInt;
      if (this.h != null) {
        this.h.C();
      }
      return true;
      paramInt = j + 1;
      if ((com.ideashower.readitlater.e.a)this.a.get(Integer.valueOf(paramInt)) == null) {
        return false;
      }
      a(localc1, paramInt + 1);
      setRightImage(localc1);
      localc2.a();
      setLeftImage(localc2);
      setCenterImage(localc3);
    }
  }
  
  public void b()
  {
    if (this.f == null) {
      return;
    }
    this.f.setImage(null);
    this.e.setImage(null);
    this.g.setImage(null);
  }
  
  public boolean b(int paramInt)
  {
    if (this.a == null) {}
    while (this.a.get(Integer.valueOf(this.d + paramInt)) == null) {
      return false;
    }
    return true;
  }
  
  public com.ideashower.readitlater.e.a getCurrentImage()
  {
    if (this.a == null) {
      return null;
    }
    return (com.ideashower.readitlater.e.a)this.a.get(Integer.valueOf(this.d));
  }
  
  public void setCenterImage(c paramc)
  {
    bringChildToFront(paramc);
    paramc.a(true, this);
    this.e = paramc;
    paramc.setOnClickListener(this.i);
  }
  
  public void setLeftImage(c paramc)
  {
    setSideImage(paramc);
    this.f = paramc;
  }
  
  public void setOnImageChangeListener(i parami)
  {
    this.h = parami;
  }
  
  public void setRightImage(c paramc)
  {
    setSideImage(paramc);
    this.g = paramc;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/ImageViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */