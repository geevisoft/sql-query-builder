package SelectQueryElements;

public interface IWhereMethods {

    /**
     * Filter query with given where clause
     * @param clause
     * @return
     */
    WhereQuery where(String clause);

    /**
     * Filter query with given equality as clause
     * @param left
     * @param right
     * @return
     */
    WhereQuery whereEqual(String left, String right);

    /**
     * Filter query with given equality as clause
     * @param left
     * @param right
     * @return
     */
    WhereQuery whereEqual(String left, int right);

}
