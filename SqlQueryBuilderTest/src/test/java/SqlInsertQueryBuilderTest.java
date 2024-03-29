import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SqlInsertQueryBuilderTest {

	private SqlQueryBuilder builder;

	@BeforeEach
	void setUp() {
		builder = new SqlQueryBuilder();
	}

	@Test
	void insertOneWithOneValue(){
		String query = builder
			.insertInto("Users")
			.value("FirstName", "John")
			.query();
		String writtenQuery = "INSERT INTO Users (FirstName) VALUES ('John')";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void insertOneWithThreeValue(){
		String query = builder
			.insertInto("Users")
			.value("FirstName", "John")
			.value("LastName", "Doe")
			.value("Age", 21)
			.query();
		String writtenQuery = "INSERT INTO Users (FirstName, LastName, Age) VALUES ('John', 'Doe', 21)";
		Assertions.assertEquals(writtenQuery, query);
	}
}
