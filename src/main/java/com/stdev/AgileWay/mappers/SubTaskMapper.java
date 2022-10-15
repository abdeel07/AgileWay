package com.stdev.AgileWay.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.stdev.AgileWay.entities.SubTask;
import com.stdev.AgileWay.models.requests.SubTaskRequest;
import com.stdev.AgileWay.models.responses.SubTaskResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubTaskMapper {

	SubTaskMapper INSTANCE = Mappers.getMapper(SubTaskMapper.class);
	
	SubTask subTaskRequestToSubTask(SubTaskRequest request);
	
	SubTaskResponse subTaskToSubTaskResponse(SubTask subTask);
	
	List<SubTaskResponse> mapSubTask(List<SubTask> subTasks);
}
