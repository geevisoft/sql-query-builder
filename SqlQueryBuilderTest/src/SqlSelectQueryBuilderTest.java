import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(writtenQuery, query);
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
        assertEquals(writtenQuery, query);
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
        assertEquals(writtenQuery, query);
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
        assertEquals(writtenQuery, query);
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
        assertEquals(writtenQuery, query);
    }

    @Test
    void selectFromAndTwoOrders(){
        String query = builder
                .select()
                .from("Users")
                .orderBy("LastName", "FirstName")
                .query();
        String writtenQuery = "SELECT * FROM Users ORDER BY LastName, FirstName";
        assertEquals(writtenQuery, query);
    }
}
