package twitter4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.NullAuthorization;
import twitter4j.auth.OAuth2Authorization;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;

abstract class TwitterBaseImpl
        implements Serializable, HttpResponseListener, TwitterBase, OAuth2Support, OAuthSupport {
    private static final String WWW_DETAILS = "See http://twitter4j.org/en/configuration.html for details";
    private static final long serialVersionUID = -7824361938865528554L;
    Authorization auth;
    Configuration conf;
    ObjectFactory factory;
    transient HttpClient http;
    private transient long id = 0L;
    private List<RateLimitStatusListener> rateLimitStatusListeners = new ArrayList(0);
    private transient String screenName = null;

    TwitterBaseImpl(Configuration paramConfiguration, Authorization paramAuthorization) {
        this.conf = paramConfiguration;
        this.auth = paramAuthorization;
        init();
    }

    private OAuthSupport getOAuth() {
        if (!(this.auth instanceof OAuthSupport)) {
            throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
        }
        return (OAuthSupport) this.auth;
    }

    private OAuth2Support getOAuth2() {
        if (!(this.auth instanceof OAuth2Support)) {
            throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
        }
        return (OAuth2Support) this.auth;
    }

    private void init() {
        Object localObject;
        String str1;
        String str2;
        if (this.auth == null) {
            localObject = this.conf.getOAuthConsumerKey();
            str1 = this.conf.getOAuthConsumerSecret();
            if ((localObject == null) || (str1 == null)) {
                break label187;
            }
            if (!this.conf.isApplicationOnlyAuthEnabled()) {
                break label126;
            }
            localObject = new OAuth2Authorization(this.conf);
            str1 = this.conf.getOAuth2TokenType();
            str2 = this.conf.getOAuth2AccessToken();
            if ((str1 != null) && (str2 != null)) {
                ((OAuth2Authorization) localObject).setOAuth2Token(new OAuth2Token(str1, str2));
            }
            this.auth = ((Authorization) localObject);
        }
        for (; ; ) {
            this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
            setFactory();
            return;
            label126:
            localObject = new OAuthAuthorization(this.conf);
            str1 = this.conf.getOAuthAccessToken();
            str2 = this.conf.getOAuthAccessTokenSecret();
            if ((str1 != null) && (str2 != null)) {
                ((OAuthAuthorization) localObject).setOAuthAccessToken(new AccessToken(str1, str2));
            }
            this.auth = ((Authorization) localObject);
            continue;
            label187:
            this.auth = NullAuthorization.getInstance();
        }
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
        paramObjectInputStream.readFields();
        this.conf = ((Configuration) paramObjectInputStream.readObject());
        this.auth = ((Authorization) paramObjectInputStream.readObject());
        this.rateLimitStatusListeners = ((List) paramObjectInputStream.readObject());
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream) {
        paramObjectOutputStream.putFields();
        paramObjectOutputStream.writeFields();
        paramObjectOutputStream.writeObject(this.conf);
        paramObjectOutputStream.writeObject(this.auth);
        ArrayList localArrayList = new ArrayList(0);
        Iterator localIterator = this.rateLimitStatusListeners.iterator();
        while (localIterator.hasNext()) {
            RateLimitStatusListener localRateLimitStatusListener = (RateLimitStatusListener) localIterator.next();
            if ((localRateLimitStatusListener instanceof Serializable)) {
                localArrayList.add(localRateLimitStatusListener);
            }
        }
        paramObjectOutputStream.writeObject(localArrayList);
    }

    public void addRateLimitStatusListener(RateLimitStatusListener paramRateLimitStatusListener) {
        this.rateLimitStatusListeners.add(paramRateLimitStatusListener);
    }

    final void ensureAuthorizationEnabled() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details");
        }
    }

    final void ensureOAuthEnabled() {
        if (!(this.auth instanceof OAuthAuthorization)) {
            throw new IllegalStateException("OAuth required. Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details");
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof TwitterBaseImpl)) {
                return false;
            }
            paramObject = (TwitterBaseImpl) paramObject;
            if (this.auth != null) {
                if (this.auth.equals(((TwitterBaseImpl) paramObject).auth)) {
                }
            } else {
                while (((TwitterBaseImpl) paramObject).auth != null) {
                    return false;
                }
            }
            if (!this.conf.equals(((TwitterBaseImpl) paramObject).conf)) {
                return false;
            }
            if (this.http != null) {
                if (this.http.equals(((TwitterBaseImpl) paramObject).http)) {
                }
            } else {
                while (((TwitterBaseImpl) paramObject).http != null) {
                    return false;
                }
            }
        } while (this.rateLimitStatusListeners.equals(((TwitterBaseImpl) paramObject).rateLimitStatusListeners));
        return false;
    }

    User fillInIDAndScreenName() {
        ensureAuthorizationEnabled();
        UserJSONImpl localUserJSONImpl = new UserJSONImpl(this.http.get(this.conf.getRestBaseURL() + "account/verify_credentials.json", null, this.auth, this), this.conf);
        this.screenName = localUserJSONImpl.getScreenName();
        this.id = localUserJSONImpl.getId();
        return localUserJSONImpl;
    }

    public final Authorization getAuthorization() {
        return this.auth;
    }

    public Configuration getConfiguration() {
        return this.conf;
    }

    public long getId() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
        }
        if (0L == this.id) {
            fillInIDAndScreenName();
        }
        return this.id;
    }

    public OAuth2Token getOAuth2Token() {
        try {
            OAuth2Token localOAuth2Token = getOAuth2().getOAuth2Token();
            return localOAuth2Token;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public AccessToken getOAuthAccessToken() {
        for (; ; ) {
            Object localObject4;
            try {
                Object localObject1 = getAuthorization();
                if ((localObject1 instanceof BasicAuthorization)) {
                    localObject1 = (BasicAuthorization) localObject1;
                    localObject4 = AuthorizationFactory.getInstance(this.conf);
                    if ((localObject4 instanceof OAuthAuthorization)) {
                        this.auth = ((Authorization) localObject4);
                        localObject1 = ((OAuthAuthorization) localObject4).getOAuthAccessToken(((BasicAuthorization) localObject1).getUserId(), ((BasicAuthorization) localObject1).getPassword());
                        this.screenName = ((AccessToken) localObject1).getScreenName();
                        this.id = ((AccessToken) localObject1).getUserId();
                        return (AccessToken) localObject1;
                    }
                    throw new IllegalStateException("consumer key / secret combination not supplied.");
                }
            } finally {
            }
            Object localObject3;
            if ((localObject2 instanceof XAuthAuthorization)) {
                localObject3 = (XAuthAuthorization) localObject2;
                this.auth = ((Authorization) localObject3);
                localObject4 = new OAuthAuthorization(this.conf);
                ((OAuthAuthorization) localObject4).setOAuthConsumer(((XAuthAuthorization) localObject3).getConsumerKey(), ((XAuthAuthorization) localObject3).getConsumerSecret());
                localObject3 = ((OAuthAuthorization) localObject4).getOAuthAccessToken(((XAuthAuthorization) localObject3).getUserId(), ((XAuthAuthorization) localObject3).getPassword());
            } else {
                localObject3 = getOAuth().getOAuthAccessToken();
            }
        }
    }

    public AccessToken getOAuthAccessToken(String paramString) {
        try {
            paramString = getOAuth().getOAuthAccessToken(paramString);
            this.screenName = paramString.getScreenName();
            return paramString;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public AccessToken getOAuthAccessToken(String paramString1, String paramString2) {
        try {
            paramString1 = getOAuth().getOAuthAccessToken(paramString1, paramString2);
            return paramString1;
        } finally {
            paramString1 =finally;
            throw paramString1;
        }
    }

    public AccessToken getOAuthAccessToken(RequestToken paramRequestToken) {
        try {
            paramRequestToken = getOAuth().getOAuthAccessToken(paramRequestToken);
            this.screenName = paramRequestToken.getScreenName();
            return paramRequestToken;
        } finally {
            paramRequestToken =finally;
            throw paramRequestToken;
        }
    }

    public AccessToken getOAuthAccessToken(RequestToken paramRequestToken, String paramString) {
        try {
            paramRequestToken = getOAuth().getOAuthAccessToken(paramRequestToken, paramString);
            return paramRequestToken;
        } finally {
            paramRequestToken =finally;
            throw paramRequestToken;
        }
    }

    public RequestToken getOAuthRequestToken() {
        return getOAuthRequestToken(null);
    }

    public RequestToken getOAuthRequestToken(String paramString) {
        return getOAuth().getOAuthRequestToken(paramString);
    }

    public RequestToken getOAuthRequestToken(String paramString1, String paramString2) {
        return getOAuth().getOAuthRequestToken(paramString1, paramString2);
    }

    public String getScreenName() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
        }
        if (this.screenName == null) {
            if ((this.auth instanceof BasicAuthorization)) {
                this.screenName = ((BasicAuthorization) this.auth).getUserId();
                if (this.screenName.contains("@")) {
                    this.screenName = null;
                }
            }
            if (this.screenName == null) {
                fillInIDAndScreenName();
            }
        }
        return this.screenName;
    }

    public int hashCode() {
        int j = 0;
        int k = this.conf.hashCode();
        if (this.http != null) {
        }
        for (int i = this.http.hashCode(); ; i = 0) {
            int m = this.rateLimitStatusListeners.hashCode();
            if (this.auth != null) {
                j = this.auth.hashCode();
            }
            return ((i + k * 31) * 31 + m) * 31 + j;
        }
    }

    public void httpResponseReceived(HttpResponseEvent paramHttpResponseEvent) {
        if (this.rateLimitStatusListeners.size() != 0) {
            Object localObject2 = paramHttpResponseEvent.getResponse();
            TwitterException localTwitterException = paramHttpResponseEvent.getTwitterException();
            Object localObject1;
            int i;
            if (localTwitterException != null) {
                localObject1 = localTwitterException.getRateLimitStatus();
                i = localTwitterException.getStatusCode();
            }
            while (localObject1 != null) {
                paramHttpResponseEvent = new RateLimitStatusEvent(this, (RateLimitStatus) localObject1, paramHttpResponseEvent.isAuthenticated());
                if ((i == 420) || (i == 503) || (i == 429)) {
                    localObject1 = this.rateLimitStatusListeners.iterator();
                }
                for (; ; ) {
                    if (((Iterator) localObject1).hasNext()) {
                        localObject2 = (RateLimitStatusListener) ((Iterator) localObject1).next();
                        ((RateLimitStatusListener) localObject2).onRateLimitStatus(paramHttpResponseEvent);
                        ((RateLimitStatusListener) localObject2).onRateLimitReached(paramHttpResponseEvent);
                        continue;
                        localObject1 = JSONImplFactory.createRateLimitStatusFromResponseHeader((HttpResponse) localObject2);
                        i = ((HttpResponse) localObject2).getStatusCode();
                        break;
                        localObject1 = this.rateLimitStatusListeners.iterator();
                        while (((Iterator) localObject1).hasNext()) {
                            ((RateLimitStatusListener) ((Iterator) localObject1).next()).onRateLimitStatus(paramHttpResponseEvent);
                        }
                    }
                }
            }
        }
    }

    public void invalidateOAuth2Token() {
        try {
            getOAuth2().invalidateOAuth2Token();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    void setFactory() {
        this.factory = new JSONImplFactory(this.conf);
    }

    public void setOAuth2Token(OAuth2Token paramOAuth2Token) {
        getOAuth2().setOAuth2Token(paramOAuth2Token);
    }

    public void setOAuthAccessToken(AccessToken paramAccessToken) {
        try {
            getOAuth().setOAuthAccessToken(paramAccessToken);
            return;
        } finally {
            paramAccessToken =finally;
            throw paramAccessToken;
        }
    }

    public void setOAuthConsumer(String paramString1, String paramString2) {
        if (paramString1 == null) {
            try {
                throw new NullPointerException("consumer key is null");
            } finally {
            }
        }
        if (paramString2 == null) {
            throw new NullPointerException("consumer secret is null");
        }
        Object localObject;
        if ((this.auth instanceof NullAuthorization)) {
            if (this.conf.isApplicationOnlyAuthEnabled()) {
                localObject = new OAuth2Authorization(this.conf);
                ((OAuth2Authorization) localObject).setOAuthConsumer(paramString1, paramString2);
                this.auth = ((Authorization) localObject);
            }
        }
        do {
            for (; ; ) {
                return;
                localObject = new OAuthAuthorization(this.conf);
                ((OAuthAuthorization) localObject).setOAuthConsumer(paramString1, paramString2);
                this.auth = ((Authorization) localObject);
                continue;
                if (!(this.auth instanceof BasicAuthorization)) {
                    break;
                }
                localObject = new XAuthAuthorization((BasicAuthorization) this.auth);
                ((XAuthAuthorization) localObject).setOAuthConsumer(paramString1, paramString2);
                this.auth = ((Authorization) localObject);
            }
        } while ((!(this.auth instanceof OAuthAuthorization)) && (!(this.auth instanceof OAuth2Authorization)));
        throw new IllegalStateException("consumer key/secret pair already set.");
    }

    public String toString() {
        return "TwitterBase{conf=" + this.conf + ", http=" + this.http + ", rateLimitStatusListeners=" + this.rateLimitStatusListeners + ", auth=" + this.auth + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */