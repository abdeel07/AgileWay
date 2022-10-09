package com.stdev.AgileWay.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.stdev.AgileWay.entities.Task;
import com.stdev.AgileWay.models.requests.TaskRequest;
import com.stdev.AgileWay.models.responses.TaskResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

	TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
	
	Task taskRequestToTask(TaskRequest taskRequest);
	
	TaskResponse taskToTaskResponse(Task task);
	
	List<Task> mapListTask(List<Task> tasks);
}
