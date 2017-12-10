package DeleteQueryElements;

import QueryElements.IFinishableQuery;

public interface IDeleteQuery {

	IFinishableQuery where(String clause);

	IFinishableQuery whereEquals(String column, String value);

	IFinishableQuery whereEquals(String column, int value);
}
