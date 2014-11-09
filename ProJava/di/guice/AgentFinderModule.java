package me.wwsun.projava.ch3.guice;

import com.google.inject.AbstractModule;
import me.wwsun.projava.ch3.AgentFinder;
import me.wwsun.projava.ch3.WebServiceAgentFinder;

/**
 * Created by Weiwei on 11/8/2014.
 */
public class AgentFinderModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(WebServiceAgentFinder.class);
    }
}
