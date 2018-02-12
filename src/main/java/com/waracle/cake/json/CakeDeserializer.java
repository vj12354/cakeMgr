package com.waracle.cake.json;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.waracle.cake.model.Cake;
import com.waracle.cake.service.api.CakeService;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;

@JsonComponent
/**
 * = CakeDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
public class CakeDeserializer extends JsonObjectDeserializer<Cake> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CakeService cakeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param cakeService
     * @param conversionService
     */
    @Autowired
    public CakeDeserializer(@Lazy CakeService cakeService, ConversionService conversionService) {
        this.cakeService = cakeService;
        this.conversionService = conversionService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return CakeService
     */
    public CakeService getCakeService() {
        return cakeService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cakeService
     */
    public void setCakeService(CakeService cakeService) {
        this.cakeService = cakeService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Cake
     * @throws IOException
     */
    public Cake deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Cake cake = cakeService.findOne(id);
        if (cake == null) {
            throw new NotFoundException("Cake not found");
        }
        return cake;
    }
}
