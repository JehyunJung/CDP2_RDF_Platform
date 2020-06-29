package jena;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.riot.*;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.tdb.TDBLoader;
import org.apache.jena.tdb.store.DatasetGraphTDB;

import utils.DatabaseConnection;

public class JenaAPI {

	public Model RDFreader(String inputFileName) throws IOException {
		// Read a RDF/XML named inputFileName
		// create an empty model
		Model model = ModelFactory.createDefaultModel();
		
		// read the RDF/XML file
		// `RDFDataMgr load*?? operations create an in-memory container (model, or dataset as appropriate); read?? operations add data into an existing model or dataset.
		RDFDataMgr.read(model, inputFileName, Lang.RDFXML);
		
		// return model
		return model;
	}
	public static boolean addData(String inputFilePath,String datasetName) {
		String data_location;
		String ip=DatabaseConnection.getIP();
		String port=DatabaseConnection.getPort();
		try (RDFConnection conn=RDFConnectionFactory.connect("http://"+ip+":3030/"+datasetName)){
			Model model=ModelFactory.createDefaultModel();
			RDFDataMgr.read(model, inputFilePath);
			conn.load(model);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
}

