package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

class MMJSObject
{
  protected WeakReference<Context> contextRef;
  
  void setContext(Context paramContext)
  {
    this.contextRef = new WeakReference(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMJSObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */