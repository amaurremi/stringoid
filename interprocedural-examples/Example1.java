// Prototype of a URL construction observed in Beyondpod.
// This would be solved by having flows between argument-params, and return values-call site.
class M {
	public static String prefix() {
		return "http://example.com";
	}
}

class N {
	public String buildURL(String path) {
		return M.prefix() + path;
	}
}

class Example1 {
	public static void main(String args[]) {
		System.out.println(new N().buildURL("/getgoodies"));
	}
}
