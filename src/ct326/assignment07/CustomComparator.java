/**
 * @Student_ID 07013418
 * @Author Luke Potter
 * @Course 3rd B.Sc. I.T.
 * @Date 06/November/2009
 */

package ct326.assignment07;

import java.util.Comparator;

public class CustomComparator implements Comparator<Rational> {

	public int compare(Rational r1, Rational r2) {

		return r1.compareTo(r2);
	}
}
