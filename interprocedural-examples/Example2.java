// Prototype of a URL construction observed in Beyondpod.
// This could be handled by adding flows between GETs and PUTs on fields.
class Example2 {
	private String prefix;

	public Example2(String prefix) {
		this.prefix = prefix;
	}

	public static void main(String args[]) {
		Example2 c =  new Example2("http://example.com");

		String url = c.prefix + "/getgoodies";

		System.out.println(url);
	}
}
