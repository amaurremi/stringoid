package twitter4j.auth;

import twitter4j.conf.Configuration;

public final class AuthorizationFactory {
    public static Authorization getInstance(Configuration paramConfiguration) {
        Object localObject = null;
        String str1 = paramConfiguration.getOAuthConsumerKey();
        String str2 = paramConfiguration.getOAuthConsumerSecret();
        if ((str1 != null) && (str2 != null)) {
            if (paramConfiguration.isApplicationOnlyAuthEnabled()) {
                localObject = new OAuth2Authorization(paramConfiguration);
                str1 = paramConfiguration.getOAuth2TokenType();
                paramConfiguration = paramConfiguration.getOAuth2AccessToken();
                if ((str1 != null) && (paramConfiguration != null)) {
                    ((OAuth2Authorization) localObject).setOAuth2Token(new OAuth2Token(str1, paramConfiguration));
                }
                paramConfiguration = (Configuration) localObject;
            }
        }
        for (; ; ) {
            localObject = paramConfiguration;
            if (paramConfiguration == null) {
                localObject = NullAuthorization.getInstance();
            }
            return (Authorization) localObject;
            localObject = new OAuthAuthorization(paramConfiguration);
            str1 = paramConfiguration.getOAuthAccessToken();
            paramConfiguration = paramConfiguration.getOAuthAccessTokenSecret();
            if ((str1 != null) && (paramConfiguration != null)) {
                ((OAuthAuthorization) localObject).setOAuthAccessToken(new AccessToken(str1, paramConfiguration));
            }
            paramConfiguration = (Configuration) localObject;
            continue;
            str1 = paramConfiguration.getUser();
            str2 = paramConfiguration.getPassword();
            paramConfiguration = (Configuration) localObject;
            if (str1 != null) {
                paramConfiguration = (Configuration) localObject;
                if (str2 != null) {
                    paramConfiguration = new BasicAuthorization(str1, str2);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/AuthorizationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */