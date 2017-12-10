package SelectQueryElements.QueryMethods;

import SelectQueryElements.EndQuery;

public interface IWhereMethods {

    /**
     * Filter query with given where clause
     * @param clause
     * @return
     */
    EndQuery where(String clause);

    /**
     * Filter query with given equality as clause
     * @param column
     * @param value
     * @return
     */
    EndQuery whereEqual(String column, String value);

    /**
     * Filter query with given equality as clause
     * @param column
     * @param value
     * @return
     */
    EndQuery whereEqual(String column, int value);

}
