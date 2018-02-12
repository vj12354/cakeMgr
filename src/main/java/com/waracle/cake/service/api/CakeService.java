package com.waracle.cake.service.api;
import com.waracle.cake.model.Cake;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CakeService
 *
 * TODO Auto-generated class documentation
 *
 */
public interface CakeService extends EntityResolver<Cake, Long> {

	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Cake
     */
    public abstract Cake findOne(Long id);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     */
    public abstract void delete(Cake cake);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Cake> save(Iterable<Cake> entities);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Cake
     */
    public abstract Cake save(Cake entity);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Cake
     */
    public abstract Cake findOneForUpdate(Long id);


	/**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Cake> findAll(Iterable<Long> ids);


	/**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Cake> findAll();


	/**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long count();


	/**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Cake> findAll(GlobalSearch globalSearch, Pageable pageable);

}
