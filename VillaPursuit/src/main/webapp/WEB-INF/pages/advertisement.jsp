<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>Post Advertisement</title>
    <link rel="stylesheet" type="text/css" href="styles/signup.css">
</head>

<body>
<div class="body"></div>
    
        <div class="header">
            <div>Villa<span>Pursuit</span></div>
        </div>
        <br>
<div class="message">
    <div>Enter<span>Villa</span>Details</div>
</div>
<div class="col-sm-7" style="position: absolute; top: calc(32% - 35px); left: calc(42% - 255px); z-index: 3; background-color: #000; opacity:0.8;">

    <form:form commandName="advertisementForm" method="post" action="addAdvertisement" id="signupForm" enctype="multipart/form-data"
                   style="padding: 5px; background-color: #000; opacity:0.8; border-color: #000">
        
        <div class="form-group"style="padding: 10px;">
            <label styleClass="control-label" style="font-size: 26px;">Title*</label>
            <form:input cssClass="form-control" path="title" style="font-size: 32px; height: 100px;"/>
            <form:errors path="title"></form:errors>
        </div>
        <div class="form-group"style="padding: 10px;">
            <label styleClass="control-label" style="font-size: 18px;">Upload Image</label>
            <input type="file" name="file" id="file"/>
        </div>
        <label styleClass="control-label" style="font-size: 24px;">Specifications*</label>
        <div class="row" style="padding: 10px;">
        <div class="col-sm-6 form-group">
            <form:input type="hidden" path="status" value="active"/>
            <form:input cssClass="form-control" path="availability" placeholder="Availability" />
            <form:errors path="availability"></form:errors>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="price" placeholder="Price"/>
            <form:errors path="price"></form:errors>
        </div>
        <div class="col-sm-6 form-group">
            <form:select cssClass="form-control" path="houseType" style="width: 200px; float:right;">
                <form:option value="None" label="---Select House Type---" />
                <form:option value="Individual" label="Individual" />
                <form:option value="Appartment" label="Appartment" />
            </form:select>
            <form:errors path="houseType"></form:errors>
            <form:select cssClass="form-control" path="rentType" style="width: 200px; float:right;">
                    <form:option value="None" label="---Select Rent Type---" />
                    <form:option value="Rent" label="Rent" />
                    <form:option value="Lease" label="Lease" />
            </form:select>
            <form:errors path="rentType"></form:errors>
        </div>
        </div>
        <div class="row" style="background: #000; opacity: 0.6; height: 20px;"></div>
        <label styleClass="control-label" style="font-size: 24px;">Facilities</label>
        <div class="row" style="padding: 10px;">
        <div class="col-sm-6 form-group">
            <form:select cssClass="form-control" path="facility.bedroom">
                <form:option value="NONE" label="--- Bedroom ---"/>
                <form:option value="1BHK" label="--- 1BHK ---" />
                <form:option value="2BHK" label="--- 2BHK ---" />
                <form:option value="3BHK" label="--- 3BHK ---" />
            </form:select>
            <form:errors path="facility.bedroom"></form:errors>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="facility.areaSize" placeholder="Area Size"/><br>
            <form:errors path="facility.areaSize"></form:errors>
        </div>
        <div class="col-sm-6 form-group" style="font-size: 20px;">
            <form:checkbox path="facility.parking"/>Parking &nbsp;
            <form:checkbox path="facility.drainage"/>Drainage &nbsp;
            <form:checkbox path="facility.transport"/>Transport
        </div>
        </div>
        <div class="row" style="background: #000; opacity: 0.6; height: 20px;"></div>
        <label styleClass="control-label" style="font-size: 24px;">Address Details</label>
        <div class="form-group" style="padding: 10px;">
            <form:input cssClass="form-control" path="address.address" id="address.address" placeholder="No/Street"/>
        </div>
        <div class="row" style="padding: 10px;">
        <div class="col-sm-6 form-group">
            <form:input cssClass="form-control" path="address.area" id="address.area" placeholder="Area"/>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="address.city" id="address.city" placeholder="City"/>
       </div>
       <div class="col-sm-6 form-group">     
            <form:input cssClass="form-control" path="address.state" id="address.state" placeholder="State"/>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="address.pincode" id="address.pincode" placeholder="Pincode"/>
       </div>
       <div class="col-sm-6 form-group">
            <form:input cssClass="form-control" path="address.landMark" id="address.landMark" placeholder="Landmark"/>
        </div>
       </div>
        <div class="form-group" style="float: right">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white">Post Ad
            </button>
            <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>
