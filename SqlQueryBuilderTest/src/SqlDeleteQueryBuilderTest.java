import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(query, writtenQuery);
	}
}
