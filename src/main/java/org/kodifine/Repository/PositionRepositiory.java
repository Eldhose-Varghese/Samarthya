package org.kodifine.Repository;

import org.kodifine.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepositiory extends JpaRepository<Position, Integer>{

}
