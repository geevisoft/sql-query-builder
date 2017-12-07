package SelectQueryElements;

public interface IGroupByMethods {

    /**
     * Group query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    GroupByQuery groupBy(String firstColumn, String... otherColumns);

}
