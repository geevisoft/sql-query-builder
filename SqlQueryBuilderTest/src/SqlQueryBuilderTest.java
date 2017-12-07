import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SqlQueryBuilderTest {

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
        assertEquals(writtenQuery, query);
    }

    @Test
    void emptySelect(){
        String query = builder
                .select()
                .from("Users")
                .query();
        String writtenQuery = "SELECT * FROM Users";
        assertEquals(writtenQuery, query);
    }

    @Test
    void selectWithWhereClause(){
        String query = builder
                .select()
                .from("Users")
                .where("LastName = 'Doe'")
                .query();
        String writtenQuery = "SELECT * FROM Users WHERE LastName = 'Doe'";
        assertEquals(writtenQuery, query);
    }

    @Test
    void selectWithOrderByClause(){
        String query = builder
                .select()
                .from("Users")
                .orderBy("LastName")
                .query();
        String writtenQuery = "SELECT * FROM Users ORDER BY LastName";
        assertEquals(writtenQuery, query);
    }




}
