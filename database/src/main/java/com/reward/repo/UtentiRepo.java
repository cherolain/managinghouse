package com.reward.repo;

import com.reward.entity.Premi;
import com.reward.entity.Tasks;
import com.reward.entity.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UtentiRepo extends JpaRepository<Utente, Integer> {

    Optional<Utente> findByNome(String s);

}
