package com.waracle.cake.json;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.waracle.cake.model.Cake;
import com.waracle.cake.service.api.CakeService;

import io.springlets.data.domain.GlobalSearch;

@RestController
@RequestMapping(value = "/api/cakes",name = "CakesCollectionJsonController",produces = MediaType.APPLICATION_JSON_VALUE)
/**
 * = CakesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
public class CakesCollectionJsonController {

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
    public CakesCollectionJsonController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Cake>> list(GlobalSearch globalSearch, Pageable pageable) {
        
        Page<Cake> cakes = getCakeService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(cakes);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder
            .fromMethodCall(
                MvcUriComponentsBuilder.on(CakesCollectionJsonController.class).list(null, null))
            .build().encode();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Cake cake, BindingResult result) {
        
        if (cake.getId() != null || cake.getVersion() != null) {        
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        Cake newCake = getCakeService().save(cake);
        UriComponents showURI = CakesItemJsonController.showURI(newCake);
        
        return ResponseEntity.created(showURI.toUri()).build();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cakes
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Cake> cakes, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        getCakeService().save(cakes);
        
        return ResponseEntity.created(listURI().toUri()).build();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cakes
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Cake> cakes, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        getCakeService().save(cakes);
        
        return ResponseEntity.ok().build();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        
        getCakeService().delete(ids);
        
        return ResponseEntity.ok().build();
    }
}
