package com.huazi.generator.entity;
import  java.lang.Long;
import  java.util.Date;
import  java.lang.String;
public class SysLogEntity {
    private  String  method;
    private  String  ip;
    private  Long  id;
    private  String  params;
    private  String  operation;
    private  String  username;
    private  Date  createDate;

    public void setId(Long id){
		this.id = id;
	}
    public void setUsername(String username){
		this.username = username;
	}
    public void setOperation(String operation){
		this.operation = operation;
	}
    public void setMethod(String method){
		this.method = method;
	}
    public void setParams(String params){
		this.params = params;
	}
    public void setIp(String ip){
		this.ip = ip;
	}
    public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

    public Long getId(){
		return this.id;
	}
    public String getUsername(){
		return this.username;
	}
    public String getOperation(){
		return this.operation;
	}
    public String getMethod(){
		return this.method;
	}
    public String getParams(){
		return this.params;
	}
    public String getIp(){
		return this.ip;
	}
    public Date getCreateDate(){
		return this.createDate;
	}

}