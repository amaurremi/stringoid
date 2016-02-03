package com.inmobi.androidsdk.impl.imai;

import android.app.Activity;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.re.container.IMWebView;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class IMAIClickEvent
  implements Serializable
{
  private static final long serialVersionUID = -80069114195415403L;
  private int a;
  private String b;
  private boolean c;
  private boolean d;
  private int e;
  private boolean f;
  private transient WeakReference<IMWebView> g;
  
  public IMAIClickEvent(String paramString, boolean paramBoolean1, boolean paramBoolean2, WeakReference<IMWebView> paramWeakReference, boolean paramBoolean3, int paramInt)
  {
    if (paramBoolean3) {
      paramInt = Initializer.getConfigParams(((IMWebView)paramWeakReference.get()).getActivity().getApplicationContext()).getImai().getMaxRetry();
    }
    setClickId(IMAIUtility.a());
    setClickURL(paramString);
    setFollowRedirects(paramBoolean1);
    setPingWV(paramBoolean2);
    setRetryCount(paramInt);
    setFirstClick(paramBoolean3);
    setWebviewRef(paramWeakReference);
  }
  
  public int getClickId()
  {
    return this.a;
  }
  
  public String getClickURL()
  {
    return this.b;
  }
  
  public int getRetryCount()
  {
    return this.e;
  }
  
  public WeakReference<IMWebView> getWebviewRef()
  {
    return this.g;
  }
  
  public boolean isFirstClick()
  {
    return this.f;
  }
  
  public boolean isFollowRedirects()
  {
    return this.c;
  }
  
  public boolean isPingWV()
  {
    return this.d;
  }
  
  public void setClickId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setClickURL(String paramString)
  {
    this.b = paramString;
  }
  
  public void setFirstClick(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setFollowRedirects(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setPingWV(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setRetryCount(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWebviewRef(WeakReference<IMWebView> paramWeakReference)
  {
    this.g = paramWeakReference;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/IMAIClickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */