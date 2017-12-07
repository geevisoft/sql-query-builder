package QueryElements;

public abstract class FinishableQuery extends Query implements IFinishableQuery {

    protected FinishableQuery(String query) {
        this.previousQuery = query;
    }

    @Override
    public String query() {
        return previousQuery;
    }

}
