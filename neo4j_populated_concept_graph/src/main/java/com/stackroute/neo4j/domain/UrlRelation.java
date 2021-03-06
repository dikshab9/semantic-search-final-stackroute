package com.stackroute.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Comparator;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "url_of")
public class UrlRelation {

	@GraphId
	private Long id;

	private double basicsscore;

	private double tutorialscore;

	private double examplescore;

	private double completereferencesscore;

	private double troubleshootingsscore;

	private double gettingstartedsscore;

	@StartNode
	private UrlFromGoogle urlFromGoogle;

	@EndNode
	private Concept2 concept2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBasicsscore() {
		return basicsscore;
	}

	public void setBasicsscore(double basicsscore) {
		this.basicsscore = basicsscore;
	}

	public double getTutorialscore() {
		return tutorialscore;
	}

	public void setTutorialscore(double tutorialscore) {
		this.tutorialscore = tutorialscore;
	}

	public double getExamplescore() {
		return examplescore;
	}

	public void setExamplescore(double examplescore) {
		this.examplescore = examplescore;
	}

	public double getCompletereferencesscore() {
		return completereferencesscore;
	}

	public void setCompletereferencesscore(double completereferencesscore) {
		this.completereferencesscore = completereferencesscore;
	}

	public double getTroubleshootingsscore() {
		return troubleshootingsscore;
	}

	public void setTroubleshootingsscore(double troubleshootingsscore) {
		this.troubleshootingsscore = troubleshootingsscore;
	}

	public double getGettingstartedsscore() {
		return gettingstartedsscore;
	}

	public void setGettingstartedsscore(double gettingstartedsscore) {
		this.gettingstartedsscore = gettingstartedsscore;
	}

	public UrlFromGoogle getUrlFromGoogle() {
		return urlFromGoogle;
	}

	public void setUrlFromGoogle(UrlFromGoogle urlFromGoogle) {
		this.urlFromGoogle = urlFromGoogle;
	}

	public Concept2 getConcept2() {
		return concept2;
	}

	public void setConcept2(Concept2 concept2) {
		this.concept2 = concept2;
	}

	public UrlRelation() {
		super();
	}

	public UrlRelation(double basicsscore, double tutorialscore, double examplescore, double completereferencesscore,
			double troubleshootingsscore, double gettingstartedsscore, UrlFromGoogle urlFromGoogle, Concept2 concept2) {
		super();
		this.basicsscore = basicsscore;
		this.tutorialscore = tutorialscore;
		this.examplescore = examplescore;
		this.completereferencesscore = completereferencesscore;
		this.troubleshootingsscore = troubleshootingsscore;
		this.gettingstartedsscore = gettingstartedsscore;
		this.urlFromGoogle = urlFromGoogle;
		this.concept2 = concept2;
	}

	// @Override
	// public int compareTo(UrlRelation o) {
	// // TODO Auto-generated method stub
	// int compare=(int) ((UrlRelation) o).getBasicsscore();
	// return ((int)this.getBasicsscore()-compare);
	// }

	public static Comparator<UrlRelation> BasicScoreComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) (s1).getBasicsscore();
			int basic2 = (int) (s2).getBasicsscore();
			return basic1 - basic2;
		}
	};

	public static Comparator<UrlRelation> TutorialScoreComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) s1.getTutorialscore();
			int basic2 = (int) s2.getTutorialscore();
			return basic1 - basic2;
		}
	};

	public static Comparator<UrlRelation> ExamplesScoreComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) s1.getExamplescore();
			int basic2 = (int) s2.getExamplescore();
			return basic1 - basic2;
		}
	};

	public static Comparator<UrlRelation> GettingStartedScoreComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) s1.getGettingstartedsscore();
			int basic2 = (int) s2.getGettingstartedsscore();
			return basic1 - basic2;
		}
	};

	public static Comparator<UrlRelation> TroubleShootingScoreComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) s1.getTroubleshootingsscore();
			int basic2 = (int) s2.getTroubleshootingsscore();
			return basic1 - basic2;
		}
	};

	public static Comparator<UrlRelation> CompleteReferenceComparator = new Comparator<UrlRelation>() {

		public int compare(UrlRelation s1, UrlRelation s2) {
			int basic1 = (int) s1.getCompletereferencesscore();
			int basic2 = (int) s2.getCompletereferencesscore();
			return basic1 - basic2;
		}
	};

}