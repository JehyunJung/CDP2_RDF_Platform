package jena;
import java.io.File;
import java.io.IOException;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class JenaAPI {

	public static void main(String[] args) {
		
	}
	
	public Model RDFreader(String inputFileName) throws IOException {
		// Read a RDF/XML named inputFileName
		// create an empty model
		Model model = ModelFactory.createDefaultModel();
		
		// read the RDF/XML file
		// `RDFDataMgr ?œload*?? operations create an in-memory container (model, or dataset as appropriate); ?œread?? operations add data into an existing model or dataset.
		RDFDataMgr.read(model, inputFileName, Lang.RDFXML);
		
		// return model
		return model;
	}
}

