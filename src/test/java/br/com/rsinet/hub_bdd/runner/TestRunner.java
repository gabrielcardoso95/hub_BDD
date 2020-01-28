package br.com.rsinet.hub_bdd.runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature", 
		glue =  {"br.com.rsinet.hub_bdd.stepDefinition","br.com.rsinet.hub_bdd.utilities"} , 
		tags = "@CadastraUsuarioComSucesso",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/test-report.html" }, 
		monochrome = true)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("Gabriel", System.getProperty("user.name"));
		Reporter.setSystemInfo("SO", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		Reporter.addScreenCaptureFromPath("C:\\Users\\gabriel.cardoso\\workspace\\AvaliacaoBDD\\target\\screenshot\\Screenshot.png");
	}
}