package ar.edu.unq.poo2.tpfinal;

public class Area {
	private Point center;
	private Integer radius;
	public Area(Point center, Integer radius) {
	
		this.center = center;
		this.radius = radius;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public Integer getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	
}
