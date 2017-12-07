package InsertQueryElements;

import QueryElements.IFinishableQuery;

public class InsertRestOfValuesQuery extends InsertQuery implements IFinishableQuery {

    public InsertRestOfValuesQuery(String query, String column, String value) {
        super(query, column, value);
    }

    @Override
    protected InsertRestOfValuesQuery setValue(String column, String value) {
        columns.add(column);
        values.add(value);
        return this;
    }

    @Override
    public String query() {
        String columns = String.join(", ", this.columns);
        String values = String.join(", ", this.values);
        localClause = String.format("(%s) VALUES (%s)", columns, values);
        return new EndQuery(formattedQuery()).query();
    }
}
