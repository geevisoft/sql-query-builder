package InsertQueryElements;

import QueryElements.IFinishableQuery;
import Utils.StringHelper;

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
        String columns = StringHelper.join(", ", this.columns);
        String values = StringHelper.join(", ", this.values);
        localClause = String.format("(%s) VALUES (%s)", columns, values);
        return new EndQuery(formattedQuery()).query();
    }
}