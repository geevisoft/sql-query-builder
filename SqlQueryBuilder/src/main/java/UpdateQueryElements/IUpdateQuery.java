package UpdateQueryElements;

public interface IUpdateQuery extends IWhereQuery {

	IUpdateQuery set(String column, String value);

	IUpdateQuery set(String column, int value);

	IUpdateQuery set(String column, double value);

	IUpdateQuery set(String column, boolean value);

}
