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
	
	@GetMapping("/comp")
	public String home()
	{
		return "AddCompetence";
	}
	@PostMapping("/addComp")
	public String saveComp(Competence c)
	{
		compServ.save(c);
//		return custServ.save(c);
		return "redirect:/viewComp";
	}
	@GetMapping("/viewComp")
	public String viewComp(Model m)
	{
		List<Competence> compList = compServ.listComp();
		m.addAttribute("compDet", compList);
		return "ViewCompetence";
	}
	
	@GetMapping("/deleteComp/{id}")
	public String deleteComp(@PathVariable("id") int id)
	{
		compServ.delete(id);
		return "redirect:/viewComp";
	}
	
	@GetMapping("/editComp/{id}")
	public String ediCust(@PathVariable int id,Model m) {
		
		Competence c = compServ.retrieve(id);
		m.addAttribute("comp",c);
		return "EditCompetence";
	}
	
	@GetMapping("/viewComp/drop")
	public String viewCompDrop(Model m)
	{
		List<Competence> compList = compServ.listComp();
		m.addAttribute("compDet", compList);
		return "AddPosition";
	}
	
	@PostMapping("/addPosi")
	public String addPosi(Position p)
	{
		posiServ.save(p);
		return "redirect:/viewPosi";
	}
	
	@GetMapping("/viewPosi")
	public String viewPosi(Model m)
	{
		List <Position> posiList = posiServ.listPosi();
		m.addAttribute("posiDet",posiList);
		return "ViewPosition";
	}

}
