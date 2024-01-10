package com.example.christmastoys.toy.model.converter;

import com.example.christmastoys.toy.event.ToyCreatedEvent;
import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructConverter {
    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

    Toy toyCreatedEventToToy(ToyCreatedEvent event);

    ToyDTO toyToDTO(Toy toy);
}
