package com.edhaut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.GroupMessageData;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.repository.GroupMessageDataRepo;

@Service
public class GroupMessageDataServiceImpl implements GroupMessageDataService {
	
	@Autowired
	private GroupMessageDataRepo groupMsgRepo;

	@Override
	public JsonResponse<Object> submitGroupMsg(GroupMessageData msg) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			groupMsgRepo.save(msg);
			 resp.setCode("sucess");
       	     resp.setMessage("Data saved successfully");
		}catch(Exception e) {
			 resp.setCode("failed");
	       	  resp.setMessage("Something went wrong");
		}
		
		return resp;
	}

	@Override
	public JsonResponse<List<GroupMessageData>> getAllMsg() {
		JsonResponse<List<GroupMessageData>> resp = new JsonResponse<List<GroupMessageData>>();
		try {
			 Sort sort = Sort.by(Sort.Direction.ASC, "updatedAt");
			List<GroupMessageData> listMsg = (List<GroupMessageData>) groupMsgRepo.findAll(sort) ;
			resp.setMessage("Data Fetched Successfully");
			resp.setCode("success");
	    	resp.setBody(listMsg);
		}catch(Exception e) {
			 resp.setCode("failed");
	         resp.setMessage("Test not found");
		}
		return resp;
	}

}
