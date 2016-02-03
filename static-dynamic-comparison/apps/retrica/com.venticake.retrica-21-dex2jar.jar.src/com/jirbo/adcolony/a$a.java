package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;

class a$a
  extends Handler
{
  AdColonyAd a;
  
  public void a(AdColonyAd paramAdColonyAd)
  {
    if (paramAdColonyAd == null) {}
    for (this.a = a.H;; this.a = paramAdColonyAd)
    {
      sendMessage(obtainMessage(1));
      return;
    }
  }
  
  public void b(AdColonyAd paramAdColonyAd)
  {
    if (paramAdColonyAd == null) {}
    for (this.a = a.H;; this.a = paramAdColonyAd)
    {
      sendMessage(obtainMessage(0));
      return;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        a.a("skip", this.a);
      } while (a.H == null);
      a.H.f = 1;
      a.H.a();
      return;
      paramMessage = new ADCData.g();
      if (a.J.E.P) {
        paramMessage.b("html5_endcard_loading_started", a.J.k);
      }
      if (a.J.E.P) {
        paramMessage.b("html5_endcard_loading_finished", a.J.l);
      }
      if (a.J.E.P) {
        paramMessage.b("html5_endcard_loading_time", a.J.p);
      }
      if (a.J.E.P) {
        paramMessage.b("html5_endcard_loading_timeout", a.J.m);
      }
      if (a.J.q < 60000.0D) {
        paramMessage.b("endcard_time_spent", a.J.q);
      }
      paramMessage.b("endcard_dissolved", a.J.n);
      ADCVideo localADCVideo = a.J;
      paramMessage.b("replay", ADCVideo.e);
      paramMessage.b("reward", a.J.o);
      a.l.d.a("continue", paramMessage, this.a);
      a.l.b.e();
    } while (a.H == null);
    a.H.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */