package InsertQueryElements;

import QueryElements.FinishableQuery;

import java.util.ArrayList;
import java.util.List;

public class InsertQuery extends FinishableQuery {

    private final List<String> columns;
    private final List<String> values;

    public InsertQuery(String query) {
        super(query);
        this.previousQuery = query;
        this.columns = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    //<editor-fold desc="VALUE">
    public InsertQuery value(String column, String value){
        String escapedValue = String.format("'%s'", value);
        return setValue(column, escapedValue);
    }

    public InsertQuery value(String column, int value){
        return setValue(column, String.valueOf(value));
    }

    public InsertQuery value(String column, double value){
        return setValue(column, String.valueOf(value));
    }

    public InsertQuery value(String column, boolean value){
        return value(column, value ? 1 : 0);
    }

    private InsertQuery setValue(String column, String value){
        columns.add(column);
        values.add(value);
        return this;
    }
    //</editor-fold>

    @Override
    public String query() {
        String columns = String.join(", ", this.columns);
        String values = String.join(", ", this.values);
        localClause = String.format("(%s) VALUES (%s)", columns, values);
        previousQuery = formattedQuery();
        return super.query();
    }
}
