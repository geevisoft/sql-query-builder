import DeleteQueryElements.DeleteQuery;
import InsertQueryElements.InsertQuery;
import SelectQueryElements.SelectQuery;
import UpdateQueryElements.UpdateQuery;

public class SqlQueryBuilder {

    /**
     * Select given columns. If not columns are passed, all columns will be retrieved
     * @param columns
     * @return
     */
    public SelectQuery select(String... columns){
        String columnQuery = columns.length == 0 ? "*" : String.join(", ", columns);
        String formattedQuery = String.format("SELECT %s", columnQuery);
        return new SelectQuery(formattedQuery);
    }

    /**
     * Select distinct given columns. If not columns are passed, all columns will be retrieved
     * @param columns
     * @return
     */
    public SelectQuery selectDistinct(String... columns){
        String columnQuery = columns.length == 0 ? "*" : String.join(", ", columns);
        String formattedQuery = String.format("SELECT DISTINCT %s", columnQuery);
        return new SelectQuery(formattedQuery);
    }

    public UpdateQuery update(String table){
        String formattedQuery = String.format("UPDATE %s", table);
        return new UpdateQuery(formattedQuery);
    }

    public DeleteQuery delete(String table){
        String formattedQuery = String.format("DELETE FROM %s", table);
        return new DeleteQuery(formattedQuery);
    }

    public InsertQuery insertInto(String table){
        String formattedQuery = String.format("INSERT INTO %s", table);
        return new InsertQuery(formattedQuery);
    }
}
