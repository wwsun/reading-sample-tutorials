package me.wwsun.projava.ch3;

/**
 * Created by Weiwei on 11/8/2014.
 */
public class AgentFinderFactory {

    private static AgentFinderFactory factory;

    private AgentFinderFactory() {}

    //Singleton
    public static AgentFinderFactory getInstance() {
        if(factory==null){
            factory = new AgentFinderFactory();
        }
        return factory;
    }

    public AgentFinder getAgentFinder(String agentFinderType) {
        if(agentFinderType.equals("Spreadsheet")){
            return new SpreadsheetAgentFinder();
        }else if(agentFinderType.equals("WebService")){
            return new WebServiceAgentFinder();
        }else{
            return null;
        }
    }
}
