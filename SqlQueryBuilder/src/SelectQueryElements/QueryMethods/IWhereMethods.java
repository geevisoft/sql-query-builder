package SelectQueryElements.QueryMethods;

import SelectQueryElements.GroupQuery;

public interface IWhereMethods {

    /**
     * Filter query with given where clause
     * @param clause
     * @return
     */
    GroupQuery where(String clause);

    /**
     * Filter query with given equality as clause
     * @param column
     * @param value
     * @return
     */
    GroupQuery whereEqual(String column, String value);

    /**
     * Filter query with given equality as clause
     * @param column
     * @param value
     * @return
     */
    GroupQuery whereEqual(String column, int value);

}
