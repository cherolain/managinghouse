package com.reward.repo;

import com.reward.entity.Premi;
import com.reward.entity.Ruolo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface RuoloRepo extends JpaRepository<Ruolo, Integer> {

}
