// O que faz ligação do banco com a entidade

package com.uash.uash.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.uash.uash.model.Lavagem;
 
public interface LavagemRepository extends JpaRepository<Lavagem, Integer> {
 
}
