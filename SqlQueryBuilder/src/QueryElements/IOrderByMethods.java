package QueryElements;

public interface IOrderByMethods {

    /**
     * Order query by given column(s)
     * @param columns
     * @return
     */
    OrderByQuery orderBy(String... columns);

    /**
     * Order query descending by given column(s)
     * @param columns
     * @return
     */
    OrderByQuery orderByDescending(String... columns);

}
