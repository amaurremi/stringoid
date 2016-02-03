package com.google.ads.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.GestureStore;
import android.gesture.Prediction;
import com.google.ads.util.b;
import java.util.ArrayList;
import java.util.Iterator;

public class k$a
  implements GestureOverlayView.OnGesturePerformedListener
{
  private final GestureStore a;
  private Activity b;
  private d c;
  
  public k$a(Activity paramActivity, d paramd, GestureStore paramGestureStore)
  {
    this.b = paramActivity;
    this.c = paramd;
    this.a = paramGestureStore;
  }
  
  public void onGesturePerformed(GestureOverlayView paramGestureOverlayView, Gesture paramGesture)
  {
    paramGestureOverlayView = this.a.recognize(paramGesture);
    paramGesture = paramGestureOverlayView.iterator();
    while (paramGesture.hasNext())
    {
      Prediction localPrediction = (Prediction)paramGesture.next();
      b.a("Gesture: '" + localPrediction.name + "' = " + localPrediction.score);
    }
    if (paramGestureOverlayView.size() == 0) {
      b.a("Gesture: No remotely reasonable predictions");
    }
    while ((((Prediction)paramGestureOverlayView.get(0)).score <= 2.0D) || (!"debug".equals(((Prediction)paramGestureOverlayView.get(0)).name)) || (this.c == null)) {
      return;
    }
    if (this.c.c() == null) {}
    for (paramGestureOverlayView = "[No diagnostics available]";; paramGestureOverlayView = this.c.c())
    {
      new AlertDialog.Builder(this.b).setMessage(paramGestureOverlayView).setTitle("Ad Information").setPositiveButton("Share", new k.a.3(this, paramGestureOverlayView)).setNeutralButton("Report", new k.a.2(this)).setNegativeButton("Close", new k.a.1(this)).create().show();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/k$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */