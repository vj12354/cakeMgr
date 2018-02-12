package com.waracle.cake.repository;
import com.waracle.cake.model.Cake;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CakeRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
public interface CakeRepositoryCustom {

	/**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Cake> findAll(GlobalSearch globalSearch, Pageable pageable);

}
