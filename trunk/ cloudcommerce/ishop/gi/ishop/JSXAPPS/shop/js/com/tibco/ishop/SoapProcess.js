jsx3.Class.defineClass(
"com.tibco.ishop.SoapProcess",
jsx3.xml.Document,
null,
function(doc){
	doc.sourceSoap= new jsx3.xml.Document();
	doc.formatSoapToCDF = function(){
		var SourceXML = doc.sourceSoap;
		alert(SourceXML);
        var transformXSL = new jsx3.xml.Document().load(service.getServer().resolveURI("xsl/CDF.xsl"));
		alert(transformXSL);
        transformedDoc = SourceXML.transformNode(transformXSL);
        var newDoc = new jsx3.xml.Document().loadXML(transformedDoc); 
		alert(newDoc);
	};
});
