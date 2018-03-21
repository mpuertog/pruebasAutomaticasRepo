package co.edu.uniandes.testrunner.loader.pojo;

/**
 * {@link POJO} que contiene la información relevante a los pasos seguidos
 * durante la prueba E2E con Calabash
 * 
 * @author ms.puerto@uniandes.edu.co
 *
 */
public class CalabashAndroidStepPOJO {

	private String keyword;
	private String name;
	private String result;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
