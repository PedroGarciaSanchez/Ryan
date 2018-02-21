package net.ryanair.tests;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

public class RyanScenario extends JUnitStory {
//public class ATMScenario extends JUnitStories {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                        // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.CONSOLE, StoryReporterBuilder.Format.TXT, StoryReporterBuilder.Format.HTML, StoryReporterBuilder.Format.XML));
    }

    // Here we specify the steps classes
    @Override
    public List<CandidateSteps> candidateSteps() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new RyanScenarioSteps()).createCandidateSteps();
    }
    
    //ESTE METODO ES SOLO PARA extends JUnitStories

	
//	 @Override
//	    protected List<String> storyPaths() {
//	    //    return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/stories/*.story", "");
//	    //    return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "*/*.story", "");
//	    //    return new StoryFinder().findPaths("*/*.story", "");
//		 String storyProperty = System.getProperty("story");
//	        String storyPatternToRun;
//	        if (storyProperty == null || StringUtils.isEmpty(storyProperty)) {
//	            storyPatternToRun = "**/*.story";
//	        }
//	        else {
//	            storyPatternToRun = "**/" + storyProperty;
//	        }
//	        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), storyPatternToRun, "**/*.story");
//	    }

//
}