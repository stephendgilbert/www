
/**
 * @author Bertan Aygun
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DebugLab {

	public static void debug(Useless u, int[] a) {
		a[0] = 5;
		u.a = a[0];
	}
	public static void main(String[] args) {
		int[] a = new int[5];
		Useless u = new Useless(6);
		debug(u,a);
	}
}

class Useless {
	int a;

	public Useless(int a) {
		this.a = a;
	}
}
