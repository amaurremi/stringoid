package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class do
        implements aa
        {
private static final AtomicBoolean a=new AtomicBoolean(false);
private final Activity b;
private final String c;
private dk d;
private ar e;
private ds f;
private ah g;
private int h;
private boolean i;
private final AtomicBoolean j;
private final AtomicBoolean k;
private Timer l;

private void a(String paramString)
        {
        dv.c("InterstitialAd",paramString);
        i().a(new aj(ak.e,paramString));
        }

private void c(aj paramaj)
        {
        a(ds.a);
        long l1=System.nanoTime();
        if((a()!=null)&&(a().n()!=null))
        {
        a().n().c(eb.a,l1);
        a().n().c(eb.j,l1);
        a().n().c(eb.c,l1);
        if((paramaj!=null)&&((paramaj.a()==ak.c)||(paramaj.a()==ak.a)||(paramaj.a()==ak.b)))
        {
        a().n().a(eb.s);
        if(paramaj.a()==ak.b){
        a().n().a(eb.t);
        }
        }
        }
        b(paramaj);
        }

private void l()
        {
        a().n().a(be.d);
        a().n().a(eb.X);
        bs.a(a());
        }

        int a(az paramaz)
        {
        int n=1;
        long l1=System.nanoTime();
        if(!this.i)
        {
        a("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
        return 1;
        }
        if(!d())
        {
        int m;
        if(c())
        {
        dv.c("InterstitialAd","An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.");
        m=n;
        }
        while(m!=0)
        {
        return-1;
        if(e())
        {
        if((a()!=null)&&(a().m()))
        {
        m=0;
        }
        else
        {
        dv.c("InterstitialAd","An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.");
        m=n;
        }
        }
        else
        {
        m=n;
        if(b())
        {
        dv.c("InterstitialAd","An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.");
        m=n;
        }
        }
        }
        }
        this.j.set(false);
        a(false);
        if(this.l!=null){
        this.l.purge();
        }
        this.l=new Timer();
        this.l.schedule(new dp(this),h());
        a(ds.b);
        a(new ah(bn.h));
        a().n().b(eb.a,l1);
        a().n().b(eb.c,l1);
        a().n().b(eb.b,l1);
        a().n().b(eb.d,l1);
        paramaz.a(this);
        return 0;
        }

        ah a()
        {
        return this.g;
        }

        void a(ah paramah)
        {
        this.g=paramah;
        }

        void a(aj paramaj)
        {
        this.e.onAdFailedToLoad(this,paramaj);
        }

        void a(ds paramds)
        {
        this.f=paramds;
        }

        void a(boolean paramBoolean)
        {
        this.k.set(paramBoolean);
        }

        void b(aj paramaj)
        {
        new Handler(this.b.getApplicationContext().getMainLooper()).post(new dr(this,paramaj));
        }

public boolean b()
        {
        return g()==ds.b;
        }

        boolean b(boolean paramBoolean)
        {
        return this.k.getAndSet(paramBoolean);
        }

public boolean c()
        {
        return g()==ds.d;
        }

        boolean d()
        {
        return(g()==ds.a)||(f());
        }

        boolean e()
        {
        return g()==ds.c;
        }

        boolean f()
        {
        return g()==ds.e;
        }

        ds g()
        {
        return this.f;
        }

public int h()
        {
        return this.h;
        }

        dk i()
        {
        return this.d;
        }

        void j()
        {
        boolean bool=this.j.get();
        fy localfy=fy.e(this.c);
        if(localfy!=null){
        new Handler(this.b.getApplicationContext().getMainLooper()).post(new dq(this,localfy));
        }
        if(bool){
        a().n().a(eb.u);
        }
        c(new aj(ak.a,"Ad Load Timed Out"));
        }

protected void k()
        {
        if((a()!=null)&&(a().n()!=null)&&(!a().n().c()))
        {
        l();
        dy.a().a(a());
        }
        }
        }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */