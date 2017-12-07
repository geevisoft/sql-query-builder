package QueryElements;

public abstract class FinishableQuery implements IFinishableQuery {

    private final String query;

    protected FinishableQuery(String query) {
        this.query = query;
    }

    @Override
    public String query() {
        return query;
    }

}
