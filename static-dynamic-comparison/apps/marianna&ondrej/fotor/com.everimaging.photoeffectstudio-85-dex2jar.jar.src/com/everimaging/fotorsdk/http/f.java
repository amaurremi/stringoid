package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class f
        extends c {
    private String[] a = {"image/jpeg", "image/png"};

    public f(String[] paramArrayOfString) {
        if (paramArrayOfString != null) {
            this.a = paramArrayOfString;
            return;
        }
        Log.e("BinaryHttpResponseHandler", "Constructor passed allowedContentTypes was null !");
    }

    public final void a(HttpResponse paramHttpResponse)
            throws IOException {
        int j = 0;
        StatusLine localStatusLine = paramHttpResponse.getStatusLine();
        Object localObject = paramHttpResponse.getHeaders("Content-Type");
        if (localObject.length != 1) {
            b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        localObject = localObject[0];
        String[] arrayOfString = i();
        int k = arrayOfString.length;
        int i = 0;
        String str;
        while (i < k) {
            str = arrayOfString[i];
            try {
                boolean bool = Pattern.matches(str, ((Header) localObject).getValue());
                if (bool) {
                    j = 1;
                }
            } catch (PatternSyntaxException localPatternSyntaxException) {
                for (; ; ) {
                    Log.e("BinaryHttpResponseHandler", "Given pattern is not valid: " + str, localPatternSyntaxException);
                }
            }
            i += 1;
        }
        if (j == 0) {
            b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type not allowed!"));
            return;
        }
        super.a(paramHttpResponse);
    }

    public String[] i() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */