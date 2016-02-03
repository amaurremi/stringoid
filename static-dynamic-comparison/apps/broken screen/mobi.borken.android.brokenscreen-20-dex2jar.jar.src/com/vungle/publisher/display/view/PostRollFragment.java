package com.vungle.publisher.display.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.vungle.publisher.av;
import com.vungle.publisher.av.a;
import com.vungle.publisher.aw.a;

public class PostRollFragment
  extends WebViewFragment
{
  private final a b;
  
  public PostRollFragment(String paramString, aw.a parama, a parama1)
  {
    super(paramString, parama);
    this.b = parama1;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a.setWebChromeClient(new av(this.b));
    return paramLayoutInflater;
  }
  
  public static class a
    extends av.a
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/PostRollFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */