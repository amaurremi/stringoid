package twitter4j.internal.http;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import twitter4j.TwitterException;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public class HttpClientImpl
        extends HttpClientBase
        implements HttpResponseCode, Serializable {
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap = new HashMap(1);
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -8819171414069621503L;

    static {
        if (ConfigurationContext.getInstance().isDalvik()) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance());
    }

    public HttpClientImpl(HttpClientConfiguration paramHttpClientConfiguration) {
        super(paramHttpClientConfiguration);
    }

    public static HttpClient getInstance(HttpClientConfiguration paramHttpClientConfiguration) {
        HttpClient localHttpClient = (HttpClient) instanceMap.get(paramHttpClientConfiguration);
        Object localObject = localHttpClient;
        if (localHttpClient == null) {
            localObject = new HttpClientImpl(paramHttpClientConfiguration);
            instanceMap.put(paramHttpClientConfiguration, localObject);
        }
        return (HttpClient) localObject;
    }

    private void setHeaders(HttpRequest paramHttpRequest, HttpURLConnection paramHttpURLConnection) {
        if (logger.isDebugEnabled()) {
            logger.debug("Request: ");
            logger.debug(paramHttpRequest.getMethod().name() + " ", paramHttpRequest.getURL());
        }
        Object localObject;
        if (paramHttpRequest.getAuthorization() != null) {
            localObject = paramHttpRequest.getAuthorization().getAuthorizationHeader(paramHttpRequest);
            if (localObject != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Authorization: ", z_T4JInternalStringUtil.maskString((String) localObject));
                }
                paramHttpURLConnection.addRequestProperty("Authorization", (String) localObject);
            }
        }
        if (paramHttpRequest.getRequestHeaders() != null) {
            localObject = paramHttpRequest.getRequestHeaders().keySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                String str = (String) ((Iterator) localObject).next();
                paramHttpURLConnection.addRequestProperty(str, (String) paramHttpRequest.getRequestHeaders().get(str));
                logger.debug(str + ": " + (String) paramHttpRequest.getRequestHeaders().get(str));
            }
        }
    }

    public HttpResponse get(String paramString)
            throws TwitterException {
        return request(new HttpRequest(RequestMethod.GET, paramString, null, null, null));
    }

    protected HttpURLConnection getConnection(String paramString)
            throws IOException {
        Proxy localProxy;
        if (isProxyConfigured()) {
            if ((this.CONF.getHttpProxyUser() != null) && (!this.CONF.getHttpProxyUser().equals(""))) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
                    logger.debug("Proxy AuthPassword: " + z_T4JInternalStringUtil.maskString(this.CONF.getHttpProxyPassword()));
                }
                Authenticator.setDefault(new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            localProxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            if (logger.isDebugEnabled()) {
                logger.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":" + this.CONF.getHttpProxyPort() + ")");
            }
        }
        for (paramString = (HttpURLConnection) new URL(paramString).openConnection(localProxy); ; paramString = (HttpURLConnection) new URL(paramString).openConnection()) {
            if (this.CONF.getHttpConnectionTimeout() > 0) {
                paramString.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
            }
            if (this.CONF.getHttpReadTimeout() > 0) {
                paramString.setReadTimeout(this.CONF.getHttpReadTimeout());
            }
            paramString.setInstanceFollowRedirects(false);
            return paramString;
        }
    }

    public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter)
            throws TwitterException {
        return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, null, null));
    }

    public HttpResponse request(HttpRequest paramHttpRequest)
            throws TwitterException {
        int m = this.CONF.getHttpRetryCount();
        int j = 0;
        Object localObject8 = null;
        int i;
        Object localObject9;
        Object localObject1;
        Object localObject10;
        Object localObject11;
        Object localObject12;
        int k;
        if (j < m + 1) {
            i = -1;
            Object localObject5 = null;
            localObject9 = null;
            localObject1 = localObject9;
            try {
                localObject10 = getConnection(paramHttpRequest.getURL());
                localObject1 = localObject9;
                ((HttpURLConnection) localObject10).setDoInput(true);
                localObject1 = localObject9;
                setHeaders(paramHttpRequest, (HttpURLConnection) localObject10);
                localObject1 = localObject9;
                ((HttpURLConnection) localObject10).setRequestMethod(paramHttpRequest.getMethod().name());
                localObject1 = localObject9;
                if (paramHttpRequest.getMethod() != RequestMethod.POST) {
                    break label803;
                }
                localObject1 = localObject9;
                if (!HttpParameter.containsFile(paramHttpRequest.getParameters())) {
                    break label1013;
                }
                localObject1 = localObject9;
                localObject5 = "----Twitter4J-upload" + System.currentTimeMillis();
                localObject1 = localObject9;
                ((HttpURLConnection) localObject10).setRequestProperty("Content-Type", "multipart/form-data; boundary=" + (String) localObject5);
                localObject1 = localObject9;
                localObject11 = "--" + (String) localObject5;
                localObject1 = localObject9;
                ((HttpURLConnection) localObject10).setDoOutput(true);
                localObject1 = localObject9;
                localObject5 = ((HttpURLConnection) localObject10).getOutputStream();
                localObject1 = localObject5;
                localObject12 = new DataOutputStream((OutputStream) localObject5);
                localObject1 = localObject5;
                HttpParameter[] arrayOfHttpParameter = paramHttpRequest.getParameters();
                localObject1 = localObject5;
                int n = arrayOfHttpParameter.length;
                k = 0;
                label257:
                if (k >= n) {
                    break label741;
                }
                localObject9 = arrayOfHttpParameter[k];
                localObject1 = localObject5;
                if (!((HttpParameter) localObject9).isFile()) {
                    break label606;
                }
                localObject1 = localObject5;
                write((DataOutputStream) localObject12, (String) localObject11 + "\r\n");
                localObject1 = localObject5;
                write((DataOutputStream) localObject12, "Content-Disposition: form-data; name=\"" + ((HttpParameter) localObject9).getName() + "\"; filename=\"" + ((HttpParameter) localObject9).getFile().getName() + "\"\r\n");
                localObject1 = localObject5;
                write((DataOutputStream) localObject12, "Content-Type: " + ((HttpParameter) localObject9).getContentType() + "\r\n\r\n");
                localObject1 = localObject5;
                if (!((HttpParameter) localObject9).hasFileBody()) {
                    break label560;
                }
                localObject1 = localObject5;
                localObject9 = ((HttpParameter) localObject9).getFileBody();
                label434:
                localObject1 = localObject5;
                localObject9 = new BufferedInputStream((InputStream) localObject9);
                localObject1 = localObject5;
                byte[] arrayOfByte = new byte['Ѐ'];
                for (; ; ) {
                    localObject1 = localObject5;
                    int i1 = ((BufferedInputStream) localObject9).read(arrayOfByte);
                    if (i1 == -1) {
                        break;
                    }
                    localObject1 = localObject5;
                    ((DataOutputStream) localObject12).write(arrayOfByte, 0, i1);
                }
                localObject1 = localObject9;
            } finally {
                localObject9 = localObject8;
                localObject8 = localObject1;
            }
            label506:
            k = i;
        }
        for (; ; ) {
            try {
                ((OutputStream) localObject8).close();
                localObject1 = localObject9;
                k = i;
                throw ((Throwable) localObject6);
            } catch (IOException localIOException) {
                Object localObject7;
                if (j == this.CONF.getHttpRetryCount()) {
                    throw new TwitterException(localIOException.getMessage(), localIOException, k);
                    localObject1 = localIOException;
                    localObject9 = new FileInputStream(((HttpParameter) localObject9).getFile());
                    break label434;
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, "\r\n");
                    localObject1 = localIOException;
                    ((BufferedInputStream) localObject9).close();
                    break label1334;
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, (String) localObject11 + "\r\n");
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, "Content-Disposition: form-data; name=\"" + ((HttpParameter) localObject9).getName() + "\"\r\n");
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
                    localObject1 = localIOException;
                    logger.debug(((HttpParameter) localObject9).getValue());
                    localObject1 = localIOException;
                    ((DataOutputStream) localObject12).write(((HttpParameter) localObject9).getValue().getBytes("UTF-8"));
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, "\r\n");
                    break label1334;
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, (String) localObject11 + "--\r\n");
                    localObject1 = localIOException;
                    write((DataOutputStream) localObject12, "\r\n");
                    localObject1 = localIOException;
                    localIOException.flush();
                    localObject1 = localIOException;
                    localIOException.close();
                    localObject1 = localIOException;
                    localObject9 = new HttpResponseImpl((HttpURLConnection) localObject10, this.CONF);
                    try {
                        k = ((HttpURLConnection) localObject10).getResponseCode();
                        i = k;
                        if (!logger.isDebugEnabled()) {
                            break label1343;
                        }
                        i = k;
                        logger.debug("Response: ");
                        i = k;
                        localObject1 = ((HttpURLConnection) localObject10).getHeaderFields();
                        i = k;
                        localObject8 = ((Map) localObject1).keySet().iterator();
                        i = k;
                        if (!((Iterator) localObject8).hasNext()) {
                            break label1343;
                        }
                        i = k;
                        localObject10 = (String) ((Iterator) localObject8).next();
                        i = k;
                        localObject11 = ((List) ((Map) localObject1).get(localObject10)).iterator();
                        i = k;
                        if (!((Iterator) localObject11).hasNext()) {
                            continue;
                        }
                        i = k;
                        localObject12 = (String) ((Iterator) localObject11).next();
                        if (localObject10 == null) {
                            continue;
                        }
                        i = k;
                        logger.debug((String) localObject10 + ": " + (String) localObject12);
                        continue;
                        break label506;
                    } finally {
                        localObject8 = localIOException;
                        localObject7 = localObject2;
                    }
                    localObject3 = localObject9;
                    ((HttpURLConnection) localObject10).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    localObject3 = localObject9;
                    localObject7 = HttpParameter.encodeParameters(paramHttpRequest.getParameters());
                    localObject3 = localObject9;
                    logger.debug("Post Params: ", (String) localObject7);
                    localObject3 = localObject9;
                    localObject11 = ((String) localObject7).getBytes("UTF-8");
                    localObject3 = localObject9;
                    ((HttpURLConnection) localObject10).setRequestProperty("Content-Length", Integer.toString(localObject11.length));
                    localObject3 = localObject9;
                    ((HttpURLConnection) localObject10).setDoOutput(true);
                    localObject3 = localObject9;
                    localObject7 = ((HttpURLConnection) localObject10).getOutputStream();
                    localObject3 = localObject7;
                    ((OutputStream) localObject7).write((byte[]) localObject11);
                    continue;
                    i = k;
                    logger.debug((String) localObject12);
                    continue;
                    if ((k != 420) && (k != 400) && (k >= 500)) {
                        i = k;
                        if (j != this.CONF.getHttpRetryCount()) {
                        }
                    } else {
                        i = k;
                        throw new TwitterException(((HttpResponse) localObject9).asString(), (HttpResponse) localObject9);
                        localObject3 = localObject9;
                    }
                }
                try {
                    ((OutputStream) localObject7).close();
                    return (HttpResponse) localObject9;
                } catch (Exception paramHttpRequest) {
                    return (HttpResponse) localObject9;
                }
                Object localObject3 = localObject9;
                try {
                    ((OutputStream) localObject7).close();
                    localObject3 = localObject9;
                } catch (Exception localException1) {
                    Object localObject4 = localObject9;
                    continue;
                }
                try {
                    if ((logger.isDebugEnabled()) && (localObject3 != null)) {
                        ((HttpResponse) localObject3).asString();
                    }
                    logger.debug("Sleeping " + this.CONF.getHttpRetryIntervalSeconds() + " seconds until the next retry.");
                    Thread.sleep(this.CONF.getHttpRetryIntervalSeconds() * 1000);
                } catch (InterruptedException localInterruptedException) {
                    continue;
                }
                j += 1;
                localObject8 = localObject3;
            } catch (Exception localException2) {
                label560:
                label606:
                label741:
                label803:
                label1013:
                continue;
            }
            return (HttpResponse) localObject8;
            label1334:
            k += 1;
            break label257;
            label1343:
            if (k >= 200) {
                if ((k == 302) || (300 > k)) {
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */