package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.webkit.JavascriptInterface;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.aa;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.reader.ReaderToolbarLayout;
import com.ideashower.readitlater.reader.ReaderWebView;
import com.ideashower.readitlater.reader.c;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.l;
import com.ideashower.readitlater.views.ErrorView;
import com.pocket.webkit.a;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;

public class ReaderFragment$JSInterfaceArticle
  extends ReaderFragment.JSInterfaceConnection
{
  private int c;
  
  public ReaderFragment$JSInterfaceArticle(ReaderFragment paramReaderFragment)
  {
    super(paramReaderFragment, "PocketAndroidArticleInterface");
  }
  
  /* Error */
  private void fixLayout()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_2
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 38	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle:a	Lcom/ideashower/readitlater/activity/ReaderFragment;
    //   10: getfield 60	com/ideashower/readitlater/activity/ReaderFragment:Y	Lcom/ideashower/readitlater/reader/ReaderWebView;
    //   13: invokevirtual 66	com/ideashower/readitlater/reader/ReaderWebView:getContentHeight	()I
    //   16: ifle +15 -> 31
    //   19: aload_0
    //   20: getfield 38	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle:a	Lcom/ideashower/readitlater/activity/ReaderFragment;
    //   23: invokevirtual 70	com/ideashower/readitlater/activity/ReaderFragment:Q	()Z
    //   26: ifeq +43 -> 69
    //   29: iload_2
    //   30: istore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ifeq +34 -> 68
    //   37: invokestatic 74	com/ideashower/readitlater/activity/ReaderFragment:aG	()Lcom/pocket/webkit/a;
    //   40: aload_0
    //   41: getfield 38	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle:a	Lcom/ideashower/readitlater/activity/ReaderFragment;
    //   44: getfield 60	com/ideashower/readitlater/activity/ReaderFragment:Y	Lcom/ideashower/readitlater/reader/ReaderWebView;
    //   47: invokevirtual 79	com/pocket/webkit/a:a	(Landroid/webkit/WebView;)V
    //   50: invokestatic 85	com/ideashower/readitlater/a/g:o	()Landroid/os/Handler;
    //   53: new 24	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle$6
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 87	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle$6:<init>	(Lcom/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle;)V
    //   61: ldc2_w 88
    //   64: invokevirtual 95	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   67: pop
    //   68: return
    //   69: iload_2
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 97	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle:c	I
    //   75: aload_0
    //   76: getfield 38	com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle:a	Lcom/ideashower/readitlater/activity/ReaderFragment;
    //   79: getfield 60	com/ideashower/readitlater/activity/ReaderFragment:Y	Lcom/ideashower/readitlater/reader/ReaderWebView;
    //   82: invokevirtual 66	com/ideashower/readitlater/reader/ReaderWebView:getContentHeight	()I
    //   85: if_icmpeq -54 -> 31
    //   88: iconst_1
    //   89: istore_1
    //   90: goto -59 -> 31
    //   93: astore_3
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	JSInterfaceArticle
    //   5	85	1	i	int
    //   1	69	2	j	int
    //   93	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	29	93	finally
    //   31	33	93	finally
    //   71	88	93	finally
    //   94	96	93	finally
  }
  
  private void requestLayoutFix()
  {
    ReaderFragment.aF().a(this.a.Y);
  }
  
  @JavascriptInterface
  public void ajax(String paramString)
  {
    if ((!isEnabled()) || (!com.ideashower.readitlater.util.f.b())) {}
    while (!ReaderFragment.c(this.a).c().equals(paramString)) {
      return;
    }
    new as(this, ReaderFragment.c(this.a), paramString).h();
  }
  
  @JavascriptInterface
  public int getHorizontalMargin()
  {
    return c.a(this.a.Y);
  }
  
  @JavascriptInterface
  public int getMaxMediaHeight()
  {
    if (!isEnabled()) {
      return 0;
    }
    float f2 = (int)com.ideashower.readitlater.a.g.c().getResources().getDimension(2131296395);
    float f1 = f2;
    if (ReaderFragment.i(this.a).getVisibility() == 0) {
      f1 = f2 * 2.0F;
    }
    f2 = j.a(8.0F);
    return (int)j.b(this.a.aw().getContentHeight() - (f1 + f2));
  }
  
  @JavascriptInterface
  public void loadUrl(final String paramString, final int paramInt)
  {
    if (!isEnabled()) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        }
      } while (!com.ideashower.readitlater.a.g.y());
      throw new RuntimeException("invalid type");
    } while (ReaderFragment.c(this.a).e(paramString) == 0);
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.loadUrl(paramString, paramInt);
        }
      });
      return;
    }
    this.a.a(paramString, paramInt, UiTrigger.n);
  }
  
  @JavascriptInterface
  public void log(String paramString)
  {
    if (!isEnabled()) {}
  }
  
  @JavascriptInterface
  public void onError()
  {
    if (!isEnabled()) {
      return;
    }
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.onError();
        }
      });
      return;
    }
    ReaderFragment.d(this.a).a(this.a.d(2131493602), "", this.a.d(2131492932), new com.ideashower.readitlater.views.m()
    {
      public void a()
      {
        ReaderFragment.JSInterfaceArticle.this.a.a(UiTrigger.p);
      }
    }, false, com.ideashower.readitlater.h.m.b(this.a.m()));
    ReaderFragment.a(this.a, 2);
  }
  
  @JavascriptInterface
  public void onMessageVisible()
  {
    if (!isEnabled()) {}
    final String str;
    do
    {
      return;
      str = ReaderFragment.c(this.a).n();
    } while (str == null);
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        String str1 = str;
        String str2 = ReaderFragment.c(ReaderFragment.JSInterfaceArticle.this.a).a();
        if (ReaderFragment.c(ReaderFragment.JSInterfaceArticle.this.a).b() != null) {}
        for (int i = ReaderFragment.c(ReaderFragment.JSInterfaceArticle.this.a).b().c();; i = 0)
        {
          new aa(str1, str2, i, ReaderFragment.JSInterfaceArticle.this.a.b(null)).j();
          return;
        }
      }
    });
  }
  
  @JavascriptInterface
  public void onReady(final String paramString1, final String paramString2)
  {
    if (!isEnabled()) {}
    do
    {
      return;
      if (!com.ideashower.readitlater.a.g.q())
      {
        com.ideashower.readitlater.a.g.a(new Runnable()
        {
          public void run()
          {
            ReaderFragment.JSInterfaceArticle.this.onReady(paramString1, paramString2);
          }
        });
        return;
      }
      ReaderFragment.c(this.a).a(paramString1, l.a(paramString2));
      ReaderFragment.c(this.a).a(5);
      av.b(ReaderFragment.h(this.a));
      ReaderFragment.b(this.a, true, true);
    } while ((!ReaderFragment.z(this.a)) && (!ReaderFragment.A(this.a)));
    this.a.au();
  }
  
  @JavascriptInterface
  public void onRequestedContentHeight(int paramInt)
  {
    try
    {
      this.c = paramInt;
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.fixLayout();
        }
      });
      return;
    }
    finally {}
  }
  
  @JavascriptInterface
  public void onScrollChanged(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isEnabled()) {
      return;
    }
    ReaderFragment.h(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramInt3);
  }
  
  @JavascriptInterface
  public void pageToRealTop()
  {
    if (!isEnabled()) {}
  }
  
  @JavascriptInterface
  public void placePageBlockers(final int paramInt1, final int paramInt2)
  {
    if (!isEnabled()) {
      return;
    }
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        int i = (int)j.a(ReaderFragment.JSInterfaceArticle.this.a.Y.getTitleHeight());
        ReaderFragment.d(ReaderFragment.JSInterfaceArticle.this.a, true);
        int j = ReaderFragment.JSInterfaceArticle.this.a.Y.a(paramInt1 + i);
        int k = ReaderFragment.JSInterfaceArticle.this.a.Y.a(i + paramInt2);
        i = j;
        if (j < 0) {
          i = 0;
        }
        if (ReaderFragment.x(ReaderFragment.JSInterfaceArticle.this.a) == null) {
          ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, 0, i));
        }
        for (;;)
        {
          i = k + 0;
          j = ReaderFragment.JSInterfaceArticle.this.a.Y.a(ReaderFragment.JSInterfaceArticle.this.a.Y.getContentHeight()) - i;
          if (ReaderFragment.y(ReaderFragment.JSInterfaceArticle.this.a) != null) {
            break;
          }
          ReaderFragment.b(ReaderFragment.JSInterfaceArticle.this.a, ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, i, j));
          return;
          ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, ReaderFragment.x(ReaderFragment.JSInterfaceArticle.this.a), 0, i);
        }
        ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, ReaderFragment.y(ReaderFragment.JSInterfaceArticle.this.a), i, j);
      }
    });
  }
  
  @JavascriptInterface
  public void placePageBlockers(String paramString1, String paramString2)
  {
    if (!isEnabled()) {
      return;
    }
    placePageBlockers(String.valueOf(paramString1), String.valueOf(paramString2));
  }
  
  @JavascriptInterface
  public void setFrozen(final boolean paramBoolean)
  {
    if (!isEnabled()) {
      return;
    }
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.setFrozen(paramBoolean);
        }
      });
      return;
    }
    if (paramBoolean)
    {
      this.a.Y.a(true, false);
      ReaderFragment.aH().a(this.a.Y);
      return;
    }
    this.a.Y.post(new Runnable()
    {
      public void run()
      {
        ReaderFragment.a(ReaderFragment.JSInterfaceArticle.this.a, ReaderFragment.B(ReaderFragment.JSInterfaceArticle.this.a), false);
        ReaderFragment.JSInterfaceArticle.this.a.Y.a(false, true);
      }
    });
  }
  
  @JavascriptInterface
  public void setIsPaging(final boolean paramBoolean)
  {
    if (!isEnabled()) {
      return;
    }
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.setIsPaging(paramBoolean);
        }
      });
      return;
    }
    ReaderFragment.c(this.a, paramBoolean, true);
  }
  
  @JavascriptInterface
  public void setViewType(final int paramInt)
  {
    if (!isEnabled()) {
      return;
    }
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.setViewType(paramInt);
        }
      });
      return;
    }
    this.a.a(paramInt, true, UiTrigger.o);
  }
  
  @JavascriptInterface
  public void toggleFullscreen()
  {
    if (!isEnabled()) {
      return;
    }
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          ReaderFragment.JSInterfaceArticle.this.toggleFullscreen();
        }
      });
      return;
    }
    this.a.aw().a(true);
  }
  
  @JavascriptInterface
  public void updatePageSwipingDisabledAreas(String paramString)
  {
    paramString = l.b(paramString);
    ReaderFragment.w(this.a).clear();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)paramString.next();
      int i = (int)localJsonNode.get("top").asDouble();
      int j = (int)localJsonNode.get("bottom").asDouble();
      ReaderFragment.w(this.a).put(i - 1, j + 1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceArticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */