package suit;

import java.io.File;
import java.util.ArrayList;


import org.testng.TestNG;

public class mainclasstest {

	public static void main(String[] args) {

		global_utility.Mailer mailing=new global_utility.Mailer();
		TestNG runner=new TestNG();
		ArrayList<String> suitefiles=new ArrayList<String>();
		File SourcePath=new File(System.getProperty("user.dir"));
		suitefiles.add(SourcePath.getAbsolutePath()+"/testng.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
		mailing.MailtoQC();
	}

}
