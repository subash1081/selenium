package com.omrbranch.hooks;




import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.omrbranch.utitity.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;




public class HooksClass extends BaseClass {




private static final Logger logger = LogManager.getLogger(HooksClass.class);




@Before

public void beforeScenario(Scenario scenario) throws IOException {




logger.info("==============================================");

logger.info("Scenario Started : {}", scenario.getName());

logger.info("==============================================");




// Read browser from config.properties

String browser = getPropertyFileValue("browser");




// Launch browser

browserLaunch(browser);




// Maximize browser

maximizeWindow();




// Implicit wait

implicitWait();




// Read URL from config.properties

String url = getPropertyFileValue("url");




// Enter application URL

enterApplicationUrl(url);

}




@AfterStep

public void afterStep(Scenario scenario) {




if (driver != null) {




logger.info("Capturing screenshot after step");




scenario.attach(screenshot(), "image/png", "Step Screenshot");

}

}




@After

public void afterScenario(Scenario scenario) {




if (scenario.isFailed()) {

logger.error("Scenario Failed : {}", scenario.getName());

} else {

logger.info("Scenario Passed : {}", scenario.getName());

}




if (driver != null) {




logger.info("Closing Browser");




closeAllBrowser();

}




logger.info("==============================================");

logger.info("Scenario Ended : {}", scenario.getName());

logger.info("==============================================");

}

}
