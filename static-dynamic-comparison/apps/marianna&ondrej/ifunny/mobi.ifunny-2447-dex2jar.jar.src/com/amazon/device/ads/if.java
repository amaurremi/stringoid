package com.amazon.device.ads;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

public class if
        {
private String b;
private int c;
private String d;
private InputStream e;
private boolean f;
private String g=hy.r();

protected if(hy paramhy){}

public String a()
        {
        if(this.b==null){
        c();
        }
        return this.b;
        }

protected void a(int paramInt)
        {
        this.c=paramInt;
        }

protected void a(InputStream paramInputStream)
        {
        this.e=paramInputStream;
        }

protected void a(String paramString)
        {
        this.b=paramString;
        }

protected void a(boolean paramBoolean)
        {
        this.f=paramBoolean;
        }

public JSONObject b()
        {
        if(a()==null){
        return null;
        }
        try
        {
        JSONObject localJSONObject=new JSONObject(a());
        return localJSONObject;
        }
        catch(JSONException localJSONException)
        {
        for(;;)
        {
        dv.c(this.a.n(),"Unable to parse the body into a JSONObject.");
        Object localObject=null;
        }
        }
        }

protected void b(String paramString)
        {
        this.g=paramString;
        }

protected void c()
        {
        byte[]arrayOfByte;
        if(this.e!=null)
        {
        localStringBuilder=new StringBuilder();
        arrayOfByte=new byte['က'];
        }
        try
        {
        for(;;)
        {
        int i=this.e.read(arrayOfByte);
        if(i==-1){
        break;
        }
        localStringBuilder.append(new String(arrayOfByte,0,i));
        }
        try
        {
        this.e.close();
        a(localStringBuilder.toString());
        if(this.f){
        dv.a(hy.r(),"Response: %s",new Object[]{a()});
        }
        throw((Throwable)localObject);
        }
        catch(IOException localIOException4)
        {
        for(;;)
        {
        dv.c(this.g,"IOException while trying to close the stream");
        }
        }
        }
        catch(IOException localIOException1)
        {
        localIOException1=localIOException1;
        dv.c(this.g,"Unable to read the stream from the network.");
        try
        {
        this.e.close();
        a(localStringBuilder.toString());
        if(this.f){
        dv.a(hy.r(),"Response: %s",new Object[]{a()});
        }
        for(;;)
        {
        return;
        try
        {
        this.e.close();
        a(localStringBuilder.toString());
        if(!this.f){
        continue;
        }
        dv.a(hy.r(),"Response: %s",new Object[]{a()});
        return;
        }
        catch(IOException localIOException2)
        {
        for(;;)
        {
        dv.c(this.g,"IOException while trying to close the stream");
        }
        }
        }
        }
        catch(IOException localIOException3)
        {
        for(;;)
        {
        dv.c(this.g,"IOException while trying to close the stream");
        }
        }
        }
        finally{}
        }

protected void c(String paramString)
        {
        this.d=paramString;
        }

public int d()
        {
        return this.c;
        }

public boolean e()
        {
        return d()==200;
        }

public String f()
        {
        return this.d;
        }
        }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */