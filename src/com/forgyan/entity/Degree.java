package com.forgyan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_degree")
public class Degree {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="degree_id")
	private int degreeId;
	
	@Column(name="degree_name")
	private String degreeName;
	
	@Column(name="degree_type")
	private String degreeType;
	
	@Column(name="degree_start_date")
	private String degreeStartDate;
	
	@Column(name="degree_end_date")
	private String degreeEndDate;
	
	@Column(name="degree_grade")
	private String degreeGrade;
	
	@Column(name="degree_college")
	private String degreeCollege;
	
	@Column(name="degree_university")
	private String degreeUniversity;
	
	

	public Degree() {
		super();
	}

	
	public Degree(String degreeName, String degreeType, String degreeStartDate, String degreeEndDate,
			String degreeGrade, String degreeCollege, String degreeUniversity) {
		super();
		this.degreeName = degreeName;
		this.degreeType = degreeType;
		this.degreeStartDate = degreeStartDate;
		this.degreeEndDate = degreeEndDate;
		this.degreeGrade = degreeGrade;
		this.degreeCollege = degreeCollege;
		this.degreeUniversity = degreeUniversity;
	}


	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getDegreeStartDate() {
		return degreeStartDate;
	}

	public void setDegreeStartDate(String degreeStartDate) {
		this.degreeStartDate = degreeStartDate;
	}

	public String getDegreeEndDate() {
		return degreeEndDate;
	}

	public void setDegreeEndDate(String degreeEndDate) {
		this.degreeEndDate = degreeEndDate;
	}

	public String getDegreeGrade() {
		return degreeGrade;
	}

	public void setDegreeGrade(String degreeGrade) {
		this.degreeGrade = degreeGrade;
	}

	public String getDegreeCollege() {
		return degreeCollege;
	}

	public void setDegreeCollege(String degreeCollege) {
		this.degreeCollege = degreeCollege;
	}

	public String getDegreeUniversity() {
		return degreeUniversity;
	}

	public void setDegreeUniversity(String degreeUniversity) {
		this.degreeUniversity = degreeUniversity;
	}


	@Override
	public String toString() {
		return "Degree [degreeId=" + degreeId + ", degreeName=" + degreeName + ", degreeType=" + degreeType
				+ ", degreeStartDate=" + degreeStartDate + ", degreeEndDate=" + degreeEndDate + ", degreeGrade="
				+ degreeGrade + ", degreeCollege=" + degreeCollege + ", degreeUniversity=" + degreeUniversity + "]";
	}




	

}
