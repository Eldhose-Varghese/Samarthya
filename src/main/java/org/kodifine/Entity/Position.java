package org.kodifine.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int positionid;
	private String positionname;
	private String competence1;
	private String competence2;
	private String competence3;
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getCompetence1() {
		return competence1;
	}
	public void setCompetence1(String competence1) {
		this.competence1 = competence1;
	}
	public String getCompetence2() {
		return competence2;
	}
	public void setCompetence2(String competence2) {
		this.competence2 = competence2;
	}
	public String getCompetence3() {
		return competence3;
	}
	public void setCompetence3(String competence3) {
		this.competence3 = competence3;
	}

}
