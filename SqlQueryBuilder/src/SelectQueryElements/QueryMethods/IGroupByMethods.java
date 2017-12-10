package SelectQueryElements.QueryMethods;

import SelectQueryElements.OrderQuery;

public interface IGroupByMethods {

    /**
     * Group query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    OrderQuery groupBy(String firstColumn, String... otherColumns);

}
