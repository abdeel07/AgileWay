package com.stdev.AgileWay.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.stdev.AgileWay.entities.Event;
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.responses.EventResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

	EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
	
	Event eventRequestToEvent(EventRequest eventRequest);
	
	EventResponse eventToEventResponse(Event event);
	
	List<EventResponse> mapListEvent(List<Event> events);
}
