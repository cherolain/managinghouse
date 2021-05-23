package com.reward.repo;

import com.reward.entity.Premi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiRepo extends JpaRepository<Premi, Integer> {

    public Page<Premi> findAll(Pageable p);

    Page<Premi> findAllByRiscattatoFalse(Pageable pag);

    Page<Premi> findAllByRiscattatoTrue(Pageable pag);

}
