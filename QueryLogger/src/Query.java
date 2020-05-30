import java.sql.Connection;
import java.sql.Statement;

import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.*;


public class Query {
	
	private static long startTime = 0, estimatedTime = 0;
	
	public static String fuseki_query(Connection conn, Statement st, String addr, String dataset, String query) {
        try (RDFConnection connRDF = RDFConnectionFactory.connect(addr + dataset)) {
        	startTime = System.nanoTime();
            QueryExecution qe=connRDF.query(query);
            ResultSet results=qe.execSelect();
            qe.close();
            estimatedTime = System.nanoTime() - startTime;
            ResultSetFormatter.out(System.out,results);
            return Logger.log(conn, st, dataset, estimatedTime);
        }
    }
}
