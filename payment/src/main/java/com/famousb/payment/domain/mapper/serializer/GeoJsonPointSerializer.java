package com.famousb.payment.domain.mapper.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.IOException;

public class GeoJsonPointSerializer extends JsonSerializer<GeoJsonPoint> {
    @Override
    public void serialize(GeoJsonPoint geoJsonPoint, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", geoJsonPoint.getType());
        jsonGenerator.writeArrayFieldStart("coordinates");
        jsonGenerator.writeObject(geoJsonPoint.getCoordinates());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
