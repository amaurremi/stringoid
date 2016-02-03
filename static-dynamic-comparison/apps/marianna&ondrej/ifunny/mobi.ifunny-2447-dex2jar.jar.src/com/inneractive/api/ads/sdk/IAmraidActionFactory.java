package com.inneractive.api.ads.sdk;

import java.util.Map;

final class IAmraidActionFactory {
    private static IAmraidActionFactory a = new IAmraidActionFactory();

    static p a(String paramString, Map paramMap, IAmraidWebView paramIAmraidWebView) {
        IAmraidActionFactory localIAmraidActionFactory = a;
        paramString = IAmraidActionFactory.MraidJavascriptCommand.a(paramString);
        switch (IAmraidActionFactory .1.a[paramString.ordinal()])
        {
            case 16:
            default:
                return null;
            case 1:
                return new q(paramMap, paramIAmraidWebView);
            case 2:
                return new s(paramMap, paramIAmraidWebView);
            case 3:
                return new E(paramMap, paramIAmraidWebView);
            case 4:
                return new y(paramMap, paramIAmraidWebView);
            case 5:
                return new A(paramMap, paramIAmraidWebView);
            case 6:
                return new w(paramMap, paramIAmraidWebView);
            case 7:
                return new C(paramMap, paramIAmraidWebView);
            case 8:
                return new B(paramMap, paramIAmraidWebView);
            case 9:
                return new z(paramMap, paramIAmraidWebView);
            case 10:
                return new D(paramMap, paramIAmraidWebView);
            case 11:
                return new t(paramMap, paramIAmraidWebView);
            case 12:
                return new u(paramMap, paramIAmraidWebView);
            case 13:
                return new v(paramMap, paramIAmraidWebView);
            case 14:
                return new x(paramMap, paramIAmraidWebView);
        }
        return new r(paramMap, paramIAmraidWebView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidActionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */