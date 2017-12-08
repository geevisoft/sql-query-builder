package InsertQueryElements;

import QueryElements.Query;

import java.util.ArrayList;
import java.util.List;

public class InsertQuery extends Query {

    protected final List<String> columns;
    protected final List<String> values;

    public InsertQuery(String query) {
        this.previousQuery = query;
        this.columns = new ArrayList<String>();
        this.values = new ArrayList<String>();
    }

    public InsertQuery(String query, String column, String value){
        this(query);
        columns.add(column);
        values.add(value);
    }

    //<editor-fold desc="VALUE">
    public InsertRestOfValuesQuery value(String column, String value){
        String escapedValue = String.format("'%s'", value);
        return setValue(column, escapedValue);
    }

    public InsertRestOfValuesQuery value(String column, int value){
        return setValue(column, String.valueOf(value));
    }

    public InsertRestOfValuesQuery value(String column, double value){
        return setValue(column, String.valueOf(value));
    }

    public InsertRestOfValuesQuery value(String column, boolean value){
        return value(column, value ? 1 : 0);
    }

    protected InsertRestOfValuesQuery setValue(String column, String value){
        return new InsertRestOfValuesQuery(previousQuery, column, value);
    }
    //</editor-fold>

}
