package spotiFy;

public class Artist {
	private String name;

	private Integer age;

	private String nacionality;

	public Artist(String name, Integer age, String nacionality) {
		
		this.name = name;
		this.age = age;
		this.nacionality = nacionality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

}
