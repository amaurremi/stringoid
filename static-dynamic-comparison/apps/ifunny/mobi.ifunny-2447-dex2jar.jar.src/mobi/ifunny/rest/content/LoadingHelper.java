package mobi.ifunny.rest.content;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

public class LoadingHelper {
    private final IFunny iFunny;

    public LoadingHelper(IFunny paramIFunny) {
        this.iFunny = paramIFunny;
    }

    public LoadingHelper.LoadSource getDefaultLoadSource() {
        if (this.iFunny.isAbused()) {
            return LoadingHelper.LoadSource.NORMAL;
        }
        if ((this.iFunny.isGifContent()) && (this.iFunny.gif != null) && (!TextUtils.isEmpty(this.iFunny.gif.webm_url))) {
            return LoadingHelper.LoadSource.WEBM;
        }
        if ((TextUtils.equals(this.iFunny.type, "caption")) && (this.iFunny.caption != null) && (!TextUtils.isEmpty(this.iFunny.caption.webp_url))) {
            return LoadingHelper.LoadSource.WEBP;
        }
        if ((TextUtils.equals(this.iFunny.type, "mem")) && (this.iFunny.mem != null) && (!TextUtils.isEmpty(this.iFunny.mem.webp_url))) {
            return LoadingHelper.LoadSource.WEBP;
        }
        if ((TextUtils.equals(this.iFunny.type, "pic")) && (this.iFunny.pic != null) && (!TextUtils.isEmpty(this.iFunny.pic.webp_url))) {
            return LoadingHelper.LoadSource.WEBP;
        }
        if ((TextUtils.equals(this.iFunny.type, "comics")) && (this.iFunny.comics != null) && (!TextUtils.isEmpty(this.iFunny.comics.webp_url))) {
            return LoadingHelper.LoadSource.WEBP;
        }
        return LoadingHelper.LoadSource.NORMAL;
    }

    public String getLoadUrl(LoadingHelper.LoadSource paramLoadSource) {
        switch (LoadingHelper
        .1.$SwitchMap$mobi$ifunny$rest$content$LoadingHelper$LoadSource[paramLoadSource.ordinal()])
        {
        }
        do {
            return this.iFunny.url;
            return this.iFunny.gif.webm_url;
            if (TextUtils.equals(this.iFunny.type, "comics")) {
                return this.iFunny.comics.webp_url;
            }
            if (TextUtils.equals(this.iFunny.type, "caption")) {
                return this.iFunny.caption.webp_url;
            }
            if (TextUtils.equals(this.iFunny.type, "mem")) {
                return this.iFunny.mem.webp_url;
            }
        } while (!TextUtils.equals(this.iFunny.type, "pic"));
        return this.iFunny.pic.webp_url;
    }

    public String getMimeType() {
        return MimeTypeMap.getFileExtensionFromUrl(getLoadUrl(getDefaultLoadSource()));
    }

    public String loadTag() {
        return "task.load." + this.iFunny.uniqueId;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/LoadingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */