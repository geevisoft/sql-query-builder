import QueryElements.SelectQuery;
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

}
