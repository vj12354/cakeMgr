package com.waracle.cake.repository;
import com.waracle.cake.model.Cake;
import io.springlets.data.jpa.repository.DetachableJpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
/**
 * = CakeRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface CakeRepository extends DetachableJpaRepository<Cake, Long>, CakeRepositoryCustom {
}
