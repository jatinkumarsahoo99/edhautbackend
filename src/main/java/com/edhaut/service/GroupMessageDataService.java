package com.edhaut.service;

import java.util.List;
import java.util.Optional;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.GroupMessageData;
import com.edhaut.mysql.entity.TestDTO;

public interface GroupMessageDataService {
	
	 JsonResponse<Object>  submitGroupMsg(GroupMessageData msg);
	 
	 JsonResponse<List<GroupMessageData>> getAllMsg();

}
