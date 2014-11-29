package me.wwsun.projava.ch3.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.wwsun.projava.ch3.Agent;

import java.util.List;

/**
 * Created by Weiwei on 11/8/2014.
 */
public class HollywoodServiceClient {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodServiceGuice = injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodServiceGuice.getFriendlyAgents();
    }
}
