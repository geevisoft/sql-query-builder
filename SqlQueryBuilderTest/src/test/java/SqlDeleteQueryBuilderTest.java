import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SqlDeleteQueryBuilderTest {

	private SqlQueryBuilder builder;

	@BeforeEach
	void setUp() {
		builder = new SqlQueryBuilder();
	}

	@Test
	void deleteWithWhere(){
		String query = builder
			.delete("Users")
			.whereEquals("ID", 1)
			.query();
		String writtenQuery = "DELETE FROM Users WHERE ID=1";
		Assertions.assertEquals(query, writtenQuery);
	}
}
