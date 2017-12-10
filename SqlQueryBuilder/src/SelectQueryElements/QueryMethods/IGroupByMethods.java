package SelectQueryElements.QueryMethods;

import SelectQueryElements.GroupByQuery;

public interface IGroupByMethods {

    /**
     * Group query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    GroupByQuery groupBy(String firstColumn, String... otherColumns);

}
