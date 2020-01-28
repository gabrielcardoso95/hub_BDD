package cucumber;

import br.com.rsinet.hub_bdd.managers.PageObjectManager;
import br.com.rsinet.hub_bdd.managers.WebDriverManager;

public class TestContext {
		private WebDriverManager webDriverManager;
		private PageObjectManager pageObjectManager;
		private ScenarioContext scenarioContext;
		
		public TestContext() {
			webDriverManager=new WebDriverManager();
			pageObjectManager=new PageObjectManager(webDriverManager.getDriver());
		    scenarioContext=new ScenarioContext();
		}
		
		public WebDriverManager getWebDriverManager() {
			return webDriverManager;
		}
		
		public PageObjectManager getPageObjectManager() {
			return pageObjectManager;
		}
		
		public ScenarioContext getScenarioContext() {
			return scenarioContext;
		}
}
