package com.genscript.rule.price.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.genscript.rule.price.TestService;
import com.opensymphony.xwork2.ActionSupport;


@Results({ @Result(name = "test", location = "test/test.jsp") })
public class TestAction extends ActionSupport  {

	private static final long serialVersionUID = -3892711448015758917L;
	
	@Autowired
	private TestService testService;

	private String ruleParam;

	/**
	 * Drools 测试方法
	 * @return
	 */
	public String test() {

		String resultStr = testService.testDrools(ruleParam);
		HttpServletRequest  request = ServletActionContext.getRequest(); 
		request.setAttribute("ruleResutl", resultStr);
		
		return "test";
	}

	public String getRuleParam() {
		return ruleParam;
	}

	public void setRuleParam(String ruleParam) {
		this.ruleParam = ruleParam;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
