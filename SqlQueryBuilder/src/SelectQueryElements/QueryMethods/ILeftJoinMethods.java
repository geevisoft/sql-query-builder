package SelectQueryElements.QueryMethods;

public interface ILeftJoinMethods {

    /**
     * Make left join with given table and clause
     * @param table
     * @param clause
     * @return
     */
	IWhereMethods leftJoin(String table, String clause);

    /**
     * Make left join with given table and default equality clause
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @return
     */
	IWhereMethods leftJoin(String table, String oneColumn, String anotherColumn);

    /**
     * Make left join with given table, default equality clause and other complementary clause
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @param otherClauses
     * @return
     */
	IWhereMethods leftJoin(String table, String oneColumn, String anotherColumn, String otherClauses);

}
