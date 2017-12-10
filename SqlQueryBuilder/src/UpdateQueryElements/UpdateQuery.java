package UpdateQueryElements;

public class UpdateQuery extends WhereQuery implements IUpdateQuery {

	public UpdateQuery(String query) {
		super(query);
	}

	public IUpdateQuery set(String column, String value){
		String escapedValue = String.format("'%s'", value);
		return setValue(column, escapedValue);
	}

	public IUpdateQuery set(String column, int value){
		return setValue(column, String.valueOf(value));
	}

	public IUpdateQuery set(String column, double value){
		return setValue(column, String.valueOf(value));
	}

	public IUpdateQuery set(String column, boolean value){
		return set(column, value ? 1 : 0);
	}

	private UpdateQuery setValue(String column, String value){
		String set = String.format("%s=%s", column, value);
		setValues.add(set);
		return this;
	}

}
