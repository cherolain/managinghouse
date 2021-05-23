package com.reward.repo;

import com.reward.entity.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TaskRepo extends JpaRepository<Tasks, Integer> {
    public Optional<Tasks> findById(int d);

    public void deleteById(int id);

    public Page<Tasks> findAllByCompletatoFalse(Pageable pageable);

    Page<Tasks> findAllByCompletatoTrue(Pageable pag);

}
