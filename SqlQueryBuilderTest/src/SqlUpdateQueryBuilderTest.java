import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlUpdateQueryBuilderTest {

	private SqlQueryBuilder builder;

	@BeforeEach
	void setUp() {
		builder = new SqlQueryBuilder();
	}

	@Test
	void updateOneColumn(){
		String query = builder
			.update("Users")
			.set("FirstName", "John")
			.whereEqual("ID", 1)
			.query();
		String writtenQuery = "UPDATE Users SET FirstName='John' WHERE ID=1";
		assertEquals(writtenQuery, query);
	}

	@Test
	void updateTwoColumns(){
		String query = builder
			.update("Users")
			.set("FirstName", "John")
			.set("Age", 21)
			.whereEqual("ID", 1)
			.query();
		String writtenQuery = "UPDATE Users SET FirstName='John', Age=21 WHERE ID=1";
		assertEquals(writtenQuery, query);
	}
}
