/**
 * 
 */
//get html page
function loadPage(url, data, err_msg, target, parent) {
	var ret = null;
	$.ajax({
	    url: url
	    ,type: "get"
	    ,data: data // 전송할 데이터
	    ,dataType: "html"
	    //,beforeSend: function(jqXHR) {}, // 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
	    ,success: function(responseData) {
	    	ret = responseData;
	    	if (parent != null) {
		    	parent.html(ret);
		    	target.append(parent);
	    	} else {
	    		target.html(ret);
	    	}
	    } // 요청 완료 시
	    ,error: function(jqXHR) {
	    	err_msg = (blank_check(err_msg)?err_msg:"Error occured during to get page");
	    	alert(err_msg);
	    } // 요청 실패.
	    ,complete: function(jqXHR) {} // 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
	});
}

//get data
function getData(url, data, err_msg) {
	var ret = [];
	$.ajax({
	    url: url
	    ,async: false
	    ,type: "get"
	    ,data: data // 전송할 데이터
	    ,dataType: "json"
	    //,beforeSend: function(jqXHR) {}, // 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
	    ,success: function(responseData) {
	    	ret = responseData;
	    } // 요청 완료 시
	    ,error: function(jqXHR) {
	    	err_msg = (blank_check(err_msg)?err_msg:"Error occured during to get data");
	    	alert(err_msg);
	    	ret.push({"id":"01"});
	    } // 요청 실패.
	    ,complete: function(jqXHR) {} // 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
	});
	
	return ret;
}

//set data
function setData(url, data, err_msg) {
	var ret = [];
	$.ajax({
	    url: url
	    ,async: false
	    ,type: "post"
	    ,contentType: 'application/json'
	    ,data: JSON.stringify(data) // 전송할 데이터
	    ,dataType: "json"
	    //,beforeSend: function(jqXHR) {}, // 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
	    ,success: function(responseData) {
	    	ret = responseData;
	    } // 요청 완료 시
	    ,error: function(jqXHR) {
	    	err_msg = (blank_check(err_msg)?err_msg:"Error occured during to set data");
	    	alert(err_msg);
	    	ret.push({"result":"-1", "message":"error"});
	    } // 요청 실패.
	    ,complete: function(jqXHR) {} // 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
	});
	
	return ret;
}

//Returns true or false depending on whether there is a value or not
function blank_check(data) {
	if (data == undefined || data == null || data == "") {
		return false;
	} else {
		return true;
	}
}