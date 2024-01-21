package com.example.christmastoys.model.converter;

import com.example.christmastoys.client.request.CreateToyRequest;
import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.model.Toy;
import com.example.christmastoys.model.ToyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructConverter {
    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

    Toy toyCreatedEventToToy(ToyCreatedEvent event);

    ToyDTO toyToDTO(Toy toy);

    CreateToyRequest toyDTOtoCreateToyRequest(ToyDTO toyDTO);
}
