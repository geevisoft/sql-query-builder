package SelectQueryElements;

import SelectQueryElements.JoinMethods.IInnerJoinMethods;
import SelectQueryElements.JoinMethods.ILeftJoinMethods;
import SelectQueryElements.JoinMethods.IRightJoinMethods;

public interface IJoinQuery extends
	IInnerJoinMethods,
	ILeftJoinMethods,
	IRightJoinMethods,
	IWhereQuery {

}
