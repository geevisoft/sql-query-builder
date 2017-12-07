package UpdateQueryElements;

public class UpdateQuery extends WhereableQuery {

    public UpdateQuery(String query) {
        super(query);
    }

    public UpdateQuery set(String column, String value){
        String escapedValue = String.format("'%s'", value);
        return setValue(column, escapedValue);
    }

    public UpdateQuery set(String column, int value){
        return setValue(column, String.valueOf(value));
    }

    public UpdateQuery set(String column, double value){
        return setValue(column, String.valueOf(value));
    }

    public UpdateQuery set(String column, boolean value){
        return set(column, value ? 1 : 0);
    }

    private UpdateQuery setValue(String column, String value){
        String set = String.format("%s=%s", column, value);
        setValues.add(set);
        return this;
    }

}
