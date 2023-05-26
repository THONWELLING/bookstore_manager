package com.thonwelling.bookstoremanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookMapper {
  private static final ModelMapper mapper = new ModelMapper();

  public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destination) {
    return mapper.map(origin, destination);
  }
  public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destination) {
    List<Destination> destinationObjects = new ArrayList<Destination>();
    for (Origin o : origin) {
      destinationObjects.add(mapper.map(o, destination));
    }
    return destinationObjects;
  }
}