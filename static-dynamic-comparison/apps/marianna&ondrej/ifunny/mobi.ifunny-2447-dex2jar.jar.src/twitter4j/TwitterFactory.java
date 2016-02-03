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
    static final Authorization DEFAULT_AUTHORIZATION;
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = -563983536986910054L;
    private final Configuration conf;

    /* Error */
    static {
        // Byte code:
        //   0: iconst_0
        //   1: istore_0
        //   2: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
        //   5: invokestatic 42	twitter4j/auth/AuthorizationFactory:getInstance	(Ltwitter4j/conf/Configuration;)Ltwitter4j/auth/Authorization;
        //   8: putstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
        //   11: ldc 46
        //   13: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   16: pop
        //   17: iconst_1
        //   18: istore_0
        //   19: aconst_null
        //   20: astore_2
        //   21: aload_2
        //   22: astore_1
        //   23: iload_0
        //   24: ifeq +12 -> 36
        //   27: ldc 54
        //   29: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   32: pop
        //   33: ldc 54
        //   35: astore_1
        //   36: aload_1
        //   37: astore_2
        //   38: aload_1
        //   39: ifnonnull +6 -> 45
        //   42: ldc 56
        //   44: astore_2
        //   45: aload_2
        //   46: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
        //   49: iconst_2
        //   50: anewarray 48	java/lang/Class
        //   53: dup
        //   54: iconst_0
        //   55: ldc 58
        //   57: aastore
        //   58: dup
        //   59: iconst_1
        //   60: ldc 60
        //   62: aastore
        //   63: invokevirtual 64	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   66: astore_1
        //   67: aload_1
        //   68: putstatic 66	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
        //   71: getstatic 66	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
        //   74: iconst_2
        //   75: anewarray 4	java/lang/Object
        //   78: dup
        //   79: iconst_0
        //   80: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
        //   83: aastore
        //   84: dup
        //   85: iconst_1
        //   86: getstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
        //   89: aastore
        //   90: invokevirtual 72	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
        //   93: checkcast 74	twitter4j/Twitter
        //   96: putstatic 76	twitter4j/TwitterFactory:SINGLETON	Ltwitter4j/Twitter;
        //   99: return
        //   100: astore_1
        //   101: new 78	java/lang/AssertionError
        //   104: dup
        //   105: aload_1
        //   106: invokespecial 82	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   109: athrow
        //   110: astore_1
        //   111: new 78	java/lang/AssertionError
        //   114: dup
        //   115: aload_1
        //   116: invokespecial 82	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   119: athrow
        //   120: astore_1
        //   121: new 78	java/lang/AssertionError
        //   124: dup
        //   125: aload_1
        //   126: invokespecial 82	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   129: athrow
        //   130: astore_1
        //   131: new 78	java/lang/AssertionError
        //   134: dup
        //   135: aload_1
        //   136: invokespecial 82	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   139: athrow
        //   140: astore_1
        //   141: new 78	java/lang/AssertionError
        //   144: dup
        //   145: aload_1
        //   146: invokespecial 82	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   149: athrow
        //   150: astore_1
        //   151: aload_2
        //   152: astore_1
        //   153: goto -117 -> 36
        //   156: astore_1
        //   157: goto -138 -> 19
        // Local variable table:
        //   start	length	slot	name	signature
        //   1	23	0	i	int
        //   22	46	1	localObject1	Object
        //   100	6	1	localNoSuchMethodException	NoSuchMethodException
        //   110	6	1	localClassNotFoundException1	ClassNotFoundException
        //   120	6	1	localInstantiationException	InstantiationException
        //   130	6	1	localIllegalAccessException	IllegalAccessException
        //   140	6	1	localInvocationTargetException	InvocationTargetException
        //   150	1	1	localClassNotFoundException2	ClassNotFoundException
        //   152	1	1	localObject2	Object
        //   156	1	1	localClassNotFoundException3	ClassNotFoundException
        //   20	132	2	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   45	67	100	java/lang/NoSuchMethodException
        //   45	67	110	java/lang/ClassNotFoundException
        //   71	99	120	java/lang/InstantiationException
        //   71	99	130	java/lang/IllegalAccessException
        //   71	99	140	java/lang/reflect/InvocationTargetException
        //   27	33	150	java/lang/ClassNotFoundException
        //   11	17	156	java/lang/ClassNotFoundException
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */