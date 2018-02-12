package com.waracle.cake.service.impl;
import com.waracle.cake.model.Cake;
import com.waracle.cake.repository.CakeRepository;
import com.waracle.cake.service.api.CakeService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
/**
 * = CakeServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
public class CakeServiceImpl implements CakeService {

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    private CakeRepository cakeRepository;

	/**
     * TODO Auto-generated constructor documentation
     * 
     * @param cakeRepository
     */
    @Autowired
    public CakeServiceImpl(CakeRepository cakeRepository) {
        setCakeRepository(cakeRepository);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return CakeRepository
     */
    public CakeRepository getCakeRepository() {
        return cakeRepository;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cakeRepository
     */
    public void setCakeRepository(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param cake
     */
    @Transactional
    public void delete(Cake cake) {
        getCakeRepository().delete(cake);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<Cake> save(Iterable<Cake> entities) {
        return getCakeRepository().save(entities);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Cake> toDelete = getCakeRepository().findAll(ids);
        getCakeRepository().deleteInBatch(toDelete);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Cake
     */
    @Transactional
    public Cake save(Cake entity) {
        return getCakeRepository().save(entity);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Cake
     */
    public Cake findOne(Long id) {
        return getCakeRepository().findOne(id);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Cake
     */
    public Cake findOneForUpdate(Long id) {
        return getCakeRepository().findOneDetached(id);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<Cake> findAll(Iterable<Long> ids) {
        return getCakeRepository().findAll(ids);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<Cake> findAll() {
        return getCakeRepository().findAll();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long count() {
        return getCakeRepository().count();
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Cake> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCakeRepository().findAll(globalSearch, pageable);
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Cake> getEntityType() {
        return Cake.class;
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
