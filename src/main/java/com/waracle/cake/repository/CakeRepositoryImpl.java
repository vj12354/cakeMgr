package com.waracle.cake.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.waracle.cake.model.Cake;
import com.waracle.cake.model.QCake;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

@Transactional(readOnly = true)
/**
 * = CakeRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@Repository
public class CakeRepositoryImpl extends QueryDslRepositorySupportExt<Cake> implements CakeRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CakeRepositoryImpl() {
        super(Cake.class);
    }

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String IMAGE = "image";

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String DESCRIPTION = "description";

	/**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String TITLE = "title";

	/**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Cake> findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QCake cake = QCake.cake;
        JPQLQuery<Cake> query = from(cake);
        
        Path<?>[] paths = new Path<?>[] {cake.image,cake.description,cake.title};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(IMAGE, cake.image)
			.map(DESCRIPTION, cake.description)
			.map(TITLE, cake.title);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, cake);
    }
}