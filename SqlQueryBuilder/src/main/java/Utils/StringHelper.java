package Utils;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringHelper {

	private StringHelper() { }
	/**
	 * Returns whether given value is null or empty
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value){
		return value == null || value.equalsIgnoreCase(StringHelper.EMPTY);
	}

	public static final String EMPTY = "";

	public static String join(String delimiter, String[] list){
		Collection<String> collection = new ArrayList<String>(Arrays.asList(list));
		return join(delimiter, collection);
	}

	public static String joinAndQuote(String delimiter, String[] list){
		List<String> collection = new ArrayList<String>(Arrays.asList(list));
		Collection<String> quotedCollection = Lists.transform(collection, addQuotes);
		return join(delimiter, quotedCollection);
	}

	public static String join(String delimiter, int[] list){
		List<Integer> collection = new ArrayList<Integer>(Ints.asList(list));
		Collection<String> stringCollection = Lists.transform(collection, Functions.toStringFunction());
		return join(delimiter, stringCollection);
	}

	public static String join(String delimiter, double[] list){
		List<Double> collection = new ArrayList<Double>(Doubles.asList(list));
		Collection<String> stringCollection = Lists.transform(collection, Functions.toStringFunction());
		return join(delimiter, stringCollection);
	}

	public static String join(String delimiter, Collection<String> collection){
		return Joiner.on(delimiter).join(collection);
	}

	private static final Function<String,String> addQuotes = new Function<String,String>() {
		@Override public String apply(String s) {
			return new StringBuilder(s.length()+2)
				.append('\'')
				.append(s)
				.append('\'')
				.toString();
		}
	};
}
