package SelectQueryElements;

public interface ILeftJoinMethods {

    /**
     * Make left join with given table and clause
     * @param table
     * @param clause
     * @return
     */
    IJoinQuery leftJoin(String table, String clause);

    /**
     * Make left join with given table and default equality clause
     * @param table
     * @param leftId
     * @param rightId
     * @return
     */
    IJoinQuery leftJoin(String table, String leftId, String rightId);

    /**
     * Make left join with given table, default equality clause and other complementary clause
     * @param table
     * @param leftId
     * @param rightId
     * @param otherClauses
     * @return
     */
    IJoinQuery leftJoin(String table, String leftId, String rightId, String otherClauses);

}
