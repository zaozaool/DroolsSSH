<!DOCTYPE html PUBLIC   
    "-//W3C//DTD XHTML 1.1 Transitional//EN"  
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="global_context" value="${pageContext.request.contextPath}"/>
<c:set var="global_css_url" value="${pageContext.request.contextPath}/css"/>
<c:set var="global_js_url" value="${pageContext.request.contextPath}/js"/>
<c:set var="global_image_url" value="${pageContext.request.contextPath}/img"/>
<head>
	<title>API Tool</title>
	<link href="${global_css_url}/jsoneditor.min.css" rel="stylesheet" type="text/css">
	<link href="${global_css_url}/darktheme.css" rel="stylesheet" type="text/css">
	
	<script src="${global_js_url}/jsoneditor.min.js"></script>
	<script src="${global_js_url}/jquery-2.2.0.min.js"></script>
	<script src="${global_js_url}/filereader.js"></script>
	<script src="${global_js_url}/FileSaver.js"></script>
	<script src="${global_js_url}/jquery.form.js"></script>
	
</head>

<body>

	<form action="${global_context}/api" method="post">
		<input name="data" type="hidden">
	</form>
	
	<button id="resetBtn">Reset</button>
	<input type="file" id="openBtn" value="Open From File" /> 
	<button id="downReqBtn">Download Request As File</button>
	<button id="downRespBtn">Download Response As File</button>
	
	<table style="width: 100%; height: 700px;">
		<tr>
			<td style="width: 49%"><div id="requestJsonEditor" style="height: 100%;"></div></td>
			<td style="width: 2%">
			<div id="splitter" style="height: 100%;">
				<button id="runBtn">Run</button>			
			</div>
			</td>
			<td style="width: 49%"><div id="responseJsonEditor" style="height: 100%;"></div></td>
		</tr>
	</table>
	
</body>
<script>
	var requestJsonEditor = $('#requestJsonEditor')[0];
	var responseJsonEditor = $('#responseJsonEditor')[0];
	var requestSchema = {
		"title" : "Request",
		"type" : "object",
		"properties" : {
			"uuid" : {
				"type" : "string"
			},
			"site" : {
				"enum" : [ "usorder", "jporder", "cnorder", "mes", "usshipping", "cnshipping" ]
			},
			"action" : {
				"enum" : [ "price", "point" ]
			}
		},
		"required" : [ "uuid", "site", "action"]
	};
	var responseSchema = {
		"title" : "Response",
		"type" : "object"
	};
	var requestOptions = {
		mode : 'tree',
		modes : [ 'code', 'form', 'text', 'tree', 'view' ], 
		schema : requestSchema,
		onError : function(err) {
			alert(err.toString());
		},
		onModeChange : function(newMode, oldMode) {
			console.log('Mode switched from', oldMode, 'to', newMode);
		},
		onEditable : function(node) {
			switch (node.field) {
			case 'uuid':
				return {
					field : false,
					value : true
				};
			case 'site':
				return {
					field : false,
					value : true
				};
			case 'action':
				return {
					field : false,
					value : true
				};
			default:
				return true;
			}
		}
	};
	var responseOptions = {
		mode : 'view',
		modes : [ 'view' ],
		schema : responseSchema,
		onError : function(err) {
			alert(err.toString());
		},
		onModeChange : function(newMode, oldMode) {
			console.log('Mode switched from', oldMode, 'to', newMode);
		},
		onEditable : function(node) {
			switch (node.field) {
			case 'uuid':
				return {
					field : false,
					value : true
				};
			case 'site':
				return {
					field : false,
					value : true
				};
			case 'action':
				return {
					field : false,
					value : true
				};
			default:
				return true;
			}
		}
	};
	var requestEditor = new JSONEditor(requestJsonEditor, requestOptions);
	var responseEditor = new JSONEditor(responseJsonEditor, responseOptions);
	
	$('#resetBtn').click(function() {
		var json = {
			'uuid' : '',
			'site' : '',
			'action' : ''
		};
		requestEditor.set(json);
	});
	$('#resetBtn').trigger('click');
	
	FileReaderJS.setupInput($('#openBtn')[0], {
		readAsDefault : 'Text',
		on : {
			load : function(event, file) {
				requestEditor.setText(event.target.result);
			}
		}
	});
	
	$('#downReqBtn').click(function() {
		var blob = new Blob([ requestEditor.getText() ], {
			type : 'application/json;charset=utf-8'
		});
		saveAs(blob, 'request.json');
	});
	
	$('#downRespBtn').click(function() {
		var blob = new Blob([ responseEditor.getText() ], {
			type : 'application/json;charset=utf-8'
		});
		saveAs(blob, 'response.json');
	});
	
	$('#runBtn').click(function() {
		var form = $("form");
		form.find("[name='data']").val(requestEditor.getText());
		var options = {
			url: "${global_context}/api",
			type: "post",
			dataType: "json",
			resetForm: false,
			async: false,
			success: function(data) {
				responseEditor.set(data);				
			},
			error: function(data) {
				if (data.responseText) {
					alert(data.responseText);
				} else {
					alert("System error! Please contact system administrator for help.");
				}
			}
		};
		form.ajaxForm(options);
		form.submit();
	});
</script>
</html>
