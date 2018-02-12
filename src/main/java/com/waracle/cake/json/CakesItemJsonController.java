package com.waracle.cake.json;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.waracle.cake.model.Cake;
import com.waracle.cake.service.api.CakeService;

import io.springlets.web.NotFoundException;

@RestController
@RequestMapping(value = "/api/cakes/{cake}",name = "CakesItemJsonController",produces = MediaType.APPLICATION_JSON_VALUE)
/**
 * = CakesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
public class CakesItemJsonController {

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    private CakeService cakeService;

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
     * TODO Auto-generated constructor documentation
     * 
     * @param cakeService
     */
    @Autowired
    public CakesItemJsonController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Cake
     */
    @ModelAttribute
    public Cake getCake(@PathVariable("cake") Long id) {
        Cake cake = cakeService.findOne(id);
        if (cake == null) {
            throw new NotFoundException(String.format("Cake with identifier '%s' not found",id));
        }
        return cake;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Cake cake) {
        return ResponseEntity.ok(cake);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     * @return UriComponents
     */
    public static UriComponents showURI(Cake cake) {
        return MvcUriComponentsBuilder
            .fromMethodCall(
                MvcUriComponentsBuilder.on(CakesItemJsonController.class).show(cake))
            .buildAndExpand(cake.getId()).encode();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param storedCake
     * @param cake
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Cake storedCake, @Valid @RequestBody Cake cake, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        cake.setId(storedCake.getId());
        getCakeService().save(cake);
        return ResponseEntity.ok().build();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Cake cake) {
        getCakeService().delete(cake);
        return ResponseEntity.ok().build();
    }
}
