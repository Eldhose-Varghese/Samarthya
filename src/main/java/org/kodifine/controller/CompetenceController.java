package org.kodifine.controller;

import java.util.List;

import org.kodifine.Entity.Competence;
import org.kodifine.Entity.Position;
import org.kodifine.Service.CompetenceService;
import org.kodifine.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CompetenceController {
	
	@Autowired
	CompetenceService compServ;
	
	@Autowired
	PositionService posiServ;
	
	@GetMapping("/movetoaddcompetency")
    public String movetoaddcompetency()
    {
        return "AddCompetence";
    }
	
	@GetMapping("/senior/home")
	public String home()
	{
		return "SeniorHome";
	}
	@PostMapping("/senior/addComp")
	public String saveComp(Competence c)
	{
		compServ.save(c);
//		return custServ.save(c);
		return "redirect:/senior/viewComp";
	}
	@GetMapping("/senior/viewComp")
	public String viewComp(Model m)
	{
		List<Competence> compList = compServ.listComp();
		m.addAttribute("compDet", compList);
		return "ViewCompetence";
	}
	
	@GetMapping("/senior/deleteComp/{id}")
	public String deleteComp(@PathVariable("id") int id)
	{
		compServ.delete(id);
		return "redirect:/senior/viewComp";
	}
	
	@GetMapping("/senior/deletePosi/{id}")
	public String deletePosi(@PathVariable("id") int id)
	{
		posiServ.delete(id);
		return "redirect:/senior/viewPosi";
	}
	
	@GetMapping("/senior/editComp/{id}")
	public String ediCust(@PathVariable int id,Model m) {
		
		Competence c = compServ.retrieve(id);
		m.addAttribute("comp",c);
		return "EditCompetence";
	}
	
	@GetMapping("/senior/compDrop")
	public String viewCompDrop(Model m)
	{
		List<Competence> compList = compServ.listComp();
		m.addAttribute("compDet", compList);
		return "AddPosition";
	}
	
	@PostMapping("/senior/addPosi")
	public String addPosi(Position p)
	{
		posiServ.save(p);
		return "redirect:/senior/viewPosi";
	}
	
	@GetMapping("/senior/viewPosi")
	public String viewPosi(Model m)
	{
		List <Position> posiList = posiServ.listPosi();
		m.addAttribute("posiDet",posiList);
		return "ViewPosition";
	}

}
