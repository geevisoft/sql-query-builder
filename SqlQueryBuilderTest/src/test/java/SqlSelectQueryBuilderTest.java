import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SqlSelectQueryBuilderTest {

	private SqlQueryBuilder builder;

	@BeforeEach
	void setUp() {
		builder = new SqlQueryBuilder();
	}

	@Test
	void simpleSelect(){
		String query = builder
			.select("FirstName", "LastName")
			.from("Users")
			.query();
		String writtenQuery = "SELECT FirstName, LastName FROM Users";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void emptySelect(){
		String query = builder
			.select()
			.from("Users")
			.query();
		String writtenQuery = "SELECT * FROM Users";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithWhereClause(){
		String query = builder
			.select()
			.from("Users")
			.where("LastName = 'Doe'")
			.query();
		String writtenQuery = "SELECT * FROM Users WHERE LastName = 'Doe'";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithAlias(){
		String query = builder
			.select("u.FirstName")
			.from("Users", "u")
			.query();
		String writtenQuery = "SELECT u.FirstName FROM Users u";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithOrderByClause(){
		String query = builder
			.select()
			.from("Users")
			.orderBy("LastName")
			.query();
		String writtenQuery = "SELECT * FROM Users ORDER BY LastName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithWhereInnerJoinAndOrderBy(){
		String query = builder
			.select()
			.from("Users")
			.innerJoin("Clients", "ClientID", "ID")
			.whereEqual("LastName", "Doe")
			.orderBy("FirstName")
			.query();
		String writtenQuery = "SELECT * FROM Users INNER JOIN Clients ON ClientID=ID WHERE LastName='Doe' ORDER BY FirstName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithWhereInnerJoinAndGroupBy(){
		String query = builder
			.select()
			.from("Users")
			.innerJoin("Clients", "ClientID", "ID")
			.whereEqual("LastName", "Doe")
			.groupBy("FirstName")
			.query();
		String writtenQuery = "SELECT * FROM Users INNER JOIN Clients ON ClientID=ID WHERE LastName='Doe' GROUP BY FirstName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithInnerJoinAndGroupBy(){
		String query = builder
			.select()
			.from("Users")
			.innerJoin("Clients", "ClientID", "ID")
			.groupBy("FirstName")
			.query();
		String writtenQuery = "SELECT * FROM Users INNER JOIN Clients ON ClientID=ID GROUP BY FirstName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithInnerJoinGroupByAndOrderBy(){
		String query = builder
			.select()
			.from("Users")
			.innerJoin("Clients", "ClientID", "ID")
			.groupBy("FirstName")
			.orderBy("LastName")
			.query();
		String writtenQuery = "SELECT * FROM Users INNER JOIN Clients ON ClientID=ID GROUP BY FirstName ORDER BY LastName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void innerJoinAndInnerJoin(){
		String query = builder
			.select()
			.from("Users")
			.innerJoin("Clients", "ClientID", "ID")
			.innerJoin("Tickets", "UserID", "ID")
			.query();
		String writtenQuery = "SELECT * FROM Users INNER JOIN Clients ON ClientID=ID INNER JOIN Tickets ON UserID=ID";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectFromAndTwoOrders(){
		String query = builder
			.select()
			.from("Users")
			.orderBy("LastName", "FirstName")
			.query();
		String writtenQuery = "SELECT * FROM Users ORDER BY LastName, FirstName";
		Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithJoinsAndAlias(){
	    String query = builder
			.select("u.ID", "c.ID", "t.ID")
			.from("Users", "u")
			.innerJoinAs("Clients", "c", "c.ID=u.ClientID")
			.leftJoinAs("Tickets", "t", "t.UserID=u.ID")
			.query();
	    String writtenQuery = "SELECT u.ID, c.ID, t.ID FROM Users u INNER JOIN Clients c ON c.ID=u.ClientID LEFT JOIN Tickets t ON t.UserID=u.ID";
	    Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithWhereIn(){
	    String query = builder
			.select()
			.from("Users")
			.whereIn("Username", "jack", "joe")
			.query();
	    String writtenQuery = "SELECT * FROM Users WHERE Username IN ('jack', 'joe')";
	    Assertions.assertEquals(writtenQuery, query);
	}

	@Test
	void selectWithAListForWhereIn(){
		int[] validYears = new int[]{5, 7, 8, 25};
	    String query = builder
			.select()
			.from("Users")
			.whereIn("Age", validYears)
			.query();
	    String writtenQuery = "SELECT * FROM Users WHERE Age IN (5, 7, 8, 25)";
	    Assertions.assertEquals(writtenQuery, query);
	}
}
