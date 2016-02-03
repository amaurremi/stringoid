package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class cs
        extends do
        implements cu.a,ea.a
        {
private final bq ky;
private final dz lC;
private final Object li=new Object();
private final Context mContext;
private bj mR;
private final cr.a oG;
private final Object oH=new Object();
private final cx.a oI;
private final l oJ;
private do oK;
private cz oL;
private boolean oM=false;
private bh oN;
private bn oO;

public cs(Context paramContext,cx.a parama,l paraml,dz paramdz,bq parambq,cr.a parama1)
        {
        this.ky=parambq;
        this.oG=parama1;
        this.lC=paramdz;
        this.mContext=paramContext;
        this.oI=parama;
        this.oJ=paraml;
        }

private ak a(cx paramcx)
        throws cs.a
        {
        if(this.oL.pr==null){
        throw new a("The ad response must specify one of the supported ad sizes.",0);
        }
        Object localObject=this.oL.pr.split("x");
        if(localObject.length!=2){
        throw new a("Could not parse the ad size from the ad response: "+this.oL.pr,0);
        }
        for(;;)
        {
        int i;
        ak localak;
        try
        {
        int m=Integer.parseInt(localObject[0]);
        int n=Integer.parseInt(localObject[1]);
        localObject=paramcx.kN.lU;
        int i1=localObject.length;
        i=0;
        if(i>=i1){
        break;
        }
        localak=localObject[i];
        float f=this.mContext.getResources().getDisplayMetrics().density;
        if(localak.width==-1)
        {
        j=(int)(localak.widthPixels/f);
        if(localak.height!=-2){
        break label253;
        }
        k=(int)(localak.heightPixels/f);
        if((m!=j)||(n!=k)){
        break label263;
        }
        return new ak(localak,paramcx.kN.lU);
        }
        }
        catch(NumberFormatException paramcx)
        {
        throw new a("Could not parse the ad size from the ad response: "+this.oL.pr,0);
        }
        int j=localak.width;
        continue;
        label253:
        int k=localak.height;
        continue;
        label263:
        i+=1;
        }
        throw new a("The ad size from the ad response was not one of the requested sizes: "+this.oL.pr,0);
        }

private void a(cx paramcx,long paramLong)
        throws cs.a
        {
synchronized(this.oH)
        {
        this.oN=new bh(this.mContext,paramcx,this.ky,this.mR);
        this.oO=this.oN.a(paramLong,60000L);
        switch(this.oO.nw)
        {
default:
        throw new a("Unexpected mediation result: "+this.oO.nw,0);
        }
        }
        throw new a("No fill from any mediation ad networks.",3);
        }

private void aZ()
        throws cs.a
        {
        if(this.oL.errorCode==-3){}
        do
        {
        return;
        if(TextUtils.isEmpty(this.oL.pm)){
        throw new a("No fill from ad server.",3);
        }
        }while(!this.oL.po);
        try
        {
        this.mR=new bj(this.oL.pm);
        return;
        }
        catch(JSONException localJSONException)
        {
        throw new a("Could not parse mediation config: "+this.oL.pm,0);
        }
        }

private void b(long paramLong)
        throws cs.a
        {
        dv.rp.post(new Runnable()
        {
public void run()
        {
        for(;;)
        {
synchronized(cs.a(cs.this))
        {
        if(cs.c(cs.this).errorCode!=-2){
        return;
        }
        cs.d(cs.this).bI().a(cs.this);
        if(cs.c(cs.this).errorCode==-3)
        {
        dw.y("Loading URL in WebView: "+cs.c(cs.this).ol);
        cs.d(cs.this).loadUrl(cs.c(cs.this).ol);
        return;
        }
        }
        dw.y("Loading HTML in WebView.");
        cs.d(cs.this).loadDataWithBaseURL(dq.r(cs.c(cs.this).ol),cs.c(cs.this).pm,"text/html","UTF-8",null);
        }
        }
        });
        e(paramLong);
        }

private void d(long paramLong)
        throws cs.a
        {
        do
        {
        if(!f(paramLong)){
        throw new a("Timed out waiting for ad response.",2);
        }
        }while(this.oL==null);
synchronized(this.oH)
        {
        this.oK=null;
        if((this.oL.errorCode!=-2)&&(this.oL.errorCode!=-3)){
        throw new a("There was a problem getting an ad response. ErrorCode: "+this.oL.errorCode,this.oL.errorCode);
        }
        }
        }

private void e(long paramLong)
        throws cs.a
        {
        do
        {
        if(!f(paramLong)){
        throw new a("Timed out waiting for WebView to finish loading.",2);
        }
        }while(!this.oM);
        }

private boolean f(long paramLong)
        throws cs.a
        {
        paramLong=60000L-(SystemClock.elapsedRealtime()-paramLong);
        if(paramLong<=0L){
        return false;
        }
        try
        {
        this.li.wait(paramLong);
        return true;
        }
        catch(InterruptedException localInterruptedException)
        {
        throw new a("Ad request cancelled.",-1);
        }
        }

public void a(cz paramcz)
        {
synchronized(this.li)
        {
        dw.v("Received ad response.");
        this.oL=paramcz;
        this.li.notify();
        return;
        }
        }

public void a(dz arg1)
        {
synchronized(this.li)
        {
        dw.v("WebView finished loading.");
        this.oM=true;
        this.li.notify();
        return;
        }
        }

public void aY()
        {
        for(;;)
        {
        int i;
        long l2;
        long l3;
synchronized(this.li)
        {
        dw.v("AdLoaderBackgroundTask started.");
        String str1=this.oJ.y().a(this.mContext);
        localObject6=new cx(this.oI,str1);
        str1=null;
        localbi=null;
        i=-2;
        l2=-1L;
        l1=l2;
        localObject4=localbi;
        try
        {
        l3=SystemClock.elapsedRealtime();
        l1=l2;
        localObject4=localbi;
        localObject8=cu.a(this.mContext,(cx)localObject6,this);
        l1=l2;
        localObject4=localbi;
        localObject7=this.oH;
        l1=l2;
        localObject4=localbi;
        try
        {
        this.oK=((do)localObject8);
        if(this.oK!=null){
        continue;
        }
        throw new a("Could not start the ad request service.",0);
        }
        finally
        {
        l1=l2;
        localObject4=localbi;
        }
        if(i!=-1){
        break label651;
        }
        }
        catch(a locala)
        {
        i=locala.getErrorCode();
        if(i==3){}
        }
        dw.x(locala.getMessage());
        if(this.oL!=null){
        break label662;
        }
        this.oL=new cz(i);
        dv.rp.post(new Runnable()
        {
public void run()
        {
        cs.this.onStop();
        }
        });
final Object localObject2=localObject4;
        boolean bool=TextUtils.isEmpty(this.oL.pw);
        if(bool){
        break label694;
        }
        try
        {
        localObject4=new JSONObject(this.oL.pw);
        ah localah=((cx)localObject6).pg;
        dz localdz=this.lC;
        List localList1=this.oL.ne;
        List localList2=this.oL.nf;
        List localList3=this.oL.pq;
        int j=this.oL.orientation;
        l2=this.oL.ni;
        String str2=((cx)localObject6).pj;
        bool=this.oL.po;
        if(this.oO==null){
        break label700;
        }
        localbi=this.oO.nx;
        if(this.oO==null){
        break label706;
        }
        localObject6=this.oO.ny;
        if(this.oO==null){
        break label712;
        }
        localObject7=this.oO.nz;
        bj localbj=this.mR;
        if(this.oO==null){
        break label718;
        }
        localObject8=this.oO.nA;
        localObject2=new dh(localah,localdz,localList1,i,localList2,localList3,j,l2,str2,bool,localbi,(br)localObject6,(String)localObject7,localbj,(bl)localObject8,this.oL.pp,(ak)localObject2,this.oL.pn,l1,this.oL.ps,this.oL.pt,(JSONObject)localObject4);
        dv.rp.post(new Runnable()
        {
public void run()
        {
synchronized(cs.a(cs.this))
        {
        cs.b(cs.this).a(localObject2);
        return;
        }
        }
        });
        return;
        }
        catch(Exception localException)
        {
        dw.b("Error parsing the JSON for Active View.",localException);
        }
        l1=l2;
        localObject4=localbi;
        d(l3);
        l1=l2;
        localObject4=localbi;
        l2=SystemClock.elapsedRealtime();
        l1=l2;
        localObject4=localbi;
        aZ();
        l1=l2;
        localObject4=localbi;
        if(((cx)localObject6).kN.lU!=null)
        {
        l1=l2;
        localObject4=localbi;
        localObject2=a((cx)localObject6);
        }
        l1=l2;
        localObject4=localObject2;
        if(this.oL.po)
        {
        l1=l2;
        localObject4=localObject2;
        a((cx)localObject6,l3);
        }
        else
        {
        l1=l2;
        localObject4=localObject2;
        if(this.oL.pu)
        {
        l1=l2;
        localObject4=localObject2;
        c(l3);
        }
        }
        }
        long l1=l2;
        Object localObject4=localObject3;
        b(l3);
        break label724;
        label651:
        dw.z(((a)localObject3).getMessage());
        continue;
        label662:
        this.oL=new cz(i,this.oL.ni);
        continue;
        label694:
        Object localObject5=null;
        continue;
        label700:
        bi localbi=null;
        continue;
        label706:
        Object localObject6=null;
        continue;
        label712:
        Object localObject7=null;
        continue;
        label718:
        Object localObject8=null;
        continue;
        label724:
        l1=l2;
        }
        }

protected void c(long paramLong)
        throws cs.a
        {
final Object localObject=this.lC.R();
        int j;
        if(((ak)localObject).lT){
        j=this.mContext.getResources().getDisplayMetrics().widthPixels;
        }
        for(int i=this.mContext.getResources().getDisplayMetrics().heightPixels;;i=((ak)localObject).heightPixels)
        {
        localObject=new ct(this,this.lC,j,i);
        dv.rp.post(new Runnable()
        {
public void run()
        {
synchronized(cs.a(cs.this))
        {
        if(cs.c(cs.this).errorCode!=-2){
        return;
        }
        cs.d(cs.this).bI().a(cs.this);
        localObject.b(cs.c(cs.this));
        return;
        }
        }
        });
        e(paramLong);
        if(!((ct)localObject).bc()){
        break;
        }
        dw.v("Ad-Network indicated no fill with passback URL.");
        throw new a("AdNetwork sent passback url",3);
        j=((ak)localObject).widthPixels;
        }
        if(!((ct)localObject).bd()){
        throw new a("AdNetwork timed out",2);
        }
        }

public void onStop()
        {
synchronized(this.oH)
        {
        if(this.oK!=null){
        this.oK.cancel();
        }
        this.lC.stopLoading();
        dq.a(this.lC);
        if(this.oN!=null){
        this.oN.cancel();
        }
        return;
        }
        }

private static final class a
        extends Exception {
    private final int oS;

    public a(String paramString, int paramInt) {
        super();
        this.oS = paramInt;
    }

    public int getErrorCode() {
        return this.oS;
    }
}
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */