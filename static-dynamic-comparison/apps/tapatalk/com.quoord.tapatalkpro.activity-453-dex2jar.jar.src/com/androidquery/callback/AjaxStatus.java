package com.androidquery.callback;

import com.androidquery.util.AQUtility;

import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class AjaxStatus {
    public static final int AUTH_ERROR = -102;
    public static final int DATASTORE = 2;
    public static final int DEVICE = 5;
    public static final int FILE = 3;
    public static final int MEMORY = 4;
    public static final int NETWORK = 1;
    public static final int NETWORK_ERROR = -101;
    public static final int TRANSFORM_ERROR = -103;
    private DefaultHttpClient client;
    private Closeable close;
    private int code = 200;
    private HttpContext context;
    private byte[] data;
    private boolean done;
    private long duration;
    private String error;
    private File file;
    private Header[] headers;
    private boolean invalid;
    private String message = "OK";
    private boolean reauth;
    private String redirect;
    private boolean refresh;
    private int source = 1;
    private long start = System.currentTimeMillis();
    private Date time = new Date();

    public AjaxStatus() {
    }

    public AjaxStatus(int paramInt, String paramString) {
        this.code = paramInt;
        this.message = paramString;
    }

    protected AjaxStatus client(DefaultHttpClient paramDefaultHttpClient) {
        this.client = paramDefaultHttpClient;
        return this;
    }

    public void close() {
        AQUtility.close(this.close);
        this.close = null;
    }

    protected void closeLater(Closeable paramCloseable) {
        this.close = paramCloseable;
    }

    public AjaxStatus code(int paramInt) {
        this.code = paramInt;
        return this;
    }

    protected AjaxStatus context(HttpContext paramHttpContext) {
        this.context = paramHttpContext;
        return this;
    }

    protected AjaxStatus data(byte[] paramArrayOfByte) {
        this.data = paramArrayOfByte;
        return this;
    }

    public AjaxStatus done() {
        this.duration = (System.currentTimeMillis() - this.start);
        this.done = true;
        this.reauth = false;
        return this;
    }

    protected AjaxStatus error(String paramString) {
        this.error = paramString;
        return this;
    }

    public boolean expired(long paramLong) {
        long l = this.time.getTime();
        return (System.currentTimeMillis() - l > paramLong) && (getSource() != 1);
    }

    protected AjaxStatus file(File paramFile) {
        this.file = paramFile;
        return this;
    }

    public DefaultHttpClient getClient() {
        return this.client;
    }

    public int getCode() {
        return this.code;
    }

    public List<Cookie> getCookies() {
        if (this.context == null) {
            return Collections.emptyList();
        }
        CookieStore localCookieStore = (CookieStore) this.context.getAttribute("http.cookie-store");
        if (localCookieStore == null) {
            return Collections.emptyList();
        }
        return localCookieStore.getCookies();
    }

    protected byte[] getData() {
        return this.data;
    }

    protected boolean getDone() {
        return this.done;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getError() {
        return this.error;
    }

    protected File getFile() {
        return this.file;
    }

    public String getHeader(String paramString) {
        if (this.headers == null) {
        }
        for (; ; ) {
            return null;
            int i = 0;
            while (i < this.headers.length) {
                if (paramString.equalsIgnoreCase(this.headers[i].getName())) {
                    return this.headers[i].getValue();
                }
                i += 1;
            }
        }
    }

    public List<Header> getHeaders() {
        if (this.headers == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(this.headers);
    }

    protected boolean getInvalid() {
        return this.invalid;
    }

    public String getMessage() {
        return this.message;
    }

    protected boolean getReauth() {
        return this.reauth;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public boolean getRefresh() {
        return this.refresh;
    }

    public int getSource() {
        return this.source;
    }

    public Date getTime() {
        return this.time;
    }

    protected AjaxStatus headers(Header[] paramArrayOfHeader) {
        this.headers = paramArrayOfHeader;
        return this;
    }

    public AjaxStatus invalidate() {
        this.invalid = true;
        return this;
    }

    public AjaxStatus message(String paramString) {
        this.message = paramString;
        return this;
    }

    protected AjaxStatus reauth(boolean paramBoolean) {
        this.reauth = paramBoolean;
        return this;
    }

    protected AjaxStatus redirect(String paramString) {
        this.redirect = paramString;
        return this;
    }

    protected AjaxStatus refresh(boolean paramBoolean) {
        this.refresh = paramBoolean;
        return this;
    }

    protected AjaxStatus reset() {
        this.duration = (System.currentTimeMillis() - this.start);
        this.done = false;
        close();
        return this;
    }

    protected AjaxStatus source(int paramInt) {
        this.source = paramInt;
        return this;
    }

    protected AjaxStatus time(Date paramDate) {
        this.time = paramDate;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/callback/AjaxStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */