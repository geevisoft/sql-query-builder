import DeleteQueryElements.DeleteQuery;
import DeleteQueryElements.IDeleteQuery;
import InsertQueryElements.IInsertQuery;
import InsertQueryElements.InsertQuery;
import SelectQueryElements.ISelectQuery;
import SelectQueryElements.SelectQuery;
import UpdateQueryElements.IUpdateQuery;
import UpdateQueryElements.UpdateQuery;
import Utils.StringHelper;

public class SqlQueryBuilder {

	/**
	 * Select given columns. If not columns are passed, all columns will be retrieved
	 * @param columns
	 * @return
	 */
	public ISelectQuery select(String... columns){
		String columnQuery = columns.length == 0 ? "*" : StringHelper.join(", ", columns);
		String formattedQuery = String.format("SELECT %s", columnQuery);
		return new SelectQuery(formattedQuery);
	}

	/**
	 * Select distinct given columns. If not columns are passed, all columns will be retrieved
	 * @param columns
	 * @return
	 */
	public ISelectQuery selectDistinct(String... columns){
		String columnQuery = columns.length == 0 ? "*" : StringHelper.join(", ", columns);
		String formattedQuery = String.format("SELECT DISTINCT %s", columnQuery);
		return new SelectQuery(formattedQuery);
	}

	public IUpdateQuery update(String table){
		String formattedQuery = String.format("UPDATE %s", table);
		return new UpdateQuery(formattedQuery);
	}

	public IDeleteQuery delete(String table){
		String formattedQuery = String.format("DELETE FROM %s", table);
		return new DeleteQuery(formattedQuery);
	}

	public IInsertQuery insertInto(String table){
		String formattedQuery = String.format("INSERT INTO %s", table);
		return new InsertQuery(formattedQuery);
	}
}
