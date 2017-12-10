package SelectQueryElements.QueryMethods;

public interface IRightJoinMethods {

    /**
     * Make right join with given table and clause
     * @param table
     * @param clause
     * @return
     */
	IWhereMethods rightJoin(String table, String clause);

    /**
     * Make right join with given table and default equality
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @return
     */
	IWhereMethods rightJoin(String table, String oneColumn, String anotherColumn);

    /**
     * Make right join with given table, default equality and other complementary clause
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @param otherClauses
     * @return
     */
	IWhereMethods rightJoin(String table, String oneColumn, String anotherColumn, String otherClauses);
}
