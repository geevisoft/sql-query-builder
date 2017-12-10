package UpdateQueryElements;

import QueryElements.IFinishableQuery;

public interface IWhereQuery {

	IFinishableQuery where(String clause);

	IFinishableQuery whereEqual(String column, String value);

	IFinishableQuery whereEqual(String column, int value);
}
