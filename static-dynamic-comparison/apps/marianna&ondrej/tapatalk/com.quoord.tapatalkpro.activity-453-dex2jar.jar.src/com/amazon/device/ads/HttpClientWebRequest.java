package com.amazon.device.ads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class HttpClientWebRequest
        extends WebRequest {
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String LOG_TAG = HttpClientWebRequest.class.getSimpleName();

    private void prepareFormRequestBody(HttpPost paramHttpPost, String paramString)
            throws WebRequest.WebRequestException {
        paramString = new ArrayList();
        Iterator localIterator = this.postParameters.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            paramString.add(new BasicNameValuePair((String) localEntry.getKey(), (String) localEntry.getValue()));
        }
        try {
            paramHttpPost.setEntity(new UrlEncodedFormEntity(paramString, "UTF-8"));
            return;
        } catch (UnsupportedEncodingException paramHttpPost) {
            Log.e(getLogTag(), "Unsupported character encoding used while creating the request: %s", new Object[]{paramHttpPost.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request", paramHttpPost);
        }
    }

    private void prepareRequestBody(HttpPost paramHttpPost)
            throws WebRequest.WebRequestException {
        Object localObject2 = this.charset;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = "UTF-8";
        }
        String str = this.contentType;
        localObject2 = str;
        if (str == null) {
            localObject2 = "text/plain";
        }
        if (this.requestBody != null) {
            prepareStringRequestBody(paramHttpPost, (String) localObject2, (String) localObject1);
            return;
        }
        prepareFormRequestBody(paramHttpPost, (String) localObject1);
    }

    private void prepareStringRequestBody(HttpPost paramHttpPost, String paramString1, String paramString2)
            throws WebRequest.WebRequestException {
        try {
            paramString2 = new StringEntity(this.requestBody, paramString2);
            paramString2.setContentType(paramString1);
            paramHttpPost.setEntity(paramString2);
            return;
        } catch (UnsupportedEncodingException paramHttpPost) {
            Log.e(getLogTag(), "Unsupported character encoding used while creating the request. ", new Object[]{paramHttpPost.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request.", paramHttpPost);
        }
    }

    protected HttpParams createHttpParams() {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, getTimeout());
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, getTimeout());
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        return localBasicHttpParams;
    }

    protected HttpRequestBase createHttpRequest(URL paramURL)
            throws WebRequest.WebRequestException {
        Iterator localIterator = null;
        URI localURI;
        for (; ; ) {
            try {
                localURI = createURI(paramURL);
                switch (getHttpMethod()) {
                    default:
                        paramURL = localIterator;
                        localIterator = this.headers.entrySet().iterator();
                        if (!localIterator.hasNext()) {
                            break;
                        }
                        Map.Entry localEntry = (Map.Entry) localIterator.next();
                        if ((localEntry.getValue() == null) || (((String) localEntry.getValue()).equals(""))) {
                            continue;
                        }
                        paramURL.addHeader((String) localEntry.getKey(), (String) localEntry.getValue());
                        break;
                    case???:
                    paramURL = new HttpGet(localURI);
                }
            } catch (URISyntaxException paramURL) {
                Log.e(getLogTag(), "Problem with URI syntax: %s", new Object[]{paramURL.getMessage()});
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.MALFORMED_URL, "Problem with URI syntax", paramURL);
            }
            continue;
            paramURL = new HttpPost(localURI);
            prepareRequestBody((HttpPost) paramURL);
        }
        logUrl(localURI.toString());
        if ((this.logRequestBodyEnabled) && (getRequestBody() != null)) {
            Log.d(getLogTag(), "Request Body: %s", new Object[]{getRequestBody()});
        }
        return paramURL;
    }

    protected WebRequest.WebResponse doHttpNetworkCall(URL paramURL)
            throws WebRequest.WebRequestException {
        paramURL = createHttpRequest(paramURL);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(createHttpParams());
        try {
            paramURL = localDefaultHttpClient.execute(paramURL);
            return parseResponse(paramURL);
        } catch (ClientProtocolException paramURL) {
            Log.e(getLogTag(), "Invalid client protocol: %s", new Object[]{paramURL.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", paramURL);
        } catch (IOException paramURL) {
            Log.e(getLogTag(), "IOException during client execution: %s", new Object[]{paramURL.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException during client execution", paramURL);
        }
    }

    protected String getSubLogTag() {
        return LOG_TAG;
    }

    protected WebRequest.WebResponse parseResponse(HttpResponse paramHttpResponse)
            throws WebRequest.WebRequestException {
        WebRequest.WebResponse localWebResponse = new WebRequest.WebResponse(this);
        localWebResponse.setLogTag(getLogTag());
        localWebResponse.enableLog(this.logResponseEnabled);
        localWebResponse.setHttpStatusCode(paramHttpResponse.getStatusLine().getStatusCode());
        localWebResponse.setHttpStatus(paramHttpResponse.getStatusLine().getReasonPhrase());
        if (localWebResponse.getHttpStatusCode() == 200) {
            paramHttpResponse = paramHttpResponse.getEntity();
            if ((paramHttpResponse == null) || (paramHttpResponse.getContentLength() == 0L)) {
            }
        }
        try {
            localWebResponse.setInputStream(paramHttpResponse.getContent());
            return localWebResponse;
        } catch (IOException paramHttpResponse) {
            Log.e(getLogTag(), "IOException while reading the input stream from response: %s", new Object[]{paramHttpResponse.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", paramHttpResponse);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/HttpClientWebRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */