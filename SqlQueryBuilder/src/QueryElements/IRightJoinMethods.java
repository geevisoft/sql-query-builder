package QueryElements;

public interface IRightJoinMethods {

    /**
     * Make right join with given table and clause
     * @param table
     * @param clause
     * @return
     */
    IJoinQuery rightJoin(String table, String clause);

    /**
     * Make right join with given table and default equality
     * @param table
     * @param leftId
     * @param rightId
     * @return
     */
    IJoinQuery rightJoin(String table, String leftId, String rightId);

    /**
     * Make right join with given table, default equality and other complementary clause
     * @param table
     * @param leftId
     * @param rightId
     * @param otherClauses
     * @return
     */
    IJoinQuery rightJoin(String table, String leftId, String rightId, String otherClauses);
}
