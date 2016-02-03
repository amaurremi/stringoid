package com.google.android.gms.internal;

import android.content.Context;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class du
        extends do
        {
private final String lh;
private final Context mContext;
private final String ro;

public du(Context paramContext,String paramString1,String paramString2)
        {
        this.mContext=paramContext;
        this.lh=paramString1;
        this.ro=paramString2;
        }

public void aY()
        {
        try
        {
        dw.y("Pinging URL: "+this.ro);
        HttpURLConnection localHttpURLConnection=(HttpURLConnection)new URL(this.ro).openConnection();
        try
        {
        dq.a(this.mContext,this.lh,true,localHttpURLConnection);
        int i=localHttpURLConnection.getResponseCode();
        if((i<200)||(i>=300)){
        dw.z("Received non-success response code "+i+" from pinging URL: "+this.ro);
        }
        return;
        }
        finally
        {
        localHttpURLConnection.disconnect();
        }
        return;
        }
        catch(IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
        dw.z("Error while parsing ping URL: "+this.ro+". "+localIndexOutOfBoundsException.getMessage());
        return;
        }
        catch(IOException localIOException)
        {
        dw.z("Error while pinging URL: "+this.ro+". "+localIOException.getMessage());
        }
        }

public void onStop(){}
        }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */