package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class TwitterFactory
        implements Serializable {
    static final Authorization DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = 5193900138477709155L;
    private final Configuration conf;

    /* Error */
    static {
        // Byte code:
        //   0: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
        //   3: invokestatic 42	twitter4j/auth/AuthorizationFactory:getInstance	(Ltwitter4j/conf/Configuration;)Ltwitter4j/auth/Authorization;
        //   6: putstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
        //   9: aconst_null
        //   10: astore_1
        //   11: aload_1
        //   12: astore_0
        //   13: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
        //   16: invokeinterface 50 1 0
        //   21: ifeq +12 -> 33
        //   24: ldc 52
        //   26: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   29: pop
        //   30: ldc 52
        //   32: astore_0
        //   33: aload_0
        //   34: astore_1
        //   35: aload_0
        //   36: ifnonnull +6 -> 42
        //   39: ldc 60
        //   41: astore_1
        //   42: aload_1
        //   43: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   46: iconst_2
        //   47: anewarray 54	java/lang/Class
        //   50: dup
        //   51: iconst_0
        //   52: ldc 46
        //   54: aastore
        //   55: dup
        //   56: iconst_1
        //   57: ldc 62
        //   59: aastore
        //   60: invokevirtual 66	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   63: astore_0
        //   64: aload_0
        //   65: putstatic 68	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
        //   68: getstatic 68	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
        //   71: iconst_2
        //   72: anewarray 4	java/lang/Object
        //   75: dup
        //   76: iconst_0
        //   77: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
        //   80: aastore
        //   81: dup
        //   82: iconst_1
        //   83: getstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
        //   86: aastore
        //   87: invokevirtual 74	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
        //   90: checkcast 76	twitter4j/Twitter
        //   93: putstatic 78	twitter4j/TwitterFactory:SINGLETON	Ltwitter4j/Twitter;
        //   96: return
        //   97: astore_0
        //   98: new 80	java/lang/AssertionError
        //   101: dup
        //   102: aload_0
        //   103: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   106: athrow
        //   107: astore_0
        //   108: new 80	java/lang/AssertionError
        //   111: dup
        //   112: aload_0
        //   113: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   116: athrow
        //   117: astore_0
        //   118: new 80	java/lang/AssertionError
        //   121: dup
        //   122: aload_0
        //   123: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   126: athrow
        //   127: astore_0
        //   128: new 80	java/lang/AssertionError
        //   131: dup
        //   132: aload_0
        //   133: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   136: athrow
        //   137: astore_0
        //   138: new 80	java/lang/AssertionError
        //   141: dup
        //   142: aload_0
        //   143: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   146: athrow
        //   147: astore_0
        //   148: aload_1
        //   149: astore_0
        //   150: goto -117 -> 33
        // Local variable table:
        //   start	length	slot	name	signature
        //   12	53	0	localObject1	Object
        //   97	6	0	localNoSuchMethodException	NoSuchMethodException
        //   107	6	0	localClassNotFoundException1	ClassNotFoundException
        //   117	6	0	localInstantiationException	InstantiationException
        //   127	6	0	localIllegalAccessException	IllegalAccessException
        //   137	6	0	localInvocationTargetException	InvocationTargetException
        //   147	1	0	localClassNotFoundException2	ClassNotFoundException
        //   149	1	0	localObject2	Object
        //   10	139	1	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   42	64	97	java/lang/NoSuchMethodException
        //   42	64	107	java/lang/ClassNotFoundException
        //   68	96	117	java/lang/InstantiationException
        //   68	96	127	java/lang/IllegalAccessException
        //   68	96	137	java/lang/reflect/InvocationTargetException
        //   24	30	147	java/lang/ClassNotFoundException
    }

    public TwitterFactory() {
        this(ConfigurationContext.getInstance());
    }

    public TwitterFactory(String paramString) {
        this(ConfigurationContext.getInstance(paramString));
    }

    public TwitterFactory(Configuration paramConfiguration) {
        if (paramConfiguration == null) {
            throw new NullPointerException("configuration cannot be null");
        }
        this.conf = paramConfiguration;
    }

    public static Twitter getSingleton() {
        return SINGLETON;
    }

    public Twitter getInstance() {
        return getInstance(AuthorizationFactory.getInstance(this.conf));
    }

    public Twitter getInstance(AccessToken paramAccessToken) {
        Object localObject = this.conf.getOAuthConsumerKey();
        String str = this.conf.getOAuthConsumerSecret();
        if ((localObject == null) && (str == null)) {
            throw new IllegalStateException("Consumer key and Consumer secret not supplied.");
        }
        localObject = new OAuthAuthorization(this.conf);
        ((OAuthAuthorization) localObject).setOAuthAccessToken(paramAccessToken);
        return getInstance((Authorization) localObject);
    }

    public Twitter getInstance(Authorization paramAuthorization) {
        try {
            paramAuthorization = (Twitter) TWITTER_CONSTRUCTOR.newInstance(new Object[]{this.conf, paramAuthorization});
            return paramAuthorization;
        } catch (InstantiationException paramAuthorization) {
            throw new AssertionError(paramAuthorization);
        } catch (IllegalAccessException paramAuthorization) {
            throw new AssertionError(paramAuthorization);
        } catch (InvocationTargetException paramAuthorization) {
            throw new AssertionError(paramAuthorization);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/TwitterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */