package com.google.android.gms.appindexing;

import android.net.Uri;
import android.view.View;

public final class AppIndexApi$AppIndexingLink
{
  public final Uri appIndexingUrl;
  public final int viewId;
  public final Uri webUrl;
  
  public AppIndexApi$AppIndexingLink(Uri paramUri1, Uri paramUri2, View paramView)
  {
    this.appIndexingUrl = paramUri1;
    this.webUrl = paramUri2;
    this.viewId = paramView.getId();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/appindexing/AppIndexApi$AppIndexingLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */