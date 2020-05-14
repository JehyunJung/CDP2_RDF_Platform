import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.*;


public class Query {
	
	private static long startTime = 0, estimatedTime = 0;
	
	public static void fuseki_query(String addr, String dataset, String query) {
		//addr = "http://49.60.166.240:3030/";
        try (RDFConnection conn = RDFConnectionFactory.connect(addr + dataset)) {
        	startTime = System.nanoTime();
            QueryExecution qe=conn.query(query);
            ResultSet results=qe.execSelect();
            qe.close();
            estimatedTime = System.nanoTime() - startTime;
            ResultSetFormatter.out(System.out,results);
            Logger.log(dataset, estimatedTime);
        }
    }
}
