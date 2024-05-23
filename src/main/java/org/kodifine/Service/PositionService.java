package org.kodifine.Service;

import java.util.List;

import org.kodifine.Entity.Competence;
import org.kodifine.Entity.Position;
import org.kodifine.Repository.PositionRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
	
	@Autowired
	PositionRepositiory posiRepo;
	
	public Position save(Position p)
	{
		return posiRepo.save(p);
	}
	
	public List<Position> listPosi()
	{
		return posiRepo.findAll();
	}

}
