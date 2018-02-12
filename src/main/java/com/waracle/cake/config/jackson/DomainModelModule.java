package com.waracle.cake.config.jackson;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.waracle.cake.json.CakeJsonMixin;
import com.waracle.cake.model.Cake;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
public class DomainModelModule extends SimpleModule {

	/**
     * TODO Auto-generated constructor documentation
     * 
     */
    public DomainModelModule() {
        // Mixin registration
        
        setMixInAnnotation(Cake.class, CakeJsonMixin.class);
    }
}
