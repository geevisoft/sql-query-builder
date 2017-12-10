package SelectQueryElements;

public interface ISelectQuery {

    /**
     * Retrieve columns from given table
     * @param table
     * @return
     */
    JoinableQuery from(String table);
}
