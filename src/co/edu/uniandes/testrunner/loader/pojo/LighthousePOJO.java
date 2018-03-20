package co.edu.uniandes.testrunner.loader.pojo;

/**
 * POJO que contiene los datos relevantes del reporte Lighthouse para
 * Progressive Web Apps (PWA)
 * 
 * @author ms.puerto@uniandes.edu.co
 *
 */
public class LighthousePOJO extends POJO {

	private String userAgent;
	private String lighthouseVersion;
	private String initialUrl;
	private String serviceWorker;
	private String worksOffline;
	private Float score;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getLighthouseVersion() {
		return lighthouseVersion;
	}

	public void setLighthouseVersion(String lighthouseVersion) {
		this.lighthouseVersion = lighthouseVersion;
	}

	public String getInitialUrl() {
		return initialUrl;
	}

	public void setInitialUrl(String initialUrl) {
		this.initialUrl = initialUrl;
	}

	public String getServiceWorker() {
		return serviceWorker;
	}

	public void setServiceWorker(String serviceWorker) {
		this.serviceWorker = serviceWorker;
	}

	public String getWorksOffline() {
		return worksOffline;
	}

	public void setWorksOffline(String worksOffline) {
		this.worksOffline = worksOffline;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
