jsx3.lang.Package.definePackage(
  "eg.service",                //the full name of the package to create
  function(service) {          //name the argument of this function

    //call this method to begin the service call (eg.service.callOPERATION();)
    service.callOPERATION = function() {
      var objService = shop.loadResource("getBrand_xml");
      objService.setOperation("OPERATION");

      //subscribe
      objService.subscribe(jsx3.net.Service.ON_SUCCESS, service.onOPERATIONSuccess);
      objService.subscribe(jsx3.net.Service.ON_ERROR, service.onOPERATIONError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, service.onOPERATIONInvalid);

      //PERFORMANCE ENHANCEMENT: uncomment the following line of code to use XSLT to convert the server response to CDF (refer to the API docs for jsx3.net.Service.compile for implementation details)
      //objService.compile();

      //call the service
      objService.doCall();
    };

    service.onOPERATIONSuccess = function(objEvent) {
      //var responseXML = objEvent.target.getInboundDocument();
      objEvent.target.getServer().alert("Success","The service call was successful.");
    };

    service.onOPERATIONError = function(objEvent) {
      var myStatus = objEvent.target.getRequest().getStatus();
      objEvent.target.getServer().alert("Error","The service call failed. The HTTP Status code is: " + myStatus);
    };

    service.onOPERATIONInvalid = function(objEvent) {
      objEvent.target.getServer().alert("Invalid","The following message node just failed validation:\n\n" + objEvent.message);
    };

  }
);

