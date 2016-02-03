package mobi.ifunny.rest;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class IFunnyRestHttpClient$InflatingEntity
        extends HttpEntityWrapper {
    public IFunnyRestHttpClient$InflatingEntity(HttpEntity paramHttpEntity) {
        super(paramHttpEntity);
    }

    public InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public long getContentLength() {
        return -1L;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient$InflatingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */