package Utils;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringHelper {

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

    public static String join(String delimiter, Collection<String> collection){
        return Joiner.on(delimiter).join(collection);
    }
}
