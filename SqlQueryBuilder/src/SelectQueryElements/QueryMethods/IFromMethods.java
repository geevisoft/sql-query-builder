package SelectQueryElements.QueryMethods;

import SelectQueryElements.JoinQuery;

public interface IFromMethods {

    /**
     * Retrieve columns from given table
     * @param table
     * @return
     */
    JoinQuery from(String table);
}
