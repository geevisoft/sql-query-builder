package QueryElements;

public interface IGroupByMethods {

    /**
     * Group query by given column(s)
     * @param columns
     * @return
     */
    GroupByQuery groupBy(String... columns);

}
