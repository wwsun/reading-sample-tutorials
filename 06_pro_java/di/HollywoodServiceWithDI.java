package me.wwsun.projava.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weiwei on 11/8/2014.
 */
public class HollywoodServiceWithDI {

    public static List<Agent> getFriendlyAgents(AgentFinder finder){
        List<Agent> agents = finder.findAllAgents();
        return filterAgents(agents,"Java Developers");
    }

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {

        List<Agent> filteredAgents = new ArrayList<>();
        for (Agent agent : agents) {
            if(agent.getType().equals("Java Developers")){
                filteredAgents.add(agent);
            }
        }

        return filteredAgents;
    }
}
