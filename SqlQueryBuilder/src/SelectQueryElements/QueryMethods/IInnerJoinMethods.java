package SelectQueryElements.QueryMethods;

import SelectQueryElements.IJoinQuery;

public interface IInnerJoinMethods {

    /**
     * Make inner join with given table and clause
     * @param table
     * @param clause
     * @return
     */
    IJoinQuery innerJoin(String table, String clause);

    /**
     * Make inner join with given table and default equality clause
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @return
     */
    IJoinQuery innerJoin(String table, String oneColumn, String anotherColumn);

    /**
     * Make inner join with given table, default equality clause and other complementary clause
     * @param table
     * @param oneColumn
     * @param anotherColumn
     * @param otherClauses
     * @return
     */
    IJoinQuery innerJoin(String table, String oneColumn, String anotherColumn, String otherClauses);

}