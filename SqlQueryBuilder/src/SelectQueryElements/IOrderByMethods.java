package SelectQueryElements;

public interface IOrderByMethods {

    /**
     * Order query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    OrderByQuery orderBy(String firstColumn, String... otherColumns);

    /**
     * Order query descending by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    OrderByQuery orderByDescending(String firstColumn, String... otherColumns);

}
