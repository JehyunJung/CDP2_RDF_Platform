import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.*;


public class Query {
	private static String addr="http://"+DatabaseConnection.getIP()+":"+DatabaseConnection.getfusekiPort()+"/";
	
	public static String fuseki_query(String dataset, String query) {
		long estimatedTime=0;
		Date date=new Date(System.currentTimeMillis());
        try (RDFConnection connRDF = RDFConnectionFactory.connect(addr + dataset)) {
        	long startTime = System.nanoTime();
            QueryExecution qe=connRDF.query(query);
            ResultSet results=qe.execSelect();
            estimatedTime = System.nanoTime() - startTime;
            //ResultSetFormatter.out(System.out,results);
            qe.close();
            return dataset + "," + date + "," + Long.toString(estimatedTime);
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return null;
        }
    }
}