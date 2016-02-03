package javassist;

final class ClassPathList {
    ClassPathList next;
    ClassPath path;

    ClassPathList(ClassPath paramClassPath, ClassPathList paramClassPathList) {
        this.next = paramClassPathList;
        this.path = paramClassPath;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassPathList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */