package me.wwsun.projava.ch3.guice;

import com.google.inject.Inject;
import me.wwsun.projava.ch3.Agent;
import me.wwsun.projava.ch3.AgentFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weiwei on 11/8/2014.
 */
public class HollywoodServiceGuice {
    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceGuice(AgentFinder finder){
        this.finder = finder;
    }

    public List<Agent> getFriendlyAgents(){
        List<Agent> agents = finder.findAllAgents();
        return filterAgents(agents, "Java Developers");
    }

    private List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<>();
        for (Agent agent : agents) {
            if(agent.getType().equals("Java Developers")){
                filteredAgents.add(agent);
            }
        }

        return filteredAgents;
    }
}
