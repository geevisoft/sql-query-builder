package QueryElements;

public interface ILeftJoinMethods {

    /**
     * Make left join with given table and clause
     * @param table
     * @param clause
     * @return
     */
    LeftJoinQuery leftJoin(String table, String clause);

    /**
     * Make left joiun with given table and default equality
     * @param table
     * @param leftId
     * @param rightId
     * @return
     */
    LeftJoinQuery leftJoin(String table, String leftId, String rightId);

    /**
     * Make left joiun with given table, default equality and other complementary clause
     * @param table
     * @param leftId
     * @param rightId
     * @param otherClauses
     * @return
     */
    LeftJoinQuery leftJoin(String table, String leftId, String rightId, String otherClauses);

}
