package org.kodifine.Service;

import java.util.List;

import org.kodifine.Entity.Competence;
import org.kodifine.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class CompetenceService {
	
	@Autowired
	CompetenceRepository compRepo;
	
	public Competence save(Competence c)
	{
		return compRepo.save(c);
	}
	
	public List<Competence> listComp()
	{
		return compRepo.findAll();
	}
	
	public String delete(int id)
	{
		compRepo.deleteById(id);
		return "customer deleted successfully";
	}
	
	public Competence retrieve(int id)
	{
		return compRepo.findById(id).get();
		
	}
	
	public Competence edit(Competence c)
	{
		Competence comp = null;
		if (compRepo.findById(c.getCompetenceid()).isPresent())
		{
			comp = compRepo.save(c);
		}
		return comp;
	}
	



}
