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
public class Competence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int competenceid;
	private String competencename;
	private String competencedescription;
	public int getCompetenceid() {
		return competenceid;
	}
	public void setCompetenceid(int competenceid) {
		this.competenceid = competenceid;
	}
	public String getCompetencename() {
		return competencename;
	}
	public void setCompetencename(String competencename) {
		this.competencename = competencename;
	}
	public String getCompetencedescription() {
		return competencedescription;
	}
	public void setCompetencedescription(String competencedescription) {
		this.competencedescription = competencedescription;
	}

}
