package Utils;

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
}
