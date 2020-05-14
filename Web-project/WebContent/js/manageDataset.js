$(document).ready(function(){
	var datasetExists;
	var datasetName;
	var datasetType;
	
	$('.add_btn').click(function(){
		jQuery.support.cors = true;
		deleteDataset("Dbpedia6");
		/*
		a_tag=$(this)[0];
		datasetExists=a_tag.getAttribute("datasetExists");
		datasetName=a_tag.getAttribute("datasetName");
		datasetType=a_tag.getAttribute("datasetType");
		
		if(datasetExists == "False")
			createDataset(datasetName,datasetType);
		else{
			deleteDataset(datasetName);
			createDataset(datasetName,datasetType);
		}
		*/
	});
	
	function createDataset(datasetName,datasetType){
		$.ajax({
			type:"POST",
			url:" http://49.50.166.240:3030/$/datasets",
			contentType:"application/x-www-form-urlencoded",	//Content-Type 설정
			dataType:"json",
			data:{				
				"dbName":datasetName,
				"dbType":datasetType
			}
		});
	};
	
	function deleteDataset(datasetName){
		
		$.ajax({
			method:"DELETE",
			url:"http://49.50.166.240:3030/$/datasets/"+datasetName,
			dataType : "jsonp",
			header:{
				"User-Agent":"PostmanRuntime/7.24.1"
			},
			contentType:"application/x-www-form-urlencoded"
		});
		
		fetch("http://49.50.166.240:3030/$/datasets/"+datasetName,{
			method:'DELETE',}).then(res=>res.text());
		axios.delete("http://49.50.166.240:3030/$/datasets/"+datasetName) .then(res => { console.log(res.data) })

	}
	
	
});
