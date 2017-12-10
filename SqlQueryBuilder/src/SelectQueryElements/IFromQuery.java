package SelectQueryElements;

import SelectQueryElements.QueryMethods.IGroupByMethods;
import SelectQueryElements.QueryMethods.IJoinMethods;
import SelectQueryElements.QueryMethods.IOrderByMethods;
import SelectQueryElements.QueryMethods.IWhereMethods;

public interface IFromQuery extends
        IWhereMethods,
        IJoinMethods,
        IOrderByMethods,
        IGroupByMethods {
}
