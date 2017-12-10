package QueryElements;

public class FinishableQuery extends Query implements IFinishableQuery {

	public FinishableQuery(String query) {
		this.previousQuery = query;
	}

	@Override
	public String query() {
		return previousQuery;
	}

}
