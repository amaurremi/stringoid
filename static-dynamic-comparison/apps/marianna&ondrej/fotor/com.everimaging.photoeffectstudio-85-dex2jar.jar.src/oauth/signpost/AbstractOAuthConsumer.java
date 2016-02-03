package oauth.signpost;

import java.io.IOException;
import java.util.Random;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;
import oauth.signpost.signature.HmacSha1MessageSigner;
import oauth.signpost.signature.OAuthMessageSigner;
import oauth.signpost.signature.SigningStrategy;

public abstract class AbstractOAuthConsumer
        implements OAuthConsumer {
    private HttpParameters additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private OAuthMessageSigner messageSigner;
    private final Random random = new Random(System.nanoTime());
    private HttpParameters requestParameters;
    private boolean sendEmptyTokens;
    private SigningStrategy signingStrategy;
    private String token;

    public AbstractOAuthConsumer(String paramString1, String paramString2) {
        this.consumerKey = paramString1;
        this.consumerSecret = paramString2;
        setMessageSigner(new HmacSha1MessageSigner());
        setSigningStrategy(new AuthorizationHeaderSigningStrategy());
    }

    protected void collectBodyParameters(oauth.signpost.http.a parama, HttpParameters paramHttpParameters)
            throws IOException {
        String str = parama.c();
        if ((str != null) && (str.startsWith("application/x-www-form-urlencoded"))) {
            paramHttpParameters.putAll(a.a(parama.d()), true);
        }
    }

    protected void collectHeaderParameters(oauth.signpost.http.a parama, HttpParameters paramHttpParameters) {
        paramHttpParameters.putAll(a.e(parama.a("Authorization")), false);
    }

    protected void collectQueryParameters(oauth.signpost.http.a parama, HttpParameters paramHttpParameters) {
        parama = parama.b();
        int i = parama.indexOf('?');
        if (i >= 0) {
            paramHttpParameters.putAll(a.c(parama.substring(i + 1)), true);
        }
    }

    protected void completeOAuthParameters(HttpParameters paramHttpParameters) {
        if (!paramHttpParameters.containsKey("oauth_consumer_key")) {
            paramHttpParameters.put("oauth_consumer_key", this.consumerKey, true);
        }
        if (!paramHttpParameters.containsKey("oauth_signature_method")) {
            paramHttpParameters.put("oauth_signature_method", this.messageSigner.getSignatureMethod(), true);
        }
        if (!paramHttpParameters.containsKey("oauth_timestamp")) {
            paramHttpParameters.put("oauth_timestamp", generateTimestamp(), true);
        }
        if (!paramHttpParameters.containsKey("oauth_nonce")) {
            paramHttpParameters.put("oauth_nonce", generateNonce(), true);
        }
        if (!paramHttpParameters.containsKey("oauth_version")) {
            paramHttpParameters.put("oauth_version", "1.0", true);
        }
        if ((!paramHttpParameters.containsKey("oauth_token")) && (((this.token != null) && (!this.token.equals(""))) || (this.sendEmptyTokens))) {
            paramHttpParameters.put("oauth_token", this.token, true);
        }
    }

    protected String generateNonce() {
        return Long.toString(this.random.nextLong());
    }

    protected String generateTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }

    public void setMessageSigner(OAuthMessageSigner paramOAuthMessageSigner) {
        this.messageSigner = paramOAuthMessageSigner;
        paramOAuthMessageSigner.setConsumerSecret(this.consumerSecret);
    }

    public void setSigningStrategy(SigningStrategy paramSigningStrategy) {
        this.signingStrategy = paramSigningStrategy;
    }

    public void setTokenWithSecret(String paramString1, String paramString2) {
        this.token = paramString1;
        this.messageSigner.setTokenSecret(paramString2);
    }

    public oauth.signpost.http.a sign(Object paramObject)
            throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        try {
            paramObject = sign(wrap(paramObject));
            return (oauth.signpost.http.a) paramObject;
        } finally {
            paramObject =finally;
            throw ((Throwable) paramObject);
        }
    }

    public oauth.signpost.http.a sign(oauth.signpost.http.a parama)
            throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        try {
            if (this.consumerKey == null) {
                throw new OAuthExpectationFailedException("consumer key not set");
            }
        } finally {
        }
        if (this.consumerSecret == null) {
            throw new OAuthExpectationFailedException("consumer secret not set");
        }
        this.requestParameters = new HttpParameters();
        try {
            if (this.additionalParameters != null) {
                this.requestParameters.putAll(this.additionalParameters, false);
            }
            collectHeaderParameters(parama, this.requestParameters);
            collectQueryParameters(parama, this.requestParameters);
            collectBodyParameters(parama, this.requestParameters);
            completeOAuthParameters(this.requestParameters);
            this.requestParameters.remove("oauth_signature");
            String str = this.messageSigner.sign(parama, this.requestParameters);
            a.a("signature", str);
            this.signingStrategy.writeSignature(str, parama, this.requestParameters);
            a.a("Request URL", parama.b());
            return parama;
        } catch (IOException parama) {
            throw new OAuthCommunicationException(parama);
        }
    }

    protected abstract oauth.signpost.http.a wrap(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/AbstractOAuthConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */